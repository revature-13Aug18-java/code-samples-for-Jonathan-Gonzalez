package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReceiptDao;
import com.revature.dao.ReceiptDaoImpl;
import com.revature.model.Receipt;

/**
 * Servlet implementation class ReceiptServlet
 */
public class ReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idStr = request.getParameter("id");
		
		ReceiptDao rd = new ReceiptDaoImpl();
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();

		
		//if we get a parameter we want to display a single employee
		if(idStr != null) {
			int id = Integer.parseInt(idStr);
			List<Receipt> receipts = rd.getReceiptsById(id);
			//if we don't get anything from the database our id will be 0
			if(receipts.size()==0) {
				pw.print("[]");
			//if we are returned an employee from the database we want to display it in json format
			} else {
				String ReceiptString = om.writeValueAsString(receipts);
				pw.write(ReceiptString);
			}
		//if we do not get a valid parameter, we want to display all employees
		} else {
			List<Receipt> receipts = rd.getReceipts();
			String receiptString = om.writeValueAsString(receipts);
			receiptString = "{\"receipts\":"+receiptString+"}";
			pw.print(receiptString);
		}
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
