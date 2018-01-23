package training;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class MysqlUtil {
	
	public static final String url = "";
	public static final String user = "";  
    public static final String password = "123456"; 
    public static final String driver = "com.mysql.jdbc.Driver";   

	
	public static Connection connectMysql() throws ClassNotFoundException, SQLException{   
			Class.forName(driver);  
			Connection conn = DriverManager.getConnection(url, user, password);  
			return conn;
	}
	
	public static void closeMysql(Connection conn) throws SQLException{
		conn.close();
	}
		
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		StringBuffer stringBuffer = new StringBuffer("");
		Connection conn = MysqlUtil.connectMysql();
		Statement statement = conn.createStatement();
		String sql = "select shop_id,shard_id from gzs_shop_b;";
//		String sql = "select id,oid,latitude,longitude,city_id from restaurant";
		ResultSet rs = statement.executeQuery(sql);
		int i = 0;
		while(rs.next()){
//			stringBuffer.append(rs.getString("id")+","+rs.getString("oid")+","+rs.getString("latitude")+","+rs.getString("longitude")+","+rs.getString("city_id")+"\n");
			stringBuffer.append(rs.getString("shop_id")+","+rs.getString("shard_id")+"\n");
			i++;
		}
		System.out.println(i);
		try{
			FileWriter writer = new FileWriter("/Users/yrd/Downloads/sdk1.txt");
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			bufferedWriter.write(stringBuffer.toString());			
			bufferedWriter.close();
			writer.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		MysqlUtil.closeMysql(conn);
	}
}
