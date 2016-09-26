#coding=utf-8
import pymysql
import time
import thread_test
import sys

__author__ = 'yrd'

def pymysql_test():
    db = pymysql.connect(host='192.168.80.19', port=3308, user='root', passwd='root', db='yuanridandb')
    cursor = db.cursor()
    cursor.execute("select version()")
    data = cursor.fetchone()
    print ("Database version : %s" % data)
    db.close()

def timer(no,interval):
    cnt=0
    while cnt<10:
        print 'Thread:(%d) cnt:(%d) Time:%s\n' % (no,cnt,time.ctime())
        time.sleep(interval)
        cnt+=1
    thread_test.exit_thread()

def thread_test():
    # Use thread.start_new_thread() to create 2 new threads
    thread_test.start_new_thread(timer,(1,1))
    thread_test.start_new_thread(timer,(2,2))

if __name__ == '__main__':
#    pymysql_test()
    thread_test()
    #不加这行会报错，线程管理程序找不到timer方法的引用
    time.sleep(10)
    print 'main thread exit...\n'


