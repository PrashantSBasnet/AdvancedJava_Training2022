package com.cotiviti.servlet.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.cotiviti.servlet.app.dao.BankDao;
import com.cotiviti.servlet.app.dto.Bank;
import com.cotiviti.servlet.app.util.ConnectionUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deposit")
public class DepositServlet extends HttpServlet {

	BankDao bankDao = new BankDao();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Bank bank = new Bank();

		bank.setAcc_name(request.getParameter("acc_name"));
		bank.setAcc_number(request.getParameter("acc_number"));

		bank.setBalance(Integer.parseInt(request.getParameter("balance")));

		BankDao bankDao = new BankDao();
		bankDao.addBalance(bank);
		response.sendRedirect("student");
	}

}
