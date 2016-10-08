#-*- coding: UTF-8 -*-
import pymysql

__author__ = 'shzheng.li@ele.me'

user_db='User_Order'
restaurant_db='Restaurant_Order'

sql_create_database="create database %s";
sql_drop_database = "drop database %s";
sql_use_database="use %s";
sql_create_table="CREATE TABLE %s (`id` bigint(20) NOT NULL AUTO_INCREMENT,`restaurant_id` int(11) NOT NULL,`restaurant_name` varchar(255) NOT NULL,`rst_owner_id` int(11) NOT NULL DEFAULT '0',`user_id` int(11) DEFAULT NULL,`user_name` varchar(255) DEFAULT NULL,`detail_json` text NOT NULL,`total` decimal(10,2) NOT NULL DEFAULT '0.00',`deliver_fee` decimal(10,2) NOT NULL DEFAULT '0.00',`is_online_paid` tinyint(1) NOT NULL DEFAULT '0',`settled_at` datetime DEFAULT NULL,`address` varchar(255) NOT NULL,`phone` varchar(255) NOT NULL,`restaurant_number` int(11) NOT NULL,`ip` varchar(255) DEFAULT NULL,`description` varchar(255) DEFAULT NULL,`unique_id` varchar(255) DEFAULT NULL,`auto_memo` varchar(255) DEFAULT NULL,`order_mode` tinyint(4) NOT NULL DEFAULT '0',`status_code` int(11) NOT NULL DEFAULT '0',`refund_status` int(11) NOT NULL DEFAULT '0',`is_book` tinyint(4) NOT NULL DEFAULT '0',`deliver_time` datetime DEFAULT NULL,`category_id` int(11) NOT NULL DEFAULT '1',`come_from` tinyint(4) DEFAULT NULL,`entry_id` int(11) DEFAULT NULL,`time_spent` tinyint(4) DEFAULT NULL,`coupon_id` int(11) DEFAULT NULL,`created_at` datetime DEFAULT NULL,`invoice` varchar(255) NOT NULL DEFAULT '',`attribute_json` text NOT NULL,`geohash` bigint(20) NOT NULL DEFAULT '0',`source` varchar(50) NOT NULL DEFAULT '',`phone_rating` tinyint(4) NOT NULL DEFAULT '0',`delivery_status` tinyint(4) NOT NULL DEFAULT '0',`active_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',`updated_at` timestamp NOT NULL DEFAULT '2015-01-30 00:00:00' ON UPDATE CURRENT_TIMESTAMP,PRIMARY KEY (`id`),KEY `phone` (`phone`),KEY `unique_id` (`unique_id`),KEY `created_at` (`created_at`),KEY `rst_owner_id` (`rst_owner_id`),KEY `settled_at` (`settled_at`),KEY `idx_online_paid` (`is_online_paid`,`refund_status`),KEY `idx_refund` (`refund_status`),KEY `geohash` (`geohash`),KEY `coupon_id` (`coupon_id`),KEY `phone_rating` (`phone_rating`),KEY `restaurant_id` (`restaurant_id`,`status_code`,`category_id`),KEY `status_code` (`status_code`),KEY `delivery_status` (`delivery_status`),KEY `restaurant_id_created_at` (`restaurant_id`,`created_at`),KEY `user_id` (`user_id`,`created_at`),KEY `ix_updated_at` (`updated_at`)) ENGINE=InnoDB AUTO_INCREMENT=6306778536334763279 DEFAULT CHARSET=utf8;"
sql_create_order_task="CREATE TABLE %s (`id` int(11) NOT NULL AUTO_INCREMENT,`task_hash` varchar(32) NOT NULL,`api_name` varchar(32) NOT NULL,`api_args` varchar(255) NOT NULL,`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (`id`),UNIQUE KEY `task_hash` (`task_hash`),KEY `api_name` (`api_name`),KEY `created_at` (`created_at`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;"
sql_create_mysql_task="CREATE TABLE %s (`id` int(11) NOT NULL AUTO_INCREMENT,`service` varchar(32) NOT NULL,`api_name` varchar(32) NOT NULL,`api_args` varchar(255) NOT NULL,`task_hash` varchar(32) NOT NULL,`status` tinyint(4) NOT NULL,`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,`target_at` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00',`updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',PRIMARY KEY (`id`),UNIQUE KEY `task_hash` (`task_hash`),KEY `status` (`status`),KEY `updated_at` (`updated_at`),KEY `status_2` (`status`,`target_at`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;"

class CreateAutotestDB():

    connection=None
    curl=None
    dbs=["main_db","dalDB_master","dalDB_slave1","dalDB_slave2"]

    def __init__(self):
        self.connection = pymysql.connect(host='192.168.65.25', port=3306, user='leoyan', passwd='123456', db='')
        # self.connection = pymysql.connect(host='192.168.80.17',port=3308,user='root',passwd='root',db='')
        self.curl = self.connection.cursor()

    def __del__(self):
        self.connection.commit()
        self.curl.close()
        self.connection.close()

    def create(self):
        for db in self.dbs:
            self.curl.execute("create database %s" % db)
            self.curl.execute("use %s" % db)
            self.curl.execute("create table student(`id` bigint(20) NOT NULL,`description` VARCHAR (255) NOT NULL)")
            if db == 'main_db':
                self.curl.execute("insert into student (id,description) VALUES (0,'%s')" % db)
                print "insert student %s sucess!" % db
            else:
                self.curl.execute("insert into student (id,description) VALUES (0,'%s')" % db[-6:])
                print "insert student %s sucess!" % db[-6:]
            self.curl.execute("CREATE TABLE `dal_sequences` (`id` bigint(20) NOT NULL,`seq_name` varchar(64) DEFAULT NULL,`last_value` bigint(19) DEFAULT NULL,`is_delete` tinyint(4) DEFAULT NULL,`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,`updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',PRIMARY KEY (`id`))")
            self.curl.execute("insert into dal_sequences(id,seq_name,last_value,is_delete) values(1,'eleme_order_orderid_seq',0,1)")
            self.curl.execute("insert into dal_sequences(id,seq_name,last_value,is_delete) values(2,'hongbao',0,1)")
            self.curl.execute("insert into dal_sequences(id,seq_name,last_value,is_delete) values(3,'moses',0,1)")
            # self.connection.commit()
            print "create dal_sequences success!"
        # Sharding表
        self.curl.execute(sql_create_database%user_db)
        self.curl.execute(sql_use_database%user_db)
        for i in range(0,200):
            table="shd_eleme_order_uid_"+str(i)
            order_task="shd_order_task_uid_"+str(i)
            mysql_task="shd_mysql_task_uid_"+str(i)
            self.curl.execute(sql_create_table%table)
            self.curl.execute(sql_create_order_task%order_task)
            self.curl.execute(sql_create_mysql_task%mysql_task)
        print "create user_db success!"
        self.curl.execute(sql_create_database%restaurant_db)
        self.curl.execute(sql_use_database%restaurant_db)
        for i in range(0,200):
            table="shd_eleme_order_rid_"+str(i)
            order_task="shd_order_task_rid_"+str(i)
            mysql_task="shd_mysql_task_rid_"+str(i)
            self.curl.execute(sql_create_table%table)
            self.curl.execute(sql_create_order_task%order_task)
            self.curl.execute(sql_create_mysql_task%mysql_task)
        print "create restaurant success!"


    def drop(self):
        for db in self.dbs:
            self.curl.execute(sql_drop_database% db)
            print "delete %s sucess!" % db
        self.curl.execute(sql_drop_database%user_db)
        print "delete %s sucess!" % user_db
        self.curl.execute(sql_drop_database%restaurant_db)
        print "delete %s sucess!" % restaurant_db


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
