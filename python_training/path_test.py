import os

__author__ = 'yrd'

FILE_PATH = os.path.abspath(__file__)
print FILE_PATH
BASE_PATH = os.path.dirname(FILE_PATH)
print BASE_PATH
XMLRPC_PATH = os.path.join(BASE_PATH, 'monitor_server.py')
print XMLRPC_PATH