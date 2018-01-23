package testng.IReporter;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
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

    @Test(dataProvider = "dataProvider")
    public void testAssert1(int a){
        Assert.assertEquals(1,a);
    }

    @Test
    public void testAssert2(){
        Assert.assertEquals("2","2");
    }

    @Test
    public void testAssert3(int a){
        Assert.assertEquals(1,a);
    }
}
