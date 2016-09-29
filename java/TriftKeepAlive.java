package me.ele.python.agent;

import me.ele.python.agent.thrift.PythonService;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * Created by zhuqiaoling on 16/7/28.
 *
 * 在用jmeter压测的时候，一个线程会有一个当前类实例
 *
 * 建立连接 》 发送请求  》关闭连接
 *   长连接
 */
public class TriftKeepAlive extends AbstractJavaSamplerClient {

    private TTransport transport = null;
    private TProtocol protocol = null;

    /**
     *  定义可用参数及默认值
     */
    @Override
    public Arguments getDefaultParameters() {
        Arguments arguments = new Arguments();
        arguments.addArgument("host", "192.168.96.15");
        arguments.addArgument("port", "8010");
        arguments.addArgument("id", "1");
        return arguments;
    }

    /**
     * 测试前执行，做一些初始化工作；
     */
    @Override
    public void setupTest(JavaSamplerContext context) {
        String host = context.getParameter("host");
        int port = context.getIntParameter("port");
        transport = new TSocket(host, port);//socket
        protocol = new TBinaryProtocol(transport, true, true);//二进制协议
        try {
            transport.open();//建立连接
        } catch (TTransportException e) {
            e.printStackTrace();
        }

    }

    /**
     * 必选，实现自定义请求
     *      具体调用的逻辑
     */
    @Override
    public SampleResult runTest(JavaSamplerContext context) {
        SampleResult result = new SampleResult();
        int id = context.getIntParameter("id");
        result.sampleStart();// 开始计时
        PythonService.Client client = new PythonService.Client(protocol);//发送请求
        try {
            boolean re = client.nay(id);//Server端的方法调用
            result.sampleEnd();//结束记时
            result.setSuccessful(true);
            result.setResponseData(String.valueOf(re), "utf-8");// Server端返回的正确信息写入jmeter
        } catch (TException e) {
            result.sampleEnd();//结束记时
            result.setSuccessful(false);
            result.setResponseData("Exception:" + e.toString(), "utf-8");// Server端返回的异常信息写入jmeter
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 测试结束时调用
     *      关闭相关的资源
     */
    @Override
    public void teardownTest(JavaSamplerContext context) {
        transport.close();
    }
}
