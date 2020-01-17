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
            	System.out.println("success");
            	return true;
            } else {
            	System.out.println("invalid");
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
