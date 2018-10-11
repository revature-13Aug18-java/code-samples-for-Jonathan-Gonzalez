package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class DashboardServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("username") != null) {
			request.getRequestDispatcher("Dashboard.html").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
		
	}
	
}
