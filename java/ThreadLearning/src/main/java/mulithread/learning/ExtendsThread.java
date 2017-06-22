package mulithread.learning;

/**
 * Created by yrd on 2017/6/22.
 *  扩展jav.lang.Thread类
 */

class Thread1 extends Thread {
    private String name;

    public Thread1(String name) {
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

public class ExtendsThread {

    public static void main(String[] args) {
        Thread1 thread1 = new Thread1("yrd");
        Thread1 thread2 = new Thread1("dan");
        thread1.start();
        thread2.start();
    }
}
