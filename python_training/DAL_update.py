#! /usr/bin/python
# coding=utf-8

__author__ = 'ridan.yuan@ele.me'

from fabric.api import *
import os
import sys

def update_auto():
    print("-----------package-------------")
    local('mvn clean package')
    print("-----------upload athena-core-4.0.0.tar--------------")
    put("/Users/yrd/athena/athena-core/target/athena-core-4.0.0.tar", "/data/me.ele.arch.das.auto")
    with cd("/data/me.ele.arch.das.auto"):
        run("./run.sh stop")
        run("tar xf athena-core-4.0.0.tar")
        run("sed -i 's/me.ele.arch.das.misc/me.ele.arch.das.lz/g' `find . -type f`")
        run("cp athena.properties conf/")
        run("./run.sh start")

def auto():
    env.abort_on_prompts = True
    env.hosts = "192.168.65.25"
    env.port = "22"
    env.user = "www-data"
    env.password = "1qaz@WSX"
    execute(update_auto())

def main():
    print 1
    auto()

if __name__ == '__main__':
    main()