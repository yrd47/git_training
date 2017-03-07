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
	
//	public static final String url = "jdbc:mysql://10.101.7.53:3306/daltestdb";
//	public static final String user = "daltest";  
//  public static final String password = "123456"; 
	public static final String url = "jdbc:mysql://10.103.101.158:6109/napos_shop-arch_gzs_group";
//	public static final String url = "jdbc:mysql://10.104.105.61:6109/napos_shop-arch_gzs_group";
    public static final String driver = "com.mysql.jdbc.Driver";   
    public static final String user = "beta_multi_user";  
    public static final String password = "YZn5oM3q9wBGW4mCcbKj"; 
	
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
//		String sql = "select count(*) from restaurant limit 1;";
		String sql = "select id,oid,latitude,longitude,city_id from restaurant";
		ResultSet rs = statement.executeQuery(sql);
		int i = 0;
		while(rs.next()){
			stringBuffer.append(rs.getString("id")+","+rs.getString("oid")+","+rs.getString("latitude")+","+rs.getString("longitude")+","+rs.getString("city_id")+"\n");
			i++;
		}
		System.out.println(i);
		try{
			FileWriter writer = new FileWriter("/Users/yrd/Downloads/alta.txt");
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
