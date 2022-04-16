package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {
	public static void main(String[] args) {
		Statement stmt = null;
		try {
			//registering JDBC driver
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/d:/MyDB/prasDB", "prasDB",
					"pras");
			
			//execute create query
			System.out.println("Inserting Records...");
			
			 // STEP 3: Execute a query 
	         stmt = connection.createStatement();  
	         String sql = "INSERT INTO Registration " + "VALUES (1003, 'Zara', 'Ali', 18)"; 
	         
	         stmt.executeUpdate(sql); 
	         sql = "INSERT INTO Registration " + "VALUES (1012, 'Mahnaz', 'Fatma', 25)";  
	         
	         stmt.executeUpdate(sql); 
	         sql = "INSERT INTO Registration " + "VALUES (1042, 'Zaid', 'Khan', 30)"; 
	         
	         stmt.executeUpdate(sql); 
	         sql = "INSERT INTO Registration " + "VALUES(1023, 'Sumit', 'Mittal', 28)"; 
	         
	         stmt.executeUpdate(sql); 
	         System.out.println("Inserted records into the table..."); 
			
			
			
			//closing connection
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Exception occurred.");
			System.out.println(e.getMessage());
		}
	}

}
