import time,threading

__author__ = 'yrd'

def loop():
    print('thread %s is running ...' % threading.currentThread().name)
    n = 0
    while n<5:
        n=n+1
        print('thread %s >>> %s' % (threading.currentThread().name,n))
        time.sleep(1)
    print('thread %s ended.' % threading.currentThread().name)

print('thread %s is running ...' % threading.currentThread().name)
t = threading.Thread(target=loop)
t.start()
t.join()
print('thread %s ended.' % threading.currentThread().name)
