#coding=utf-8
import pymysql

__author__ = 'yrd'

def pymysql_test():
    db = pymysql.connect(host='192.168.96.21', port=9803, user='li', passwd='root', db='zheng')
    cursor = db.cursor()
    cursor.execute("show tables")
    data = cursor.fetchall()
    # print ("Database version : %s" % data)
    print data
    db.close()

if __name__ == '__main__':
   pymysql_test()


