package testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by yrd on 2017/5/23.
 *
 */
public class ReporterListenerExample {

    @DataProvider
    public Object[][] dataProvider() {
        return new Object[][]{{1},{1}};
    }

    @Test(dataProvider = "dataProvider",testName = "TC-13111")
    public void testAssert1(int a){
        Assert.assertEquals(1,a);
    }
    
    @Parameters({"suite-param"})
    @Test(testName = "TC-13111")
    public void testAssert2(String param){
    	System.out.println(param);
        Assert.assertEquals("2","2");
    }

    @Test(testName = "TC-13111")
    public void testAssert3(int a){
        Assert.assertEquals(1,a);
    }
}
