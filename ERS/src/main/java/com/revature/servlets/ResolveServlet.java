package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReceiptDao;
import com.revature.dao.ReceiptDaoImpl;
import com.revature.model.Receipt;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class ResolveServlet
 */
public class ResolveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResolveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int rid = Integer.parseInt(request.getParameter("rid"));
		String outcome = request.getParameter("outcome");
		String resolvedBy = request.getParameter("resolvedby");
		
		HttpSession session = request.getSession(false);
		
		ReceiptDao rd = new ReceiptDaoImpl();
		rd.resolveReceiptByRid(rid, outcome, resolvedBy);
		
		response.sendRedirect("dashboard");
		
		
	}

}
