package Project;

import java.sql.Statement;
import java.util.Scanner;

public class deleteData extends userWork{
	static String fileName;
	static Scanner sc = new Scanner(System.in);
	
	
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
	
	
//	12.Delete User All Files
	public static void deleteUserAllFileDetails() {
		sql_query = "DELETE FROM FILEDETAILS where username = '" + user + "'";
		sqlOperate();
		System.out.println("---------------------------------------User Files Deleted---------------------------------------");
	}
	public static void deleteFromShaCount( String sha256, int refernceCount) throws Exception
	{
		sql_query = "DELETE FROM SHACOUNT where COUNT = 0 ;" ;
		sqlOperate();
		System.out.println("---------------------------------------Data Deleted From SHACount Table---------------------------------------"); 
	}
	
	
	
	
//	11. Delete Single File
	public static void deleteUserSingleFileDetails(String filename) {
		sql_query = "DELETE FROM FILEDETAILS where fileName = '" + filename + "' AND username = '" + user + "' ;";
		sqlOperate();
		System.out.println("---------------------------------------Current File Deleted---------------------------------------");
	}
	
	
	public static void deleteFile() {
		retriveDb.retrieFileNames();
		System.out.println("Enter File Name You Want To Delete:");
		fileName = sc.next();
		deleteUserSingleFileDetails(fileName);
	}
	public static void deleteUser() {
		deleteUserAllFileDetails();
//		DeleteFromLogin();
	}
	

	
	

	
//	

}
