package Project;

import java.sql.Statement;

public class uploadFiledb {
static String sql_query;
	
	public static void sqlOperate() 
	{
		Connect c=new Connect();
		Statement stmt = null;
		try
		{
			stmt = c.getConnect().createStatement();
			stmt.execute(sql_query);
			stmt.close();
			c.getConnect().close();	
		}
		catch(Exception e)
		{ //Handle errors for JDBC 
			e.printStackTrace();
		} 
	}

}
