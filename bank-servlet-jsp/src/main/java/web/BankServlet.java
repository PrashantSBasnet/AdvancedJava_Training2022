package web;

import java.io.IOException;

import dao.BankDao;
import dto.Bank;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class BankServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Bank bank = new Bank();
		

		bank.setAcc_name(request.getParameter("acc_name"));
		bank.setAcc_number(request.getParameter("acc_number"));
		
		bank.setBalance(Integer.parseInt(request.getParameter("balance")));
	
		BankDao bankDao = new BankDao();
		bankDao.save(bank);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/selectRecords.jsp");
		dispatcher.forward(request, response);
	}

}
