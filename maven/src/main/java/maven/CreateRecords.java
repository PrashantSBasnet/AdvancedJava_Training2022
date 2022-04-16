package maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class CreateRecords {

	public static void main(String[] args) {
		Statement stmt = null;
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/d:/MyDB/prasDB", "prasDB",
					"pras");
			stmt = connection.createStatement();

			String sql = "CREATE TABLE Bank_Acc " + "(id INTEGER not NULL AUTO_INCREMENT, " + "ACC_NAME VARCHAR(255), " +"ACC_NUMBER VARCHAR(255), "
					 + "BALANCE INTEGER," + " PRIMARY KEY ( id ))";

			//execute the query
			stmt.executeUpdate(sql);
			System.out.println("Table created successfully.");
			// closing connection
			connection.close();

		} catch (SQLException e) {
			System.out.println("Exception occurred.");
			System.out.println(e.getMessage());
		}

	}

}
