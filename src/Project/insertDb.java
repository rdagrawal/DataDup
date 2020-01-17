package Project;


import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Project.Connect;
public class insertDb 
{
	static String sql_query;
	
	
	public static void sqlOperate() 
	{
		Connect c=new Connect();
		Statement stmt = null;
		try
		{
			stmt = c.getConnect().createStatement();
			stmt.execute(sql_query);
			System.out.println("Operation Success");
			stmt.close();
			c.getConnect().close();	
		}
		catch(Exception e)
		{ //Handle errors for JDBC 
			e.printStackTrace();
		} 
	}
	
	
	public static void insertInTable(String tableName, String keyData, ArrayList<String> arrr) throws Exception
	{			//Insert Data in two cases:
				// 1. In hashMap table when we get new Roll Hash Value
				// 2. In userFiles table when user uploads a new file
		sql_query = "INSERT INTO "+ tableName + " VALUES ('" + keyData + "' , '" + arrr + "');" ;
		sqlOperate();	
	}
	public static void updateTable(String tableName, String keyData, List<String> arrr)
	{			//when get the same roll hash value but different SHA256
		sql_query = "UPDATE "+ tableName + " SET SHA256 = '" + arrr + "'where ROLLHASH ='"+keyData+"';" ;
		sqlOperate();
		System.out.println("---------------------------------------Row Updated---------------------------------------");
	}
	public static void deleteTable(String tableName, String fileName)
	{			//when user wants to delete file
		sql_query= " ;" ;
		sqlOperate();
		System.out.println("---------------------------------------Row/File Deleted---------------------------------------");
	}
	public static void createTable(String userName)
	{				//create table for new user
		sql_query = "CREATE TABLE "+ userName + " ( fileName VARCHAR(30) PRIMARY KEY, fileArray256 ARRAY);" ;
		sqlOperate();
		System.out.println("---------------------------------------Table Created---------------------------------------");
	}
	public static void createLogin(String userName, String password)
	{				//register new user in login table
		sql_query = "INSERT INTO LOGIN VALUES('"+ userName + "' , '" + password +"');";
		sqlOperate();
		System.out.println("---------------------------------------Login Created---------------------------------------");
	}
	public static void createdETAILS(String userName, String name, String email, int contact)
	{				//register new user in user details
		sql_query = "INSERT INTO USERDETAILS VALUES('"+ userName + "' , '" + name +"', '" + email +"', '" + contact +"');";
		sqlOperate();
		System.out.println("---------------------------------------Login Created---------------------------------------");
	}
}
