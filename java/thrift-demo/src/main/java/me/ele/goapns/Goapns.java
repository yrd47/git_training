package me.ele.goapns;

import javax.mail.Transport;

import org.apache.bcel.generic.NEW;
import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import me.ele.goapns.thrift.GoApnsService;
import me.ele.goapns.thrift.GoApnsUserException;
import me.ele.goapns.thrift.TMessage;

/**
 * 长连接
 */

public class Goapns extends AbstractJavaSamplerClient {

	private TTransport transport = null;
	private TProtocol tprotocol = null;

	/**
	 * 定义可用参数及默认值
	 */
	@Override
	public Arguments getDefaultParameters() {
		Arguments defaultParameters = new Arguments();
		defaultParameters.addArgument("server", "");
		defaultParameters.addArgument("port", "");
		defaultParameters.addArgument("appid", "");
		defaultParameters.addArgument("token", "");
		defaultParameters.addArgument("payload", "");
		return defaultParameters;
	}

	/**
	 * 测试前执行，做一些初始化工作；
	 */
	@Override
	public void setupTest(JavaSamplerContext context) {
		String host = context.getParameter("server");
		String port = context.getParameter("port");
		transport = new TSocket(host, Integer.parseInt(port));
		tprotocol = new TBinaryProtocol(transport, true, true); // 二进制协议
		try {
			transport.open();
		} catch (TTransportException e) {
			e.getMessage();
		}
	}

	@Override
	public SampleResult runTest(JavaSamplerContext context) {
		SampleResult result = new SampleResult();
		String appid = context.getParameter("appid");
		String token = context.getParameter("token");
		String payload = context.getParameter("payload");
		TMessage message = new TMessage(appid, token, payload);
		GoApnsService.Client client = new GoApnsService.Client(tprotocol);
		// 开始计时
		result.sampleStart();
		try {
			String receive_result = client.send_message(message);
			// 结束计时
			result.sampleEnd();
			result.setSuccessful(true);
			result.setResponseData("Successful:"+receive_result, "UTF-8");
		} catch (GoApnsUserException e) {
			if (e.getMessage().contains("BadDeviceToken")) {
				result.sampleEnd();
				result.setSuccessful(true);
				result.setResponseData("Success:"+e.toString(), "UTF-8");
			}else{
				result.sampleEnd();
				result.setSuccessful(false);
				System.out.println(e.toString());
				result.setResponseData("GoApnsUserException:"+e.toString(), "UTF-8");
			}			
		}catch (TTransportException e) {
			// TODO: 重新建立连接 
			result.sampleEnd();
			transport.close();
			String host = context.getParameter("server");
			String port = context.getParameter("port");
			transport = new TSocket(host, Integer.parseInt(port));
			tprotocol = new TBinaryProtocol(transport, true, true); // 二进制协议
			try {
				transport.open();
			} catch (TTransportException e2) {
				e2.getMessage();
			}
			result.setSuccessful(false);
			System.out.println(e.toString());
			result.setResponseData("TTransportException:"+e.toString(), "UTF-8");
		}catch (Exception e) {
			result.sampleEnd();
			result.setSuccessful(false);
			System.out.println(e.toString());
			result.setResponseData("Exception:"+e.toString(), "UTF-8");
		}
		return result;
	}

	@Override
	public void teardownTest(JavaSamplerContext context) {
		transport.close();
	}
	
}
