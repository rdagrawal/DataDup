package Project;

import java.awt.List;


import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;



public class retriveDb extends downloadFile{
	static String sql_query;
	
	
	public static int sqlOperate(String to_display) 
	{
		Connect c=new Connect();
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = c.getConnect().createStatement();
			rs = stmt.executeQuery(sql_query);
			System.out.println(rs);
			while(rs.next())
			{
				String filename = rs.getString(to_display);
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
		return 0; 
	}
	
	
	public static void retrive_fileArray()
	{
		sql_query= "Select FILEARRAY256 from "+ user +" where FILENAME = '"+fileName+"';";
		sqlOperate("FILEARRAY256");
	}
	public static void retrieFileNames() 
	{
		sql_query= "Select FILENAME from "+ user;
		sqlOperate("FILENAME");
	}
	
	@SuppressWarnings({ "unused" })
	public static void retrive_hashmap() 
	{
		Connect c=new Connect();
		Statement stmt = null;
		ResultSet rs = null;
		try
		{
			stmt = c.getConnect().createStatement();
			rs = stmt.executeQuery("SELECT * FROM HASHMAP ");
			System.out.println(rs);
			while(rs.next())
			{
				int hashVal = rs.getInt("ROLLHASH");
				java.sql.Array arr =  rs.getArray("SHA256");
//				List arrr = (List) Arrays.asList(arr);
//				ArrayList<String> arrr = new ArrayList<String>();
				System.out.println(arr);
//				System.out.println(arrr);
//				Collections.addAll(arrr, arr);
//				map.put(hashVal, arr);
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
