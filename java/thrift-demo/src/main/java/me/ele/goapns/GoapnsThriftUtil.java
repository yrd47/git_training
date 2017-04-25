package me.ele.goapns;

import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

import me.ele.goapns.thrift.TMessage;

public class GoapnsThriftUtil {
	
	private TTransport transport = null;
	private TProtocol tprotocol = null;
	
	public void buildConnection(JavaSamplerContext context){
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

	public void closeConnection(JavaSamplerContext context) {
		// TODO Auto-generated method stub
		this.transport.close();
	}

	public TMessage buildRequest(JavaSamplerContext context){
		String appid = context.getParameter("appid");
		String token = context.getParameter("token");
		String payload = context.getParameter("payload");
		TMessage message = new TMessage(appid, token, payload);
		return message;
	}

	public String send_request(TMessage message) {
		// TODO Auto-generated method stub
		return null;
	}
}
