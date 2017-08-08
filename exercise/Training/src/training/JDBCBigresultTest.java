package training;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCBigresultTest {
	   // JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	   static final String DB_URL = "jdbc:mysql://192.168.80.19:9803/eos_group?useUnicode=true&autocommit=false";

	   // Database credentials
	   static final String USER = "dal_admin";
	   static final String PASS = "root";

	   public static void main(String[] args) {
	       Connection conn = null;
	       Statement stmt = null;
	       try {
	           // STEP 2: Register JDBC driver
	           Class.forName("com.mysql.jdbc.Driver");

	           // STEP 3: Open a connection
	           System.out.println("Connecting to database...");
	           conn = DriverManager.getConnection(DB_URL, USER, PASS);

	           // STEP 4: Execute a query
	           System.out.println("Creating statement...");
	           stmt = conn.createStatement(java.sql.ResultSet.TYPE_FORWARD_ONLY,
	                   java.sql.ResultSet.CONCUR_READ_ONLY);
	           stmt.setFetchSize(Integer.MIN_VALUE);
	           String sql;
	           String msg = "";
	           for(int i=0; i<500000; i++){
	               msg = msg+"x";
	           }
	           sql = "SELECT '"+ msg +"' from eleme_order limit 150000";
	           ResultSet rs = stmt.executeQuery(sql);

	           long s = System.currentTimeMillis();
	           // STEP 5: Extract data from result set
	           int i=0;
	           while (rs.next()) {
	               Thread.sleep(100);
	               i++;
	               System.out.println("the rows count is " + i);
	           }

	           // STEP 6: Clean-up environment
	           System.out.println("success " + (System.currentTimeMillis() - s)/1000);
	           rs.close();
	           stmt.close();
	           conn.close();
	       } catch (SQLException se) {
	           // Handle errors for JDBC
	           se.printStackTrace();
	       } catch (Exception e) {
	           // Handle errors for Class.forName
	           e.printStackTrace();
	       } finally {
	           // finally block used to close resources
	           try {
	               if (stmt != null)
	                   stmt.close();
	           } catch (SQLException se2) {
	           }// nothing we can do
	           try {
	               if (conn != null)
	                   conn.close();
	           } catch (SQLException se) {
	               se.printStackTrace();
	           }// end finally try
	       }// end try
	       System.out.println("Goodbye!");
	   }// end main
	}