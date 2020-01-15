package Project;

import java.sql.Statement;




public class login 
{	
//	static final String JDBC_DRIVER = "org.h2.Driver"; 
//	static final String DB_URL = "jdbc:h2:~/test";
//	static final String USER = "sa";
//	static final String PASS = "";  
	
	public boolean checklog(String user,String pass) throws Exception
	{
		
		Connect c=new Connect();
		Statement stmt = null;
		String query="SELECT EXISTS(SELECT * FROM login WHERE username = '"+ user + "' AND password = '" + pass + "')";		
		System.out.println(query);
		try
		{
			stmt = c.getConnect().createStatement();
			stmt.execute(query);
			boolean res = stmt.execute(query);
			System.out.println(res);
			stmt.close();
			c.getConnect().close();
			if(res == true)
			{
				return true;
			}
			else
			{
				return false;
			}	
		}
		catch(Exception e)
		{ //Handle errors for JDBC 
			e.printStackTrace();
		}
		return false;

		
//		
//		try {
////            String queryString = "SELECT SName, SPwd FROM staff";
//            @SuppressWarnings("null")
//			boolean results = stmt.execute(query);
//            System.out.println("------------------------------" + results);
//
//            
//            if(results==true)
//            {
//            	System.out.println("Successful");
//            	return true;
//            }
//            else
//            {
//            	System.out.println("Failed");
//            	return false;
//            }
//            c.getConnect().close();
//        } catch (Exception sql) {
//
//            sql.printStackTrace();
//        }
//		return false;
//		
//		
////		PreparedStatement pstmt = c.getConnect().prepareStatement(query);
////		ptmt.setString(1, user);
////		pstmt.setString(2,pass);
////		int i=pstmt.executeUpdates();
////		if(i==1)
////		{
////			return true;
////		}
////		else
////		{
////			return false;
////		}
	}

//	SELECT EXISTS (
//			  SELECT * FROM login_details WHERE username = ? AND password = ?
//			)

}
