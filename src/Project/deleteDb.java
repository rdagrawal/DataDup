package Project;

import java.sql.Statement;

public class deleteDb extends userWork {
	
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

	//		2. Delete From Login Table
	public static void DeleteFromLogin() 
	{
		sql_query = "DELETE FROM LOGIN where userName = " + user;
		sqlOperate();
		System.out.println("---------------------------------------Login Details Deleted---------------------------------------");	
	}
	
	public static void deleteFromHashTable() {
		//sql_query = "DELETE FROM HASHIS ;" ;
		//sqlOperate();
		System.out.println("---------------------------------------Data Deleted from HashTable---------------------------------------"); 
	}
}
