package me.ele.python.agent.test;

import me.ele.python.agent.TriftKeepAlive;
import me.ele.python.agent.self.PythonAgent;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhuqiaoling on 15/12/25.
 */
public class KeepAliveTest {
    Arguments params = new Arguments();
    JavaSamplerContext context = null;

    @Before
    public void setContext() {
        params.addArgument("host", "192.168.96.15");
        params.addArgument("port", "8010");
        params.addArgument("thrift-protocol", "");
        params.addArgument("id", "2");
        context = new JavaSamplerContext(params);
    }


    @Test
    public void testKeepAlive() {
        TriftKeepAlive triftKeepAlive = new TriftKeepAlive();
        triftKeepAlive.setupTest(context);
        SampleResult result = triftKeepAlive.runTest(context);
        String resultData = result.getResponseDataAsString();
        long startTime = result.getStartTime();
        long endTime = result.getEndTime();
        System.out.println("耗时=" + (endTime - startTime));
        System.out.println("nay接口返回的数据=" + resultData);
        triftKeepAlive.teardownTest(context);
    }

}
