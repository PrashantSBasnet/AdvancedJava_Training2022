package maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectRecords {

	public static void main(String[] args) {
		SelectRecords sr = new SelectRecords();
		sr.Selecting();
	}
		
		
		void Selecting() {
			Statement stmt = null;
			
		try {
			// registering JDBC driver. h2 in server mode
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/d:/MyDB/prasDB", "prasDB",
			"pras");
			stmt = connection.createStatement();

			// execute create query
			System.out.println("Fectched Records...");

			// STEP 3: Execute a query
			String sql = "SELECT id, acc_name, acc_number, balance FROM Bank_Acc";
			ResultSet rs = stmt.executeQuery(sql);

			// STEP 4: Extract data from result set
			while (rs.next()) {
				// Retrieve by column name
				int id = rs.getInt("id");
				String acc_name = rs.getString("acc_name");
				String acc_number = rs.getString("acc_number");
				int balance = rs.getInt("balance");

				// Display values
				System.out.print("ID: " + id);
				System.out.print(", Acc_Name: " + acc_name);
				System.out.print(", Acc_No: " + acc_number);
				System.out.println(", Balance: " + balance);
			}

			// closing connection
			connection.close();

		} catch (SQLException e) {
			System.out.println("Exception occurred.");
			System.out.println(e.getMessage());
		}
	}
	
}
