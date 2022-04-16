package maven;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ManipulateRecords {

	static int balance = 0;
	static String name;

	private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(ManipulateRecords.class);

	public static void main(String[] args) {
		Statement stmt = null;
		// ---connection
		try {
			Scanner scanner = new Scanner(System.in);

			// taking user input
			System.out.println("Enter Acc Holder's Name");
			String accName = scanner.nextLine();
			
			System.out.println("Press D for Depit and C for Credit");
			String opt = scanner.nextLine().toUpperCase().trim();

			Connection connection = DriverManager.getConnection("jdbc:h2:tcp://localhost/d:/MyDB/prasDB", "prasDB",
					"pras");
			stmt = connection.createStatement();
			String bal = "SELECT id, acc_name, acc_number, balance FROM BANK_ACC where ACC_NAME=" + "'" + accName + "'" + ";";
			ResultSet rs = stmt.executeQuery(bal);
			
			if (opt.equals("D")) {

				while (rs.next()) {
					balance = rs.getInt("balance");
				}
				
				System.out.println("Enter amount to withdraw");

				String debit = scanner.nextLine();
				int f = Integer.parseInt(debit);

				int remaining = balance - f;

				if (remaining > 0) {

					String query = "UPDATE BANK_ACC SET BALANCE = BALANCE" + "-" + "'" + f + "'" + " WHERE ACC_NAME = "
							+ "'" + accName + "'";

					System.out.println("Your account is debited by " + f);

					stmt.execute(query);

					// check condition for available balance

					SelectRecords sr = new SelectRecords();
					sr.Selecting();

				} // closes if

				else {
					System.out.println("Insufficient Balance!");
				}

			}

			else if (opt.equals("C")) {

				System.out.println("Enter amount to deposit");
				String debit = scanner.nextLine();
				int f = Integer.parseInt(debit);

				String query = "UPDATE BANK_ACC SET BALANCE = BALANCE" + "+" + "'" + f + "'" + " WHERE ACC_NAME = "
						+ "'" + accName + "'";

				stmt.execute(query);

				SelectRecords sr = new SelectRecords();
				sr.Selecting();

			}

			else {

				LOGGER.error("Invalid Option Selected!");

			}

			scanner.close();

//			// closing connection
			connection.close();

		} catch (SQLException e) {
			System.out.println("Exception occurred.");
			System.out.println(e.getMessage());
		}

	}
}
