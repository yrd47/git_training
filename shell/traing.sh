#!/bin/bash
echo "Hello World"

array=()
i=0
for file in `ls /Users/yrd/Desktop`;
do
	echo $i
	array[$i]=$file
#	echo $file
	i=`expr $i + 1`
done
echo $i
echo ${array[@]}
