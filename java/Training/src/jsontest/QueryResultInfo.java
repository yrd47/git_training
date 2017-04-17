package jsontest;

import java.util.List;

/*
 * 数据的类型、键的名称都必须与json字符串保证一一对应
 * 如出现嵌套的数组，就写一个内部类，用同样的方式命名各个json字段，用List接收它
 * 所有变量的访问域都是public的
 * 
 */
public class QueryResultInfo {
	public String status;
	public String msg;
	public List<DataList> data;

	public class DataList {
		public int distance;
		public String imageUrl;
		public String overview;
		public String source;
		public String status;
		public List<DetailsList> details;
		
		@Override
		public String toString(){
			return "DataList [distance=" + distance + ", imageUrl=" + imageUrl + ", overview=" + overview + 
					",source=" + source +",status" + status + ",details=" + details.toString() + "]" ;
		}
		
		public class DetailsList {
			public int distance;
			public double nestLat;
			public double nestLong;
			public String nexti;
			public int status;
			
			@Override
			public String toString(){
				return "DetailsList [distance=" + distance + ",nestLat=" + nestLat + ", nextLong=" 
						+ nestLong + ", nexti" + nexti + ", status" + status + "]";
			}
		}
	}
	
	@Override
	public String toString(){
		return "QueryResultInfo [status=" + status + ",msg=" + msg + ",date=" + data.toString() + "]";
	}
}
