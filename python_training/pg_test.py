#! /usr/bin/python
# coding=utf-8

__author__ = 'yrd'

import psycopg2

def test_pg():
    print 1
    conn = psycopg2.connect(database="test",user="pg_dal",password="aP6Pkic@k[QnQCR3",host="192.168.96.22",port="5432")
    cur = conn.cursor()
    cur.execute("select * from DEPARTMENT;")
    result = cur.fetchall()
    print result

def test_pgdal():
    print 2
    conn = psycopg2.connect(database="pg_group", user="pg", password="root", host="192.168.96.21",port="7803")
    cur = conn.cursor()
    cur.execute("select * from company;")
    result = cur.fetchall()
    print result

if __name__ =="__main__":
    test_pgdal()