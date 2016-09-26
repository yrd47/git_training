#!/usr/bin/env python
# -*- coding: utf-8 -*-

' a test module '

__author__ = 'yrd'

import sys

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
#	test()
	function()
