package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//PreparedStatement is used to prevent SQL Injection
public class PreparedStatementQuery {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/d:/MyDB/prasDB", "prasDB",
					"pras");

			PreparedStatement preparedStatement = connection.prepareStatement("insert into Registration values (?,?, ?, ?)");
			
			preparedStatement.setInt(1, 22);
			preparedStatement.setString(2, "NewRecord");
			preparedStatement.setString(3, "LastNameOfNewRecord");
			preparedStatement.setInt(4, 23);
			
			preparedStatement.executeUpdate();
			
			//closing connection
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
