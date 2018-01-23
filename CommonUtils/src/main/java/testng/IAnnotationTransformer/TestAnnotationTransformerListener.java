package testng.IAnnotationTransformer;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by yrd on 2017/5/18.
 * IAnnotationTransformer
 */
public class TestAnnotationTransformerListener implements IAnnotationTransformer{

    @Override
    public void transform(ITestAnnotation iTestAnnotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if(testMethod.getName().equals("t1")){
            System.out.println("set data provider for " + testMethod.getName());
            iTestAnnotation.setDataProviderClass(DataProvider.class);
            iTestAnnotation.setDataProvider("getDp1");
        }else if(testMethod.getName().equals("t2")){
            System.out.println("set data provider for " + testMethod.getName());
            iTestAnnotation.setDataProviderClass(DataProvider.class);
            iTestAnnotation.setDataProvider("getDp2");
        }else if(testMethod.getName().equals("t3")){
            System.out.println("Disable " + testMethod.getName());
            iTestAnnotation.setEnabled(false);
        }
    }
}
