package com.cotiviti.servlet.app;

import java.io.IOException;

import com.cotiviti.servlet.app.dao.BankDao;
import com.cotiviti.servlet.app.dto.Bank;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/withdraw")
public class WithdrawServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Bank bank = new Bank();
		

		bank.setAcc_name(request.getParameter("acc_name"));
		bank.setAcc_number(request.getParameter("acc_number"));
		
		bank.setBalance(Integer.parseInt(request.getParameter("balance")));
	
		BankDao BankDao = new BankDao();
		BankDao.withdraw(bank);
		response.sendRedirect("student");
	}
	

}
