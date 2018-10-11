package com.revature.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class SubmitReceipt
 */
public class SubmitReceipt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubmitReceipt() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("username") != null) {
			request.getRequestDispatcher("SubmitReceipt.html").forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			double amount = Double.parseDouble(request.getParameter("amount"));
			String details = request.getParameter("details");
			String purchaseDate = request.getParameter("date");
			
			HttpSession session = request.getSession(false);
			
			int rid = 0;
			
			String sql = "SELECT COUNT(RID) FROM RECEIPT";

			try (Connection con = ConnectionUtil.getConnection();
					Statement s = con.createStatement();
					ResultSet rs = s.executeQuery(sql)
					){
						if(rs.next()) {
							rid = rs.getInt(1)+1;
						}
				
					} 
					catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			Receipt receipt = new Receipt();
			receipt.setAmount(amount);
			receipt.setDetails(details);
			receipt.setPurchaseDate(purchaseDate);
			receipt.setStatusDate(purchaseDate);
			receipt.setId(Integer.parseInt(session.getAttribute("id").toString()));
			receipt.setRid(rid);
			receipt.setStatus("PENDING");
			
			ReceiptDao rd = new ReceiptDaoImpl();
			rd.createReceipt(receipt);
			
			response.sendRedirect("pending");
				
//			System.out.println(e);
//				
//			EmployeeDao ed = new EmployeeDaoImpl();
//			int numCreated = ed.createEmployee(e);
//				
//			if(numCreated == 1) {
//					response.sendRedirect("success");
//				}else {
//					response.sendRedirect("error");
//				}
				
	}

}
