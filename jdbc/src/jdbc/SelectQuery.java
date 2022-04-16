package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectQuery {

	public static void main(String[] args) {
		Statement stmt = null;
		try {
			//registering JDBC driver. h2 in server mode
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/d:/MyDB/prasDB", "prasDB",
					"pras");
			stmt = connection.createStatement(); 
			
			//execute create query
			System.out.println("Fectched Records...");
			
			 // STEP 3: Execute a query 
			 String sql = "SELECT id, first, last, age FROM Registration"; 
	         ResultSet rs = stmt.executeQuery(sql); 
	         
	         // STEP 4: Extract data from result set 
	         while(rs.next()) { 
	            // Retrieve by column name 
	            int id  = rs.getInt("id"); 
	            int age = rs.getInt("age"); 
	            String first = rs.getString("first"); 
	            String last = rs.getString("last");  
	            
	            // Display values 
	            System.out.print("ID: " + id); 
	            System.out.print(", Age: " + age); 
	            System.out.print(", First: " + first); 
	            System.out.println(", Last: " + last); 
	         } 
			
			
			//closing connection
			connection.close();
			
		} catch (SQLException e) {
			System.out.println("Exception occurred.");
			System.out.println(e.getMessage());
		}
	}
}
