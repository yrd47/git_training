#coding=UTF-8
__author__ = 'yrd'

#装饰器是一个以另一个函数为参数的函数
def my_shiny_new_decorator(a_function_to_decorate):
    #在这里,装饰器定义一个函数:包装器
    #这个函数将原始函数进行包装,以达到在原始函数之前/之后执行代码的目的
    def the_wrapper_around_the_original_function():

        #在原始函数之前需要执行的代码
        print "Before the function runs"

        a_function_to_decorate()

        #在原始函数之后需要执行的代码
        print "After the function runs"

        #代码到这里,函数'a_function_to_decorate'还没有被执行
        #我们将返回刚才创建的包装函数,这个包装函数包含原始函数及要执行的附加代码,并且可以被使用
    return the_wrapper_around_the_original_function

def a_stand_alone_function():
    print "I am a stand alone function,do not dare modyfy me"

a_stand_alone_function()

#装饰这个函数,将函数传递给装饰器,装饰器将动态地将其包装在任何你想执行的代码中,然后返回一个新的函数
a_stand_alone_function_decorated = my_shiny_new_decorator(a_stand_alone_function)

a_stand_alone_function_decorated()

#@decorator是下面代码的简写:test_decorated = my_shiny_new_decorator(test)
@my_shiny_new_decorator
def test():
    print 111

test()