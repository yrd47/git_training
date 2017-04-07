#coding=UTF-8
__author__ = 'yrd'

def getTalk(type="shout"):

    def shout(word='yes'):
        return word.capitalize()+"!"

    def whisper(word='yes'):
        return word.lower()+'...'

    if type == 'shout':
        #没有使用"()",并不是要调用函数,而是要返回函数对象
        return shout
    else:
        return whisper

talk = getTalk()
print talk
print talk()
print getTalk("whisper")()

#如果你返回一个函数,那么你也可以将函数作为参数传递

def dosomethingBefore(func):
    print "I do something before then I call the function you gave me"
    print func()

dosomethingBefore(talk)
