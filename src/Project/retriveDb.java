/*
 * 
 * 
 * Don't touch it
 * 
 * 
 * 
 * 
 */


package Project;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;



public class retriveDb extends downloadFile{
	static String sql_query;
	
	public static int retrive_fileArray()
	{
		sql_query= "Select FILEARRAY256 from FILEDETAILS where FILENAME = '"+fileName+"' AND USERNAME = '"+user+"';";		
		Connect c=new Connect();
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = c.getConnect().createStatement();
			rs = stmt.executeQuery(sql_query);
			while(rs.next())
			{
				String filearr = rs.getString("FILEARRAY256");
				String str[] = filearr.split(",");
				for(int i=0; i<str.length;i++)
				{
					array_list.add(str[i]);
				}				
			}
			stmt.close();
			c.getConnect().close();	
		}
		catch(Exception e)
		{ //Handle errors for JDBC 
			e.printStackTrace();
		}
		return 0;
	}
	public static void retrieFileNames() 
	{
		sql_query= "Select FILENAME from "+ user;
		Connect c=new Connect();
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = c.getConnect().createStatement();
			rs = stmt.executeQuery(sql_query);
			while(rs.next())
			{
				String filename = rs.getString("FILENAME");
				System.out.println(filename);
			}
			System.out.println();
			stmt.close();
			c.getConnect().close();	
		}
		catch(Exception e)
		{ //Handle errors for JDBC 
			e.printStackTrace();
		}
	}

	public static void retrive_hashmap() 
	{
		Connect c=new Connect();
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = c.getConnect().createStatement();
			rs = stmt.executeQuery("SELECT * FROM HASHIS ");
			System.out.println(rs);
			while(rs.next())
			{
				int hashVal = rs.getInt(1);
				String arr =  rs.getString(2);
				ArrayList<String> arrr = new ArrayList<String>(Arrays.asList(arr));
//				System.out.println(arrr);
				map.put(hashVal,arrr);
			}
			System.out.println();
			stmt.close();
			c.getConnect().close();
		}
		catch(Exception e)
		{ //Handle errors for JDBC 
			e.printStackTrace();
		}
	}
	public static void retrive_hashCount()
	{
		Connect c=new Connect();
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = c.getConnect().createStatement();
			rs = stmt.executeQuery("SELECT * FROM SHACOUNT ");
			System.out.println(rs);
			while(rs.next())
			{
				int count = rs.getInt(2);
				String rsha256 =  rs.getString(1);
				map4count.put(rsha256,count);
			}
			System.out.println();
			stmt.close();
			c.getConnect().close();
		}
		catch(Exception e)
		{ //Handle errors for JDBC 
			e.printStackTrace();
		}
	}
}
