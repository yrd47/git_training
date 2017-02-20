package training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class MysqlUtil {
	
	public static final String url = "jdbc:mysql://10.101.7.53:3306/daltestdb";  
    public static final String driver = "com.mysql.jdbc.Driver";  
    public static final String user = "daltest";  
    public static final String password = "123456"; 
	
	public static Connection connectMysql() throws ClassNotFoundException, SQLException{   
			Class.forName(driver);  
			Connection conn = DriverManager.getConnection(url, user, password);  
			return conn;
	}
	
	public static void closeMysql(Connection conn) throws SQLException{
		conn.close();
	}
		
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		int max=999999999;
        int min=100000000;
        Random random = new Random();
        int s = random.nextInt(max)%(max-min+1) + min;
		System.out.println(s);
		Connection conn = MysqlUtil.connectMysql();
		Statement statement = conn.createStatement();
		String sql = "select * from gzs_shop_a limit 1;";
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()){
			System.out.println(rs.getString("shop_id"));
		}
		MysqlUtil.closeMysql(conn);
	}

}
