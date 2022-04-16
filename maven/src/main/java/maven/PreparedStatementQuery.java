package maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PreparedStatementQuery {

	public static void main(String[] args) {
			// TODO Auto-generated method stub
			try {
				Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/d:/MyDB/prasDB", "prasDB",
						"pras");

				PreparedStatement preparedStatement = connection.prepareStatement("insert into BANK_ACC values (?,?, ?, ?)");
				
				preparedStatement.setInt(1, 1);
				preparedStatement.setString(2, "Prashant");
				preparedStatement.setString(3, "12354567890");
				preparedStatement.setInt(4, 50000);
				
				preparedStatement.executeUpdate();
				
				//closing connection
				connection.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
