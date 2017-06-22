package mulithread.learning;

import static java.lang.Thread.sleep;

/**
 * Created by yrd on 2017/6/22.
 * 实现java.lang.Runnable接口
 * 所有多线程的代码都在run()方法
 * Thread类实际也是实现了Runnable接口的类
 * 启动多线程时需要先通过Thread的构造方法Thread(Runnable target)构造出对象，然后调用Thread对象的start()方法来运行多线程代码
 * 所有的多线程代码都是通过Thread的start()方法来运行的
 * 熟悉Thread类的API是进行多线程的基础
 */

class Thread2 implements Runnable {

    private String name;

    public Thread2(String name) {
        this.name = name;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行: " + i);
            try {
                sleep((long) (Math.random() * 10));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ImplementsRunnable {

    public static void main(String[] args) {
        new Thread(new Thread2("C")).start();
        new Thread(new Thread2("D")).start();
    }
}
