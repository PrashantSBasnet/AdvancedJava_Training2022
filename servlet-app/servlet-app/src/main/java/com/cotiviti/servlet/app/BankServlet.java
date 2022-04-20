package com.cotiviti.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;

import com.cotiviti.servlet.app.dao.BankDao;
import com.cotiviti.servlet.app.dto.Bank;
import com.cotiviti.servlet.app.dto.Gender;
import com.cotiviti.servlet.app.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/student")
public class BankServlet extends HttpServlet {
	
	BankDao dao = new BankDao();

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Bank List</title>");

		out.println("<style>");
		out.println("table, th, td { border: 1px solid black; border-collapse: collapse; }");
		out.println("</style>");

		out.println("</head>");
		out.println("<body>");

		HttpSession httpSession = request.getSession();
		out.println("<h2>");
		out.println("Hi, " + ((User) httpSession.getAttribute("user")).getUsername() + " ");
		out.println("<a href=\"logout\" title=\"Logout\">logout</a>");
		out.println("</h2>");
		
		String name= (String)((User) httpSession.getAttribute("user")).getUsername();

		out.println("<h2>Bank Form</h2>");
		out.println("<form action=\"\" method=\"post\">");
		out.println("<label>AccName : </label>");
		out.println("<input name=\"acc_name\" />");
		out.println("<br />");
		out.println("<label>AccNumber : </label>");
		out.println("<input name=\"acc_number\" />");
		out.println("<br />");
		out.println("<label>Balance: </label>");
		out.println("<input name=\"balance\" />");
		out.println("<br />");
		out.println("<button type=\"submit\">Add</button>");
		out.println("</form>");
		
		out.println("");
		out.println("");
		out.println("------------------------------------------------------------------");
		
		
		/*to withdraw balance*/
		out.println("<h2>Withdraw Form</h2>");
		out.println("<form action=\"withdraw\" method=\"POST\">");
		out.println("<label>AccName : </label>");
		out.println("<input name=\"acc_name\" />");
		out.println("<br />");
		out.println("<label>AccNumber : </label>");
		out.println("<input name=\"acc_number\" />");
		out.println("<br />");
		out.println("<label>Balance: </label>");
		out.println("<input name=\"balance\" />");
		out.println("<br />");
		out.println("<button type=\"submit\">Withdraw</button>");
		out.println("</form>");
		
		out.println("");
		out.println("");
		out.println("------------------------------------------------------------------");
	
		/*to add balance*/
		out.println("<h2>Deposit Form</h2>");
		out.println("<form action=\"deposit\" method=\"POST\">");
		out.println("<label>AccName : </label>");
		out.println("<input name=\"acc_name\" />");
		out.println("<br />");
		out.println("<label>AccNumber : </label>");
		out.println("<input name=\"acc_number\" />");
		out.println("<br />");
		out.println("<label>Balance: </label>");
		out.println("<input name=\"balance\" />");
		out.println("<br />");
		out.println("<button type=\"submit\">Add</button>");
		out.println("</form>");


		
		out.println("<h2>Bank List</h2>");
		out.println("<table style=\"width:100%\">");
		out.println("<tr>");
		out.println("<th>Id</th>");
		out.println("<th>ACC_Name</th>");
		out.println("<th>ACC_Number</th>");
		out.println("<th>Balance</th>");
		out.println("</tr>");
		
		
		BankDao bankDao = new BankDao();
		for (Bank bank : bankDao.findAll()) {
			out.println("<tr>");
			out.println("<td>" + bank.getId() + "</td>");
			out.println("<td>" + bank.getAcc_name() + "</td>");
			out.println("<td>" + bank.getAcc_number() + "</td>");
			out.println("<td>" + bank.getBalance() + "</td>");
			out.println("</tr>");
		}
		out.println("</table>");

		out.println("</body>");
		out.println("</html>");
	}
	
	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Bank bank = new Bank();
		

		bank.setAcc_name(request.getParameter("acc_name"));
		bank.setAcc_number(request.getParameter("acc_number"));
		
		bank.setBalance(Integer.parseInt(request.getParameter("balance")));
	
		BankDao BankDao = new BankDao();
		BankDao.save(bank);
		response.sendRedirect("student");
	}
	
}
