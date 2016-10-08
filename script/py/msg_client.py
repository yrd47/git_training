# coding=utf-8
from __future__ import division
import os
import re
import sys
import time
import base64
import urllib
import socket
import zipfile
import requests
#argparse是python用于解析命令行参数和选项的标准模块
import argparse
import threading
from xmlrpclib import ServerProxy
from fabric.api import execute, env, run, put, get, hide
from wiki_request import PAGE_NAME, WIKI_URL, FIELDS, PAYLOAD, HEADERS


__author__ = "jiaqi.yan@ele.me"
BASE_PATH = os.path.abspath(os.path.dirname(__file__))
REPORT_HTML = os.path.join(BASE_PATH, 'report.html')
HOSTNAME = socket.gethostname()
DATA_FOLDER_LIMIT = 6291456 # 6G

# msg
MSG_HOSTNAME = "vpct-arch-lpt-result-1.vm.elenet.me"
MSG_PORT = 11111
# ssh
SSH_RESULT_FOLDER = "/data/repository/result"
env.hosts = [MSG_HOSTNAME]
env.user = "www-data"
env.password = base64.decodestring("MXFhekBXU1g=")


def get_arguments():
    parser = argparse.ArgumentParser(description='NOTE: if -w/--wiki required, -U USER -P PASSWORD',
        epilog="if -w input, below arguments are required: \
        -U USER, wiki username; -P PASSWORD, wiki password; -L LINK, wiki link\
        这些参数用一遍要记住，不要每次来这看我一遍！\(^o^)/")
    parser.add_argument('--version', action='version', version='%(prog)s 1.0')
    parser.add_argument("-p", "--project", help="the project which the logs belong to", required=True)
    #通过本地数据生成报告
    parser.add_argument("-d", "--data_folder", help="the path of log data folder.", required=False)
    #通过专用数据服务器上数据生成报告
    parser.add_argument("-r", "--remote_folder", help="where results stored on server.", required=False)
    #直接把所给文件的内容加到wiki里
    parser.add_argument("-f", "--report_file", help="need to generate report file.", required=False)
    parser.add_argument("-c", "--core_num", type=int, default=8, help="core number, if not given, default is 8.", required=False)
    parser.add_argument("-i", "--interval", type=int, default=5, help="interval time for log, default is 5", required=False)
    parser.add_argument("-s", "--show", default="12", help="show curve pictures, default is 12, 1 stands for cpu; \
                        2 stands for heap; 3 stands for MEM; 4 stands for MU; 5 stands for RabbitMQ; 6 stands \
                        for python cpu; 7 stands for python mem; 8 stands for redis; 9 stands for conn.", required=False)
    parser.add_argument("-q", "--show_mq_line", default="1234", help="show lines in picture, default is 1234, 1 stands for ack_detail; \
           2 stands for deliver_details; 3 stands for deliver_get_details; 4 stands for publish_details.", required=False)
    parser.add_argument("-R", "--show_redis_line", default="123456", help="show lines in picture, default is 123456, 1 stands for connected_clients; \
           2 stands for used_memory; 3 stands for rdb_last_bgsave_time_sec; 4 stands for keyspace_hits_rate; \
           5 stands for keyspace_misses_rate; 6 stands for key_num.", required=False)
    parser.add_argument("-w", "--wiki", help="upload report to wiki", action='store_true', default=False)
    args = parser.parse_known_args()[0]
    if args.wiki:
        parser.add_argument("-U", "--user", help="wiki username", required=True)
        parser.add_argument("-P", "--password", help="wiki password", required=True)
        parser.add_argument("-L", "--link", help="wiki link", required=True)
    args = parser.parse_args()
    return args

def do_check(remote_result_folder):
    try:
        run('ls %s' % remote_result_folder)
        return True
    except:
        return False

def check_remote_folder(remote_result_folder):
    with hide('aborts', 'stdout', 'running'):
        is_exist = execute(do_check, remote_result_folder).values()[0]
    return is_exist

def do_rename(remote_result_folder):
    if remote_result_folder.find('wiki') == -1:
        folder_name = os.path.basename(remote_result_folder)
        new_folder_name = 'wiki_' + folder_name
        remote_wiki_result_folder = os.path.join(os.path.dirname(remote_result_folder), new_folder_name)
        run("mv %s %s" % (remote_result_folder, remote_wiki_result_folder))
    else:
        remote_wiki_result_folder = remote_result_folder
    return remote_wiki_result_folder

def rename_remote_folder(remote_result_folder):
    with hide('aborts', 'stdout', 'running'):
        remote_result_folder = execute(do_rename, remote_result_folder).values()[0]
    return remote_result_folder

def upload_background(zip_file_name, remote_project_foler):
    put(zip_file_name, remote_project_foler)

def calculate_upload_percent(zip_file_size, remote_data_zip_path, upload):
    print "start to upload results, wait..."
    bar_length = 20
    time.sleep(1)
    while 1:
        upload_size = run("du -sk %s | cut -f1" % remote_data_zip_path)
        upload_size = int(str(upload_size))
        upload_percent = round(upload_size/zip_file_size, 2) * 100
        hashes = '#' * int(upload_percent/100.0 * bar_length)
        spaces = ' ' * (bar_length - len(hashes))
        sys.stdout.write("\rUpload Percent: [%s] %d%%"%(hashes + spaces, upload_percent))
        sys.stdout.flush()
        if upload_percent == 100:
            print "\n"
            break
        time.sleep(1)
    while 1:
        if upload.isAlive():
            time.sleep(1)
        else:
            break
    print "upload data finished!"

def compress_data(local_data_foler):
    print "start to compress %s, wait..." % local_data_foler
    time_str = time.strftime("%Y-%m-%d-%H-%M-%S", time.localtime())
    zip_file_name = local_data_foler[:-1] + '_' + time_str + '.zip'
    with zipfile.ZipFile(zip_file_name,'w',zipfile.ZIP_DEFLATED) as f:
        abs_src = os.path.abspath(local_data_foler)
        for root, _, files in os.walk(abs_src):
            for new_file in files:
                absname = os.path.join(root, new_file)
                arcname = absname[len(abs_src)+1:]
                f.write(absname, arcname)
    print "finish compressing, file: %s" % zip_file_name
    return zip_file_name

def do_upload(local_data_foler, project):
    total_size = int(os.popen("du -sk %s | cut -f1" % local_data_foler).read())
    if total_size > DATA_FOLDER_LIMIT:
        print "ERROR: [-d DATA_FOLDER]: size is beyond the LIMIT!"
        sys.exit(1)
    else:
        remote_project_foler = os.path.join(SSH_RESULT_FOLDER, project)
        run("mkdir -p %s" % remote_project_foler)
        zip_file_name = compress_data(local_data_foler)
        remote_data_zip_path = os.path.join(remote_project_foler, os.path.basename(zip_file_name))
        zip_file_size = int(os.popen("du -sk %s | cut -f1" % zip_file_name).read())
        upload = threading.Thread(target=upload_background, args=(zip_file_name, remote_project_foler))
        upload.start()
        calculate_upload_percent(zip_file_size, remote_data_zip_path, upload)
        os.remove(zip_file_name)
        return remote_data_zip_path

def upload_results(local_data_foler, project):
    try:
        with hide('aborts', 'stdout', 'running'):
            remote_result_folder = execute(do_upload, local_data_foler, project).values()[0]
        return remote_result_folder
    except Exception as e:
        print "compress&&upload data failed: %s" % str(e)
        sys.exit(1)
    
def send_msg(remote_result_folder, core_num, show, show_mq_line, show_redis_line, project, interval, wiki):
    try:
        print "start to generate html report, wait..."
        svr = ServerProxy("http://%s:%s" % (MSG_HOSTNAME, str(MSG_PORT)), allow_none=True)
        report_url = svr.generate_html(remote_result_folder, core_num, show, show_mq_line, show_redis_line, project, interval, wiki, HOSTNAME)
        if report_url:
            print "generate html report done!"
        else:
            print "generate html report fail!"
        print report_url
        return report_url
    except Exception,e:
        print "generate html report fail: %s" % str(e)
        sys.exit(1)

def search_result_list(project):
    result_list = []
    url = 'http://%s/result/%s/' % (MSG_HOSTNAME, project)
    try:
        r = urllib.urlopen(url)
    except:
        print "ERROR: %s: this project not existed on server." % project
        sys.exit(1)
    print "All the results of project %s as below:" % project
    for line in r:
        m = re.match('.+\[DIR\].+href="(.+)/".+', line)
        if m:
            print m.group(1)
            result_list.append(m.group(1))
    if len(result_list) == 0:
        print "%s: this project has no any results on server." % project

def do_download(report_url):
    remote_report_path = report_url.split('Report URL:')[1].strip().replace(\
            'http://%s' % MSG_HOSTNAME, '/data/repository')
    local_report_path = REPORT_HTML
    if os.path.exists(local_report_path):
        os.remove(local_report_path)
    # print remote_report_path
    # print local_report_path
    get(remote_report_path, local_report_path)

def download_report(report_url):
    with hide('aborts', 'stdout', 'running'):
        execute(do_download, report_url)

def warm_up(user, password):
    token = ""
    jsessionid = ""
    warmup_url = "http://wiki.ele.to:8090"
    r = requests.get(warmup_url, auth=(user, password))
    s = re.search('ajs-atl-token.+content=\"(\w+)\".+', r.content)
    if s:
        token = s.group(1)
        # print token
    if not token:
        print "ERROR: please check your wiki username and password."
        sys.exit(1)
    m = re.match('.+JSESSIONID=(\w+).+', str(r.cookies))
    if m:
        jsessionid = m.group(1)
        # print jsessionid
    return token, jsessionid

def get_info_by_wiki_link(user, password, link):
    page_id = ""
    dep = ""
    parent_page_name = ""
    r = requests.get(link, auth=(user, password))
    content = re.sub('\n', ' ', r.content)
    m = re.match('.+name="ajs-page-id" content="(\d+)".+name="wikilink" content="\[(\w+):(.+)\]"', content)
    if m:
        page_id = m.group(1)
        dep = m.group(2)
        parent_page_name = m.group(3)
        return page_id, dep, parent_page_name
    if page_id and dep and parent_page_name:
        pass
    else:
        print "ERROR: please check the wiki link you input."
        sys.exit(1)

def update_header_payload(user, password, link):
    global PAYLOAD, HEADERS
    token, jsessionid = warm_up(user, password)
    page_id, dep, parent_page_name = get_info_by_wiki_link(user, password, link)
    PAYLOAD['atl_token'] = token
    query_string = "spaceKey=%s&amp;fromPageId=%s&amp;src=quick-create" % (dep, page_id)
    PAYLOAD['queryString'] = query_string
    PAYLOAD['fromPageId'] = page_id
    PAYLOAD['spaceKey'] = dep
    PAYLOAD['originalReferrer'] = link
    PAYLOAD['parentPageString'] = parent_page_name
    PAYLOAD['newSpaceKey'] = dep
    cookie = "confluence-sidebar.width=285; JSESSIONID=%s" % jsessionid
    HEADERS['cookie'] = cookie

def create_report_on_wiki(report_file):
    if not os.path.exists(report_file):
        print "Error: Can't find %s." % report_file
        sys.exit(1)
    else:
        with open(report_file) as f:
            html_content = f.read()
        PAYLOAD["wysiwygContent"] = html_content
        payload_str = ""
        for field in FIELDS:
            payload_str += '%s=' % field
            payload_str += '%s&' % urllib.quote(PAYLOAD[field])
        response = requests.post(WIKI_URL, data=payload_str[:-1], headers=HEADERS)
        if str(response.status_code) == '200':
            wiki_page = "http://wiki.ele.to:8090/display/kuangjiagongju/%s" % PAGE_NAME
            print "Success: Create report on wiki successfully!"
            print "Wiki URL: %s" % wiki_page
        else:
            print "Error: Create report on wiki fail! Status code: %s" % str(response.status_code)
            sys.exit(1)

def main():
    args = get_arguments()
    #判断要进行的操作是否为以下三个的一种
    if args.data_folder or args.remote_folder or args.report_file:
        if not args.report_file:
            #通过专用数据服务器上数据生成报告
            if args.remote_folder:
                remote_result_folder = os.path.join('/data/repository/result', args.project.lower(), args.remote_folder)
                if not check_remote_folder(remote_result_folder):
                    print "ERROR: %s: No such directory in '%s' project on server;" % (args.remote_folder, args.project)
                    print "You can use command 'python msg_client.py -p %s' to search." % args.project
                    sys.exit(1)
                else:
                    if args.wiki:
                        remote_result_folder = rename_remote_folder(remote_result_folder)
            #通过本地数据生成报告
            else:
                local_data_foler = args.data_folder if args.data_folder.endswith('/') else args.data_folder+'/'
                if not os.path.isdir(local_data_foler):
                    print "ERROR: %s: No such directory." % local_data_foler
                    sys.exit(1)
                remote_result_folder = upload_results(local_data_foler, args.project.lower())
            report_url = send_msg(remote_result_folder, args.core_num, args.show, args.show_mq_line, \
                    args.show_redis_line,args.project.lower(), args.interval, args.wiki)
            if args.wiki and report_url:
                download_report(report_url)
                update_header_payload(args.user, args.password, args.link)
                create_report_on_wiki(REPORT_HTML)
        #直接把所给文件的内容加到wiki里
        else:
            if args.wiki:
                update_header_payload(args.user, args.password, args.link)
                create_report_on_wiki(args.report_file)
            else:
                print "Warning: Generate wiki need -w, if -w/--wiki required, -U USER -P PASSWORD."
                sys.exit(1)
    else:
        search_result_list(args.project.lower())

if __name__ == "__main__":
    main()