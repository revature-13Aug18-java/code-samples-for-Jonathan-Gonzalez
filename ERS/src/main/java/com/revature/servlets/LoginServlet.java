package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.AccountDaoImpl;
import com.revature.model.Account;

public class LoginServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("Login.html");
		rd.forward(request, response);
		}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		
		AccountDaoImpl ad = new AccountDaoImpl();
		Account a = ad.login(user, pass);
		
		HttpSession session = request.getSession();
		
		try {
			session.setAttribute("username", a.getUsername());
			session.setAttribute("id", a.getId());
			session.setAttribute("role", a.getRole());
			response.sendRedirect("dashboard");
			
		}catch (NullPointerException e) {
			response.sendRedirect("login");
		}
		
	}

}
