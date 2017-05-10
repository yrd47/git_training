#/usr/bin/python

import sys

__author__ = 'yrd'

print "The command line arguments are:"
for i in sys.argv:
    print i

print len(sys.argv)

print '\nThe PYTHONPATH is ',sys.path[0],'\n'


def test():
	args = sys.argv
	if len(args)==1:
		print  'Hello,world!'
	elif len(args)==2:
		print  'Hello,%s!' %args[1]
	else:
		print 'Too many arguments!'

def function():
	for i in range(0,513):
		print i

if __name__ == '__main__':
	# test()
	# function()
	for name in dir(sys):
		if name.startswith('s') and name.endswith('e'):
			print(name)