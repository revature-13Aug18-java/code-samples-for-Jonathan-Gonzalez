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

import com.revature.dao.ProfileDao;
import com.revature.dao.ProfileDaoImpl;

import com.revature.model.Profile;
import com.revature.util.ConnectionUtil;

/**
 * Servlet implementation class UpdateProfile
 */
public class UpdateProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		if(session != null && session.getAttribute("username") != null) {
			request.getRequestDispatcher("UpdateProfile.html").forward(request, response);
		}else {
			response.sendRedirect("login");
		}	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String street = request.getParameter("street");
		String state = request.getParameter("state");
		String city = request.getParameter("city");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		long phone = Long.parseLong(request.getParameter("phone"));
		String hireDate = request.getParameter("hireDate");
		String birthDate = request.getParameter("birthDate");
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession(false);
			
		Profile profile = new Profile();
		profile.setId(Integer.parseInt(session.getAttribute("id").toString()));
		profile.setFname(fname);
		profile.setLname(lname);
		profile.setStreet(street);
		profile.setState(state);
		profile.setCity(city);
		profile.setZipcode(zipcode);
		profile.setPhone(phone);
		profile.setHireDate(hireDate);
		profile.setBirthDate(birthDate);
		profile.setEmail(email);
		
		ProfileDao pd = new ProfileDaoImpl();
		pd.updateProfile(profile);
		
		response.sendRedirect("viewprofile");
	}

}
