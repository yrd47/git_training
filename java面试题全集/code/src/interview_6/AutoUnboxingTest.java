package interview_6;

/**
 * java自动装箱
 * Created by yrd on 2017/5/12.
 */
public class AutoUnboxingTest {

    public static void main(String[] args){
        Integer a = new Integer(3);
        Integer b = 3;  //将3自动装箱成Integer类型
        int c =3;
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);

        //如果整型字面量的值在-128到127之间，那么不会new新的Integer对象，而是直接引用常量池中的Integer对象，
        // 所以f1==f2的结果是true，而f3==f4的结果是false
        //注意看一下Integer类的源码
        Integer f1=100,f2=100,f3=150,f4=150;
        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
    }

}
