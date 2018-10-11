package com.revature.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ProfileDao;
import com.revature.dao.ProfileDaoImpl;
import com.revature.dao.ReceiptDao;
import com.revature.dao.ReceiptDaoImpl;
import com.revature.model.Profile;
import com.revature.model.Receipt;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idStr = request.getParameter("id");
		
		ProfileDao pd = new ProfileDaoImpl();
		ObjectMapper om = new ObjectMapper();
		PrintWriter pw = response.getWriter();

		
		//if we get a parameter we want to display a single employee
		if(idStr != null) {
			int id = Integer.parseInt(idStr);
			Profile profile = pd.getProfileById(id);
			//if we don't get anything from the database our id will be 0
			if(profile == null) {
				pw.print("invalid employee id");
			//if we are returned an employee from the database we want to display it in json format
			} else {
				String profileString = om.writeValueAsString(profile);
				pw.write(profileString);
			}
		//if we do not get a valid parameter, we want to display all employees
		}
		else {
			List<Profile> profiles = pd.getProfiles();
			String profilesString = om.writeValueAsString(profiles);
			profilesString = "{\"profiles\":"+profilesString+"}";
			pw.print(profilesString);
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
