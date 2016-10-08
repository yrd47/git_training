#!/bin/sh

thread_file=./thread.conf


function help_fun()
{
   echo "==========================please follow this step======================"
   echo "1.set the thread num for each round in the thread.conf file"
   echo "2.please give your service name and run time for each round,make sure this name can be used to find your service id,like ps -ef|grep SERVICE_NAME"
   echo "3. nohup ./run.sh SERVICE_NAME RUN_TIME_FOR_EACH_ROUND &"         
}

if [ ! -f $thread_file ];then
   echo "make sure the thread.conf has the thread num for each round"   
   exit 1
else
    thread_number=`cat ./thread.conf`
fi

if [ -z "$1" ];then
   help_fun 
   exit 1
fi

if [ -z "$2" ];then
   help_fun
   exit 1
fi


for num in ${thread_number}
do
	./runLPTest.sh $1 $num $2
    echo "==================================threads are $num done============================================"
done
