package com.cotiviti.servlet.app.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.cotiviti.servlet.app.dto.Bank;
import com.cotiviti.servlet.app.util.ConnectionUtil;

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
	
	public List<Bank> findbyName(String name) {
		List<Bank> banks = new ArrayList<>();
		try {
			Connection conn = ConnectionUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from bank_acc where acc_name= '"+ name +"'");
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

	public void addBalance(Bank bank) {

		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			Connection conn = ConnectionUtil.getConnection();
			String query = "UPDATE BANK_ACC SET BALANCE = BALANCE" + "+" + "'" + bank.getBalance() + "'" + " WHERE ACC_NAME = "
					+ "'" + bank.getAcc_name() + "'" + " AND ACC_NUMBER = "
							+ "'" + bank.getAcc_number() + "'";
			pstmt = conn.prepareStatement(query); // create a statement
//			pstmt.setBalance(1, 300); // set input parameter 1
//			pstmt.setString(2, 1001); // set input parameter 2
			pstmt.executeUpdate(); // execute update statement

			ConnectionUtil.closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public void withdraw(Bank bank) {
		Statement stmt = null;
		PreparedStatement pstmt = null;

		try {
			Connection conn = ConnectionUtil.getConnection();
			String query = "UPDATE BANK_ACC SET BALANCE = BALANCE" + "-" + "'" + bank.getBalance() + "'" + " WHERE ACC_NAME = "
					+ "'" + bank.getAcc_name() + "'" + " AND ACC_NUMBER = "
							+ "'" + bank.getAcc_number() + "'";
			pstmt = conn.prepareStatement(query); // create a statement

			pstmt.executeUpdate(); // execute update statement

			ConnectionUtil.closeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}
