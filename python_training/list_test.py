import _List
__author__ = 'yrd'

data_list = []

for i in range(10):
    data_list.append(i)
print data_list

for i in range(data_list.__len__()-1):
    print i
    if data_list.index(i+1)-data_list.index(i) == 1:
        print True