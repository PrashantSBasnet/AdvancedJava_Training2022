package com.cotiviti.servlet.app;

import java.io.IOException;
import java.io.PrintWriter;

import com.cotiviti.servlet.app.dao.UserDao;
import com.cotiviti.servlet.app.dto.User;
import com.cotiviti.servlet.app.util.StringUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"utf-8\">");
		out.println("<title>Login Page</title>");
		out.println("</head>");
		out.println("<body>");

		if (request.getParameter("invalid") != null) {
			out.println("<label style=\"color:red;\">Invalid username & password. Please try again!!</label>");
			out.println("<br /><br />");
		} else if (request.getParameter("logout") != null) {
			out.println("<label style=\"color:green;\">You are logged out successfully!!</label>");
			out.println("<br /><br />");
		}

		out.println("<form action=\"\" method=\"post\">		");
		out.println("<label>Username : </label>");
		out.println("<input name=\"username\" />");
		out.println("<br />");
		out.println("<label>Password : </label>");
		out.println("<input name=\"password\" type=\"password\" />");
		out.println("<br />");
		out.println("<button type=\"submit\">Login</button>");
		out.println("</form>");

		out.println("</body>");
		out.println("</html>");
		
		
		out.println("");
		out.println("");
		
		
		}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (!StringUtil.hasContent(username) || !StringUtil.hasContent(password)) {
			response.sendRedirect("login?invalid");
			return;
		}

		UserDao userDao = new UserDao();
		User user = userDao.findOneByUsernameAndPassword(username.trim(), password.trim());
		if (user == null) {
			response.sendRedirect("login?invalid");
		} else {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user);
			response.sendRedirect("student");
		}
	}
}
