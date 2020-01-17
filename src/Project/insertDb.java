/*
 * 
 * 
 * InComplete Not Finalize
 * 
 * 
 * 
 * 
 */



package Project;


import java.sql.Statement;


import Project.Connect;
public class insertDb extends userWork
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
			stmt.close();
			c.getConnect().close();	
		}
		catch(Exception e)
		{ //Handle errors for JDBC 
			e.printStackTrace();
		} 
	}
	
	public static void createLogin(String userName, String password, String name, String email, long contact) throws Exception
	{				//register new user in login table
		sql_query = "INSERT INTO LOGIN VALUES('"+ userName + "' , '" + password +"' , '"+ name + "' , '" + email +"' , '"+contact + "');";
		sqlOperate();
		System.out.println("---------------------------------------Login Created---------------------------------------");
		insertDb.createUserTable(userName);
		userWork.run();
	}	
	public static void createUserTable(String userName)
	{				//create table for new user
		sql_query = "CREATE TABLE "+ userName + " ( fileName VARCHAR(30) not null PRIMARY KEY, fileArray256 VARCHAR not null);" ;
		sqlOperate();
		System.out.println("---------------------------------------Table Created---------------------------------------");
	}
	public static void insertInTableString(String tableName, int keyData, String arrr) throws Exception
	{			//Insert Data in two cases:
				// 1. In hashMap table when we get new Roll Hash Value
				// 2. In userFiles table when user uploads a new file
		sql_query = "INSERT INTO "+ tableName + " VALUES ('" + keyData + "' , '" + arrr + "');" ;
		sqlOperate();
		System.out.println("---------------------------------------Data Inserted---------------------------------------");
	}
	public static void updateTableString(String tableName, int keyData, String arrr)
	{			//when get the same roll hash value but different SHA256
		sql_query = "UPDATE "+ tableName + " SET HASH256 = '" + arrr + "'where HASH ='"+keyData+"';" ;
		sqlOperate();
		System.out.println("---------------------------------------Row Updated---------------------------------------");
	}
	public static void insertInUserString(String tableName, String keyData, String arrr) throws Exception
	{			//Insert Data in two cases:
				// 1. In hashMap table when we get new Roll Hash Value
				// 2. In userFiles table when user uploads a new file
		sql_query = "INSERT INTO "+ tableName + " VALUES ('" + keyData + "' , '" + arrr + "');" ;
		sqlOperate();
		System.out.println("---------------------------------------Data Inserted---------------------------------------");
	}
	public static void deleteFile(String filename) {
		sql_query = "DELETE FROM "+ user + " where fileName = '" + filename + "'";
		sqlOperate();
		System.out.println("---------------------------------------File Deleted---------------------------------------");
	}
	public static void deleteUser() {
		sql_query = "DELETE FROM LOGIN where userName = " + user;
		sqlOperate();
		System.out.println("---------------------------------------User Deleted---------------------------------------");
		sql_query = "DROP TABLE " + user;
		sqlOperate();	
	}
}
