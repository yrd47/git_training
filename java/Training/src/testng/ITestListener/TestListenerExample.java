package testng.ITestListener;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by yrd on 2017/5/23.
 *t1() is expected to run fine
 * t2() is expected to fail as it doesn’t throw the expected exception
 * t3() receives a parameter but since we haven’t set a DataProvider, it is skipped
 * t4() is invoked five times, of which, twice its going to fail. We have set the expected successPercentage to 80.
 */

public class TestListenerExample {

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before test");
    }

    @Test
    public void t1(){
        System.out.println("t1 test method");
    }

    @Test(expectedExceptions = RuntimeException.class)
    public void t2(){
        System.out.println("t2 test method will fail");
    }

    @Test
    public void t3(String string){
        System.out.println("t3 test method will skip as parameter string is not set");
    }

    @Test(successPercentage = 80, invocationCount = 5)
    public void t4(){
        i++;
        System.out.println("t4 test method, invocation count: " + i);
        if (i==1 || i==2){
            System.out.println("fail t4");
            Assert.assertEquals(i,10);
        }
    }

    @AfterSuite
    public void afterTest(){
        System.out.println("After test");
    }

    private int i;
}
