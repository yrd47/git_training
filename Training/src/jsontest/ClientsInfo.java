package jsontest;

import java.util.*;

public class ClientsInfo {
	
	public String protocol;
	public String hostname;
	public String appId;
	public String ip;
	public String ezone;
	public String sdkVersion;
	public String status;
	public List<ChannelInfo> channel;
	public List<SubInfo> sub;
	
	public class ChannelInfo{
		
	}
	
	public class SubInfo{
		
	}
	
	@Override
	public String toString(){
		return "";
	}

}
