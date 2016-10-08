#!/bin/bash
file="processlist.txt"
if [ -f "$file" ];then
rm -rf $file
fi
while true
do
#  tmp=`mysql -h10.105.34.86 -P3306 -uroot -pMiu8eHnrB4QAHg9B -e "show full processlist" |grep "10.148.64.97"|cut -f1|sed -e 's/^/kill /;s/$/;/'|sort -R|head -10`
#  tmp1=`mysql -h10.66.131.118 -P3306 -udt_tester -pMiu8eHnrB4QAHg9B -e "show full processlist"|grep "10.148.64.97"|grep -v Killed|cut -f1|sed -e 's/^/kill /;s/$/;/'|sort -R`
  tmp=`mysql -h10.105.34.86 -P3306 -uroot -pMiu8eHnrB4QAHg9B -e "show full processlist" |grep "10.148.64.97"|grep -v Killed|cut -f1|sed -e 's/^/kill /;s/$/;/'|sort -R`
  tmp1=`mysql -h10.66.131.118 -P3306 -udt_tester -pMiu8eHnrB4QAHg9B -e "show full processlist" |grep "10.148.64.97"|grep -v Killed|cut -f1|sed -e 's/^/kill /;s/$/;/'|sort -R`
  sleep 1 
  mysql -h10.105.34.86 -P3306 -uroot -pMiu8eHnrB4QAHg9B -e "$tmp"
  mysql -h10.66.131.118 -P3306 -udt_tester -pMiu8eHnrB4QAHg9B -e "$tmp1"
  echo `mysql -h10.105.34.86 -P3306 -uroot -pMiu8eHnrB4QAHg9B -e "show full processlist" |grep "10.148.64.97"|wc -l` DB86>> $file
  echo `mysql -h10.66.131.118 -P3306 -udt_tester -pMiu8eHnrB4QAHg9B -e "show full processlist" |grep "10.148.64.97"|wc -l` DB118>> $file
done
