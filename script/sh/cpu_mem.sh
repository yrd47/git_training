#!/bin/sh
service_name=$1
service_pid=`ps -ef | grep -i ${service_name} | grep -v grep | grep java | awk '{print $2}'`

interval=$2

duration=`expr $3 \* 60`

thread_num=$4

tool_dir=$5

echo "Test will  last " $duration "seconds"
times=`expr $duration \/ $2`
echo "times" $times

startime=`date +%y%m%d%H%M%S`
jstat_monitor(){
	for pid in ${service_pid}
	do
	 echo "Start monitor jstat......"
         jstat_log="${tool_dir}/jstat_${thread_num}_${startime}_${pid}.log"
         nohup /usr/jdk1.8.0_45/bin/jstat -gc ${pid} ${interval}s ${times} >> ${jstat_log} &
	done
}

cpu_monitor(){

	for pid in ${service_pid}
	do
	     echo "Start monitor cpu usage......"
             cpu_log="${tool_dir}/cpu_${thread_num}_${startime}_${pid}.log"
	     nohup top -b -p ${pid} -d ${interval} -n ${times} | grep ${pid} >> ${cpu_log} &
        done
}

jstat_monitor

cpu_monitor
