package testng.SuiteListener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

/**
 * Created by yrd on 2017/5/18.
 * ISuiteListener
 */
public class SuiteListener implements ISuiteListener{

    @Override
    public void onStart(ISuite iSuite) {
        System.out.println("Start suite " + iSuite.getName());
    }

    @Override
    public void onFinish(ISuite iSuite) {
        System.out.println("Finish suite " + iSuite.getName());
    }
}
