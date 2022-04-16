package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) {
		Statement stmt = null;
		try {
			//registering JDBC driver
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/d:/MyDB/prasDB", "prasDB",
					"pras");
			
			//execute create query
			System.out.println("Connection established.");
			System.out.println("Creating table in given database...");
			stmt = connection.createStatement();
			
			String sql = "CREATE TABLE   REGISTRATION " + "(id INTEGER not NULL, " + " first VARCHAR(255), "
					+ " last VARCHAR(255), " + " age INTEGER, " + " PRIMARY KEY ( id ))";
			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
			
			//closing connection
			connection.close();
		} catch (SQLException e) {
			System.out.println("Exception occurred.");
			System.out.println(e.getMessage());
		}
	}
}
