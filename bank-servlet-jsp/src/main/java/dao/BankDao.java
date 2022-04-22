package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Bank;
import util.ConnectionUtil;

public class BankDao {

	public List<Bank> findAll() {
		List<Bank> banks = new ArrayList<>();
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from bank_acc");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Bank bank = new Bank();
				bank.setId(rs.getInt("id"));
				bank.setAcc_name(rs.getString("acc_name"));
				bank.setAcc_number(rs.getString("acc_number"));
				bank.setBalance(rs.getInt("balance"));
				banks.add(bank);
			}
			ConnectionUtil.closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return banks;
	}

	public void save(Bank bank) {
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn
					.prepareStatement("INSERT INTO Bank_Acc (ACC_NAME, ACC_NUMBER, BALANCE) VALUES (?, ?, ?)");

			ps.setString(1, bank.getAcc_name());
			ps.setString(2, bank.getAcc_number());
			ps.setInt(3, bank.getBalance());
			ps.executeUpdate();
			ConnectionUtil.closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
