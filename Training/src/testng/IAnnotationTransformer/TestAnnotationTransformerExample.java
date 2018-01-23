package testng.IAnnotationTransformer;

import org.testng.annotations.Test;

/**
 * Created by yrd on 2017/5/18.
 *
 */

public class TestAnnotationTransformerExample {

    @Test
    public void t1(String param){
        System.out.println("Method is t1, parameter is " + param);
    }

    @Test
    public void t2(String param){
        System.out.println("Method is t2, paramter is " + param);
    }

    @Test
    public void t3(){
        System.out.println("Method is t3");
    }

}
