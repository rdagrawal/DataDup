package Project;


import java.sql.Statement;
import java.util.ArrayList;  
import Project.Connect;
public class insertDb 
{
	public static void sqlOperate(String sql_query) 
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
	
	
	public static void insertInTable(String tableName, String keyData, ArrayList<String> arrr) throws Exception
	{			//Insert Data in two cases:
				// 1. In hashMap table when we get new Roll Hash Value
				// 2. In userFiles table when user uploads a new file
		String sql = "INSERT INTO "+ tableName + " VALUES ('" + keyData + "' , '" + arrr + "');" ;
		sqlOperate(sql);	
	}
	public static void updateTable(String tableName, String keyData, ArrayList<String> arrr)
	{			//when get the same roll hash value but different SHA256
		String sql = "UPDATE "+ tableName + " SET SHA256 = '" + arrr + "'where ROLLHASH ='"+keyData+"';" ;
		sqlOperate(sql);
		System.out.println("---------------------------------------Row Updated---------------------------------------");
	}
	public static void deleteTable(String tableName, String fileName)
	{			//when user wants to delete file
		String sql = " ;" ;
		sqlOperate(sql);
		System.out.println("---------------------------------------Row/File Deleted---------------------------------------");
	}
	public static void createTable(String userName)
	{
		String sql = "CREATE TABLE "+ userName + " ( fileName VARCHAR(30) PRIMARY KEY, fileArray256 ARRAY);" ;
		sqlOperate(sql);
		System.out.println("---------------------------------------Table Created---------------------------------------");
	}
}
