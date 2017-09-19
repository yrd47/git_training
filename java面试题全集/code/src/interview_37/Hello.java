package interview_37;

/**
 * Created by yrd on 2017/5/16.
 * 创建对象时构造器的调用顺序是：先初始化静态成员，然后调用父类构造器，再初始化非静态成员，最后调用自身构造器
 * 看看   Java类加载机制
 */

class A{
    static {
        System.out.println("1");
    }

    public A (){
        System.out.println("2");
    }
}

class B extends A{
    static {
        System.out.println("a");
    }

    public B (){
        System.out.println("b");
    }
}

public class Hello {
    public static void main(String[] args){
        A ab = new B();
        ab = new B();
    }
}
