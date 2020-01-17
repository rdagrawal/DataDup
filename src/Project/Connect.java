package Project;

import java.sql.DriverManager;
import java.sql.Connection;

public class Connect 
{
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";
	   //  Database credentials 
	static final String USER = "sa";
	static final String PASS = "";
	
	public Connection getConnect() throws Exception
	{
		Connection conn = null;	
		Class.forName(JDBC_DRIVER); 
		conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
		System.out.println("Connection Success");
		return	conn;
	}
}
























//
//Properties pro=new Properties();
//FileInputStream fin=new FileInputStream("dbCred.properties");
//pro.load(fin);
////String driver=pro.getProperty("DRIVER");
////String url=pro.getProperty("URL");
////String user=pro.getProperty("USER");
////String pass=pro.getProperty("PASS");
//Class.forName("org.h2.Driver");
//Connection con=(Connection)DriverManager.getConnection(url,user,pass);
//return con;

