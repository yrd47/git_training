#!/usr/bin/python
#-*- coding: UTF-8 -*-

import  pymysql
import random
import sys

__author__ = 'willfei'

testconn={'host':"10.105.34.86",'port':3306,'user':"root",'passwd':"root"}
shardingTable=[]
shardingDB=[]
saveFile=file("sharding.txt","a+")
user_db='User_Order'
restaurant_db='Restaurant_Order'
#def insertData(range,conn):
#    user_id=random.randint()
#    getGlobalID="SELECT next_value FROM dal_dual WHERE seq_name='order_id' AND user_id="+str(user_id)+" AND restaurant_id='456'"
#    addElemeOrder="INSERT INTO eleme_order VALUES("+str(getGlobalID)+","+str(user_id)+",456,'KFC','jing.wang');"
#    globalID=conn.doTest(getGlobalID)


class Session:
    def __init__(self):
        self.connection=pymysql.connect(host=testconn["host"],port=testconn["port"],user=testconn["user"],passwd=testconn["passwd"])
        self.connection.autocommit(1)
    def close(self):
        try:
            self.connection.commit()
            self.connection.close()
        except:
            pass

    def createDB_Tables(self):
        sql_create_database="create database %s";
        sql_use_database="use %s";
        sql_create_table="CREATE TABLE %s (`id` bigint(20) NOT NULL AUTO_INCREMENT,`restaurant_id` int(11) NOT NULL,`restaurant_name` varchar(255) NOT NULL,`rst_owner_id` int(11) NOT NULL DEFAULT '0',`user_id` int(11) DEFAULT NULL,`user_name` varchar(255) DEFAULT NULL,`detail_json` text NOT NULL,`total` decimal(10,2) NOT NULL DEFAULT '0.00',`deliver_fee` decimal(10,2) NOT NULL DEFAULT '0.00',`is_online_paid` tinyint(1) NOT NULL DEFAULT '0',`settled_at` datetime DEFAULT NULL,`address` varchar(255) NOT NULL,`phone` varchar(255) NOT NULL,`restaurant_number` int(11) NOT NULL,`ip` varchar(255) DEFAULT NULL,`description` varchar(255) DEFAULT NULL,`unique_id` varchar(255) DEFAULT NULL,`auto_memo` varchar(255) DEFAULT NULL,`order_mode` tinyint(4) NOT NULL DEFAULT '0',`status_code` int(11) NOT NULL DEFAULT '0',`refund_status` int(11) NOT NULL DEFAULT '0',`is_book` tinyint(4) NOT NULL DEFAULT '0',`deliver_time` datetime DEFAULT NULL,`category_id` int(11) NOT NULL DEFAULT '1',`come_from` tinyint(4) DEFAULT NULL,`entry_id` int(11) DEFAULT NULL,`time_spent` tinyint(4) DEFAULT NULL,`coupon_id` int(11) DEFAULT NULL,`created_at` datetime DEFAULT NULL,`invoice` varchar(255) NOT NULL DEFAULT '',`attribute_json` text NOT NULL,`geohash` bigint(20) NOT NULL DEFAULT '0',`source` varchar(50) NOT NULL DEFAULT '',`phone_rating` tinyint(4) NOT NULL DEFAULT '0',`delivery_status` tinyint(4) NOT NULL DEFAULT '0',`active_at` datetime NOT NULL DEFAULT '1970-01-01 00:00:00',`updated_at` timestamp NOT NULL DEFAULT '2015-01-30 00:00:00' ON UPDATE CURRENT_TIMESTAMP,PRIMARY KEY (`id`),KEY `phone` (`phone`),KEY `unique_id` (`unique_id`),KEY `created_at` (`created_at`),KEY `rst_owner_id` (`rst_owner_id`),KEY `settled_at` (`settled_at`),KEY `idx_online_paid` (`is_online_paid`,`refund_status`),KEY `idx_refund` (`refund_status`),KEY `geohash` (`geohash`),KEY `coupon_id` (`coupon_id`),KEY `phone_rating` (`phone_rating`),KEY `restaurant_id` (`restaurant_id`,`status_code`,`category_id`),KEY `status_code` (`status_code`),KEY `delivery_status` (`delivery_status`),KEY `restaurant_id_created_at` (`restaurant_id`,`created_at`),KEY `user_id` (`user_id`,`created_at`),KEY `ix_updated_at` (`updated_at`)) ENGINE=InnoDB AUTO_INCREMENT=6306778536334763279 DEFAULT CHARSET=utf8;"
        sql_create_order_task="CREATE TABLE %s (`id` int(11) NOT NULL AUTO_INCREMENT,`task_hash` varchar(32) NOT NULL,`api_name` varchar(32) NOT NULL,`api_args` varchar(255) NOT NULL,`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,PRIMARY KEY (`id`),UNIQUE KEY `task_hash` (`task_hash`),KEY `api_name` (`api_name`),KEY `created_at` (`created_at`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;"
	    sql_create_mysql_task="CREATE TABLE %s (`id` int(11) NOT NULL AUTO_INCREMENT,`service` varchar(32) NOT NULL,`api_name` varchar(32) NOT NULL,`api_args` varchar(255) NOT NULL,`task_hash` varchar(32) NOT NULL,`status` tinyint(4) NOT NULL,`created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,`target_at` timestamp NOT NULL DEFAULT '2000-01-01 00:00:00',`updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',PRIMARY KEY (`id`),UNIQUE KEY `task_hash` (`task_hash`),KEY `status` (`status`),KEY `updated_at` (`updated_at`),KEY `status_2` (`status`,`target_at`)) ENGINE=InnoDB DEFAULT CHARSET=utf8;"
	    with self.connection.cursor() as cur:
            try:
                cur.execute(sql_create_database%user_db)
		        cur.execute(sql_use_database%user_db) 	
                for i in range(0,200):
  		            table="shd_eleme_order_uid_"+str(i)
		            order_task="shd_order_task_uid_"+str(i)
		            mysql_task="shd_mysql_task_uid_"+str(i)	
                    cur.execute(sql_create_table%table)
                    cur.execute(sql_create_order_task%order_task)
		            cur.execute(sql_create_mysql_task%mysql_task)
            except Exception,e:
                print "Query failed:"+str(e)
        with self.connection.cursor() as cur:
            try:
                cur.execute(sql_create_database%restaurant_db)
                cur.execute(sql_use_database%restaurant_db)
                for i in range(0,200):
		            table="shd_eleme_order_rid_"+str(i)
                    order_task="shd_order_task_rid_"+str(i)
                    mysql_task="shd_mysql_task_rid_"+str(i)
                    cur.execute(sql_create_table%table)
                    cur.execute(sql_create_order_task%order_task)
                    cur.execute(sql_create_mysql_task%mysql_task)
            except Exception,e:
                print "Query failed:"+str(e)

    def dropDB(self):
        sql_drop_database="drop database %s";
        with self.connection.cursor() as cur:
            try:
                cur.execute(sql_drop_database%user_db)
                cur.execute(sql_drop_database%restaurant_db)
            except Exception,e:
                print "Query failed:"+str(e)




if __name__ == '__main__':
    session=Session()
    try:
        if len(sys.argv)<2:
            print "please input like ./Sharding_Online.py [create] [drop]!!!!!!"
            sys.exit()
        activity=sys.argv[1]
        if (activity=="create"):
            session.createDB_Tables()
        elif (activity=="drop"):
            session.dropDB()
        else:
            print "please input like ./Sharding_Online.py [create] [drop]!!!!!!"
            sys.exit()
    finally:
        session.close()

