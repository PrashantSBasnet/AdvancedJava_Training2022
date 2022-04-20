package com.cotiviti.servlet.app.filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter("/*")
public class LoggedInCheckFilter extends HttpFilter {

	private static final long serialVersionUID = 1L;

	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession httpSession = request.getSession(false);
		String requestUri = request.getRequestURI();
		if (requestUri != null) {
			if (requestUri.startsWith(request.getContextPath() + "/login")) {
				if (httpSession != null && httpSession.getAttribute("user") != null) {
					response.sendRedirect(request.getContextPath() + "/student");
					return;
				}
			} else {
				if (httpSession == null || httpSession.getAttribute("user") == null) {
					response.sendRedirect(request.getContextPath() + "/login");
					return;
				}
			}
		}
		chain.doFilter(request, response);
	}
}
