#-*- coding: UTF-8 -*-
import pymysql

__author__ = 'shzheng.li@ele.me'

class CreateAutotestDB():

    connection=None
    curl=None
    dbs=["main_db","dalDB_master","dalDB_slave1","dalDB_slave2"]

    def __init__(self):
        self.connection = pymysql.connect(host='192.168.65.25', port=3306, user='leoyan', passwd='123456', db='')
        self.curl = self.connection.cursor()

    def __del__(self):
        self.curl.close()
        self.connection.close()

    def create(self):
        for db in self.dbs:
            self.curl.execute("create database %s" % db)
            self.curl.execute("use %s" % db)
            self.curl.execute("create table student(`id` bigint(20) NOT NULL,`description` VARCHAR (255) NOT NULL)")
            self.curl.execute("insert into student (id,description) VALUES (0,'%s')" % db[-6:])
            # if db == 'dalDB_master':
            self.curl.execute("CREATE TABLE `dal_sequences` (`id` bigint(20) NOT NULL,`seq_name` varchar(64) DEFAULT NULL,`last_value` bigint(19) DEFAULT NULL,`is_delete` tinyint(4) DEFAULT NULL,`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,`updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',PRIMARY KEY (`id`))")
            self.curl.execute("insert into dal_sequences(id,seq_name,last_value,is_delete) values(1,'eleme_order_orderid_seq',0,1)")
            self.curl.execute("insert into dal_sequences(id,seq_name,last_value,is_delete) values(2,'hongbao',0,1)")
            self.curl.execute("insert into dal_sequences(id,seq_name,last_value,is_delete) values(3,'moses',0,1)")
            self.connection.commit()
            print "insert student %s sucess!" % db[-6:]
        


    def drop(self):
        for db in self.dbs:
            self.curl.execute("drop database %s" % db)
            print "delete %s sucess!" % db

    def run(self):
        try:
            self.curl.execute("use %s" % self.dbs[0])
            num=raw_input("数据库已存在，[删除老库重新建库]请输 1 ;[保留老库并退出]请输 2 ;[删除老库]请输 3 :")
            if num=="1":
                self.drop()
                self.create()
            elif num=="2":
                exit()
            elif num=="3":
                self.drop()
            else:
                print "输入有误！"
        except Exception,e:
            self.create()

test=CreateAutotestDB()
test.run()
