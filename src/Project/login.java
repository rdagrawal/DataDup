/*
 * 
 * 
 * Don't Touch it
 * 
 * 
 * 
 */

package Project;

import java.sql.ResultSet;
import java.sql.Statement;

public class login 
{		
	public boolean checklog(String user,String pass) throws Exception
	{		
		Connect c=new Connect();
		Statement stmt = null;
		String query="SELECT * FROM login WHERE username = '"+ user + "' AND password = '" + pass + "'";		
		System.out.println(query);
		try
		{
			stmt = c.getConnect().createStatement();
			ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
            	return true;
            } else {
            	return false;
            }
		}
		catch(Exception e)
		{ //Handle errors for JDBC 
			e.printStackTrace();
		}
		return false;
	}
}
