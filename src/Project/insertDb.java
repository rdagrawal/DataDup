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
	
	
	
	
	
	/*
	 ------------------------------------Login Table------------------------------------
	 */
	
//	1. Insert into Login Table
	public static void InsertInLogin(String userName, String password, String name, String email, long contact) throws Exception
	{				//register new user in login table
		sql_query = "INSERT INTO LOGIN VALUES('"+ userName + "' , '" + password +"' , '"+ name + "' , '" + email +"' , '"+contact + "');";
		sqlOperate();
		System.out.println("---------------------------------------Login Details Inserted---------------------------------------");
		userWork.run();
	}	
	
	
	
	
	/*
	 ------------------------------------Hash Table------------------------------------
	 */
//	3. Insert into Hash Table
	public static void insertInHashTable( int keyData, String arrr) throws Exception{		// Insert In hashMap table when we get new Roll Hash Value
		sql_query = "INSERT INTO HASHIS VALUES ('" + keyData + "' , '" + arrr + "');" ;
		sqlOperate();
		System.out.println("---------------------------------------Data Inserted HashTable---------------------------------------");
	}
//	4. Update into  Hash Table
	public static void updateInHashTable(int keyData, String arrr){			//when get the same roll hash value but different SHA256
		sql_query = "UPDATE HASHIS SET HASH256 = '" + arrr + "'where HASH ='"+keyData+"';" ;
		sqlOperate();
		System.out.println("---------------------------------------Data Updated in HashTable---------------------------------------"); 
	}
//	5. Delete From Hash Table	

	

	
	
	/*
	 ------------------------------------SHACount Table------------------------------------
	 */
//	6. Insert Into SHACOUNT Table
	public static void insertInShaCount( String sha256, int refernceCount) throws Exception{	    //whenever Chunk Created
		sql_query = "INSERT INTO SHACOUNT VALUES('" + sha256 + "'," + refernceCount + ");";
		sqlOperate();
		System.out.println("---------------------------------------Data Inserted Into ShaRefrence---------------------------------------"); 
	}
	
//	7. Update Into SHACOUNT Table	
	public static void updateInShaCount( String sha256, int refernceCount) throws Exception
	{		//chunk Found with same hash
		sql_query = "UPDATE SHACOUNT SET count = '" + refernceCount + "'where SHA256 ='" + sha256 + "';" ;
		sqlOperate();
		System.out.println("---------------------------------------Data Updated in HashTable---------------------------------------"); 
	
	}
//	8. Delete Into SHACOUNT Table


	
	
	
	
	
	/*
	 ------------------------------------FileDetails Table------------------------------------
	 */
//	9. Insert Into UserFile
	public static void insertInFileDetails(String keyData, String arrr) throws Exception
	{			// Insert In FilesDetails table when user uploads a new file
		sql_query = "INSERT INTO FILEDETAILS VALUES ('" + user + "' , '" +keyData + "' , '" + arrr + "');" ;
		sqlOperate();
		System.out.println("---------------------------------------Data Inserted in FileDetails---------------------------------------");
	}
//	10. Update In FileDetails
	public static void UpdateInFileDetails( String keyData, String arrr) throws Exception
	{
		
	}

	

}
