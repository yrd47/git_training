package testng.SuiteListener;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

/**
 * Created by yrd on 2017/5/18.
 *
 */
public class SuiteListenerExample {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite");
    }

    @Test
    public void t(){
        System.out.println("test method");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("after suite");
    }
}
