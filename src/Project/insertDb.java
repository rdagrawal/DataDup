package Project;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.sql.Statement;
import java.util.ArrayList;  

public class insertDb 
{
	static final String JDBC_DRIVER = "org.h2.Driver"; 
	static final String DB_URL = "jdbc:h2:~/test";
	   //  Database credentials 
	static final String USER = "sa";
	static final String PASS = "";  
	
	
	
	public static void sqlOperate(String sql_query) {
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName(JDBC_DRIVER); 
			conn = DriverManager.getConnection(DB_URL,USER,PASS);
			stmt = conn.createStatement();
			stmt.execute(sql_query);
			stmt.close();
			conn.close();	
		}catch(SQLException se){ //Handle errors for JDBC 
			se.printStackTrace(); 
		}catch(Exception e) {//Handle errors for Class.forName 
			e.printStackTrace(); 
		}
		finally { //finally block used to close resources 
			try{
				if(stmt!=null) stmt.close(); 
			} catch(SQLException se2) {
				se2.printStackTrace();
			} // nothing we can do 
			try {
				if(conn!=null) conn.close(); 
			} catch(SQLException se){ 
				se.printStackTrace(); 
			} //end finally try 
		} //end try 
	}
	
	
	public static void insertInTable(String tableName, String keyData, ArrayList<String> arrr) throws Exception
	{
		String sql = "INSERT INTO "+ tableName + " VALUES ('" + keyData + "' , '" + arrr + "');" ;
		sqlOperate(sql);	
	}

	public static void updateTable(String tableName, String keyData, ArrayList<String> arrr)
   {
		String sql = "UPDATE "+ tableName + " SET SHA256 = '" + arrr + "'where ROLLHASH ='"+keyData+"';" ;
		sqlOperate(sql);
		System.out.println("***********************************---------------------------------------**********************************************------------------------------------------------******************************************************-------------------------------------------");
   }
}
