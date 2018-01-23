package testng.ITestListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by yrd on 2017/5/23.
 * ITestListener is the listener for test running. You can either implement ITestListener or extend the TestNG provided implementation TestListenerAdapter
 * as it has many convenient methods and we don’ have to re-invent the wheel
 */
public class TestListener implements ITestListener{

    @Override
    public void onTestStart(ITestResult result){
        System.out.println("On test method " + getTestMethodName(result) + " start");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("On test method " + getTestMethodName(iTestResult) + " success");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("On test method " + getTestMethodName(iTestResult) + " fail");
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("On test method " + getTestMethodName(iTestResult) + " skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but within success % " + getTestMethodName(iTestResult));
    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("On start of test " + iTestContext.getName());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("On finish of test " + iTestContext.getName());
    }

    private static String getTestMethodName(ITestResult result){
        return result.getMethod().getConstructorOrMethod().getName();
    }
}
