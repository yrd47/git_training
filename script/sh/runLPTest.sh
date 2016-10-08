#!/bin/sh

#jmeter client ip address
send_ip="10.131.214.108"

send_ssh_port="22"

#target service ip address 04
#yrd 04
load_test_ip="10.148.64.97"

loadtest_ssh_port="22"

test_service=$1
thread_num=$2
durnation=$3
#yrd 区间，间隔
interval="5"

#01上存放jmx的目录
remote_testcase_dir="/data/test/jmetertestcase/${test_service}";
#04上存放监控结果的目录
remote_monitor_dir="/data/test/tool/${test_service}";
#上级存放脚本的目录
testcase_template_dir="../${test_service}"

local_jmx_file=""

testcase_name=""

csv_file_name=""

new_testcase_dir="../${test_service}/tmp/${thread_num}"

lp_testcase_tar="${test_service}_${thread_num}.tar"

jmeter_sh="/data/apache-jmeter-2.13/bin/jmeter.sh"

remote_jmx_file=""

jtl_file="${remote_testcase_dir}/${thread_num}/${test_service}_${thread_num}.jtl"

function startup(){
          
	 jmx_file_number=`ls -l ${testcase_template_dir} | grep "\.jmx" | awk '{print $9}' |wc -l`
	
	if [ ${jmx_file_number} -ne 1 ];then
		echo "Error: jmx file error, only need one jmx file"
		exit 1
	else
		testcase_name=`ls -l ${testcase_template_dir} | grep "\.jmx" | awk '{print $9}'`
	fi
	
	local_jmx_file="../${test_service}/${testcase_name}"
	remote_jmx_file="${remote_testcase_dir}/${thread_num}/${test_service}_${thread_num}.jmx"
	
}

#check for dir for load test machine
function checkDirForLoadTest(){
	for load_ip in ${load_test_ip}
	do
		ssh  ${load_ip} "if [ ! -d ${remote_monitor_dir} ];then mkdir -p ${remote_monitor_dir}; fi"
        done
}

function checkDirForCaseSender(){
        for s_ip in ${send_ip}
        do
	     ssh ${s_ip} "if [ ! -d ${remote_testcase_dir} ];then mkdir -p ${remote_testcase_dir}; fi"
        done
 
}

function scpTestMonitorTool(){
	for load_ip in ${load_test_ip}
	do
        echo ----------------scp monitor tool to ${load_ip}---------------------
#  	    ssh ${load_ip} "rm ${remote_monitor_dir}/*.log"
        scp  cpu_mem.sh ${load_ip}:${remote_monitor_dir}
        done
}

function updateTestcase(){
	update_testCase_script="./updateLPTestcase.sh"
	
	if [ -f ${update_testCase_script} ];then
		./updateLPTestcase.sh ${test_service} ${thread_num} ${durnation} ${local_jmx_file} ${new_testcase_dir}
	else
		echo "Can't update the testcase template"
	fi
	if [ -f ${lp_testcase_tar} ];then
		rm -rf ${lp_testcase_tar}
	fi
#tar the new test case
        new_testcase="${new_testcase_dir}/${test_service}_${thread_num}.jmx"

        if [ -f ${new_testcase} ];then
                cd ${new_testcase_dir}; cd ..
                tar cvf ${test_service}_${thread_num}.tar ${thread_num}
        else
                echo "Error: Can't find the LP test case"
        fi	
}

function scpLPTestcase(){
        for s_ip in ${send_ip}
        do	
        	scp  ${lp_testcase_tar}  ${s_ip}:${remote_testcase_dir}
	done	
}

function runLPTestcase(){
        for s_ip in ${send_ip}
        do
	#tar the test case
	ssh  ${s_ip} "if [  -d ${remote_testcase_dir}/${thread_num} ];then rm -rf ${remote_testcase_dir}/${thread_num}; fi; cd ${remote_testcase_dir}; tar xvf ${lp_testcase_tar}"
	
	#run the testcase
#        ssh  ${s_ip} "nohup ${jmeter_sh} -n -t ${remote_jmx_file} -l ${jtl_file} &"
        ssh  ${s_ip} "nohup ${jmeter_sh} -n -t ${remote_jmx_file}  &"
        done 
        rm -rf ${test_service}_${thread_num}.tar
}

function runMonitorTool(){
        
        for load_ip in ${load_test_ip}
	do
            echo ----------------run monitor tool on ${load_ip}---------------------
            service_pid=`ssh ${load_ip} "ps -ef | grep -i ${test_service} | grep -v grep | grep java | awk '{print $2}'"`
            if [ -z "$service_pid" ];then
               echo "there is no any useful ${test_service} process,please check the service_name you give!!!!!"
               exit 1
            fi 
		ssh  ${load_ip} "${remote_monitor_dir}/cpu_mem.sh ${test_service} ${interval} ${durnation} ${thread_num} ${remote_monitor_dir} &"
        done
}

#find jmx test case
startup

echo "=================checkDirForLoadTest================="
checkDirForLoadTest
echo "=================checkDirForCaseSender================="
checkDirForCaseSender
echo "=================scpTestMonitorTool================="
scpTestMonitorTool
echo "=================updateTestcase================="
updateTestcase
echo "=================scpLPTestcase================="
scpLPTestcase
echo "=================runMonitorTool================="
runMonitorTool
echo "=================runLPTestcase================="
runLPTestcase
echo "================end testing=================="

