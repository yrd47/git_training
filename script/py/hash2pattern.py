#!/usr/bin/env python

#输入输出模块
import sys
#正则表达式模块
import re
#os模块包含普遍的操作系统功能
import os

athena_pattern_map = {}
#列出/data/log下的目录和文件
for appid in os.listdir('/data/log') :
    if not re.match(r"^me.ele.arch.das", appid):
        continue
    filepath = '/data/log/' + appid + '/athena_pattern_map.log'
    #检验给出的路径是否是一个文件
    if not os.path.isfile(filepath) :
        continue
    #异常处理     
    with open(filepath) as f:
        for line in f :
            #d56b699830e77ba53855679cb1d252da#login
            #4d1be62bbe7c992dcf1b10e9e0c6f35d#SELECT next_value FROM dal_dual WHERE seq_name = ? AND task_hash = ? AND order_id = ?
            #2表示分割次数
            hash_pattern_pair = line.split('#', 2)
            #strip（）参数为空默认删除空白符（包括‘\n’,'\r','\t',''）
            athena_pattern_map[ hash_pattern_pair[0].strip() ] = hash_pattern_pair[1].strip()


def transfer(m):
    hashcode = m.group()[5:]
    return m.group()[:5] + athena_pattern_map.get(hashcode,hashcode)

if __name__ == '__main__':
    while 1:
        try:
            line = sys.stdin.readline()
        except KeyboardInterrupt:
            break
        if not line:
            break
        #等价于print ‘’ 打印到控制台 ；   re.sub  正则的替换    三个必选参数：pattern，repl，string    
        sys.stdout.write(re.sub(r' => \[[\w\d]+', transfer, line))