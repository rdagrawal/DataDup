package Project;

import java.sql.Connection;
import java.sql.Statement;

public class retriveDb {
	static final String JDBC_DRIVER = "org.h2.Driver"; 
	static final String DB_URL = "jdbc:h2:~/test";
	   //  Database credentials 
	static final String USER = "sa";
	static final String PASS = "";
	Connection conn = null; 
    Statement stmt = null; 
}
