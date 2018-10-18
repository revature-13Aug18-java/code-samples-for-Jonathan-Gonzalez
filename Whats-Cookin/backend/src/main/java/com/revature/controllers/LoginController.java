package com.revature.controllers;


import java.util.Collections;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.RUser;
import com.revature.services.UserService;



@Controller
@RestController
@CrossOrigin
/**
 * @author Jonathan
 *This class is our controller for logging in and handling sessions.
 */
public class LoginController {

	private static Logger log = Logger.getRootLogger();
	private static UserService userService = new UserService();
	
	private LoginController() {
		super();
	}
	
	
	/**
	 * Perform a POST request to the endpoint /login to login and have a session.
	 * @param username
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value = { "/login" }, method = RequestMethod.POST)
	public RUser login(@RequestParam("userName") String username, @RequestParam("pswd") String password, HttpSession session) {
		
	    RUser user = userService.authenticateUser(username, password);
	    if(user!=null) {	    	
	        session.setAttribute("USER", user);
	        log.info((RUser) session.getAttribute("USER"));
	    } else {
	        return null;
	    }
	    return user;
	}
	
	
	/**
	 * Perform a GET request to the endpoint /session to get the current id of the logged in user.
	 * @param session
	 * @return
	 */
	@GetMapping("/session")
	public RUser getSession(HttpSession session) {
		if(session != null) {
			log.info((RUser) session.getAttribute("USER"));
			return (RUser) session.getAttribute("USER");
		}
	    return null;
	}
	
	  /**
	   * Perform a GET request to /logout to invalidate the session and logout.
	 * @param session
	 */
	@GetMapping("/logout")
	  public void logout(HttpSession session) {
	    session.invalidate();
	  }

	/**
	 * @deprecated
	 */
	@GetMapping("/login")
	public String getLogin() {
		return "Login";
	}

}