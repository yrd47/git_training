#coding=utf-8
import pymysql

def fetch_data():
    db = pymysql.connect(host='192.168.96.21', port=9803, user='li', passwd='root', db='zheng')
    cursor = db.cursor()
    cursor.execute("select group_sn from shared_hongbao_record limit 4000000")
    data_group_sn = cursor.fetchall()
    db.close()
    return data_group_sn

def handle_data(result):
    str = ",('{sn}','{group_sn}','123456789','edcvfr','qwertghbvcxsdfg','15976574839','0.00','0','-1','7','qwdxzxcvgfd','qwefsdf',now(),now(),'sdsdfddfdefe','dfdsddsd','0.00')"
    list_insert = ["insert into shared_hongbao_record(sn,group_sn,sns_uid,sns_username,sns_avatar,phone,amount,sum_condition,status,duration,name,source,created_at,updated_at,tag,decision,risk_rate) "
                   "values('{sn}','{group_sn}','123456789','edcvfr','qwertghbvcxsdfg','15976574839','0.00','0','-1','7','qwdxzxcvgfd','qwefsdf',now(),now(),'sdsdfddfdefe','dfdsddsd','0.00')"]
    list_insert[0] = list_insert[0].replace('{sn}',result[0])
    list_insert[0] = list_insert[0].replace('{group_sn}',result[0])
    for i in range(1,len(result)):
        str1 = str.replace('{sn}', result[i])
        str1 = str1.replace('{group_sn}', result[i])
        list_insert.append(str1)
    str_insert = ''.join(list_insert)
    return str_insert

def save_sql(str_insert):
    f = open("/Users/yrd/Desktop/sql","a")
    f.write(str_insert)
    f.write('\n')
    f.close()

if __name__ == '__main__':
    data_handle = []
    print("111111111")
    result_group_sn = fetch_data()
    print("222222222")
    for i in range(len(result_group_sn)):
        data_handle.append(result_group_sn[i][0])
        if (i+1)%1000 == 0:
            print(i)
            str_insert = handle_data(data_handle)
            save_sql(str_insert)
            data_handle = []
    #     data_handle = []
    #     for n in range(i*1000,(i+1)*1000):
    #         data_handle.append(result_group_sn[n][0])
    #         if n == (i+1)*1000-1:
    #             # print data_handle
    #             str_insert = handle_data(data_handle)
    #             save_sql(str_insert)
    # print("end")