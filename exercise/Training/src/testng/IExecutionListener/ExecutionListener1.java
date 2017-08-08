package testng.IExecutionListener;

import org.testng.IExecutionListener;

/**
 * Created by yrd on 2017/5/18.
 * IExecutionListener
 */
public class ExecutionListener1 implements IExecutionListener{

    private long startTime;

    @Override
    public void onExecutionStart() {
        startTime =System.currentTimeMillis();
        System.out.println("TestNG is going to start");
    }

    @Override
    public void onExecutionFinish() {
        System.out.println("TestNG has finished,took around" + (System.currentTimeMillis() - startTime) + "ms");
    }
}
