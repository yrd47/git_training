#coding=UTF-8
__author__ = 'yrd'

def shout(word="yes"):
    return word.capitalize()+"!"

def talk():
    #定义一个函数
    def whisper(word='yes'):
        return word.lower()+"..."
    #立即调用
    print whisper()
    #每次当你调用"talk",都会定义"whisper",并且在"talk"中被调用

print shout()

#作为一个对象,可以将函数赋值给另一个对象
scream = shout
#这里没有使用括号:因为这不是调用函数,而是将函数'shout'赋值给变量'scream',可以通过'scream'调用'shout'

print scream()

del shout

try:
    print shout()
except NameError, e:
    print e

print scream()

talk()

try:
    print whisper()
except NameError,e:
    print e