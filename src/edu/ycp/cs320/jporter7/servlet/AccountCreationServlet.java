package edu.ycp.cs320.jporter7.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.jporter7.controller.NumbersController;
import edu.ycp.cs320.jporter7.controller.UserController;
import edu.ycp.cs320.jporter7.model.Numbers;
import edu.ycp.cs320.jporter7.model.User;

public class AccountCreationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		req.getRequestDispatcher("/_view/accountCreation.jsp").forward(req, resp);
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		User user = null;
		UserController controller;
		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		try 
		{
			user = new User();
			controller = new UserController(user);
			controller.createUser(req.getParameter("password"), req.getParameter("username"), req.getParameter("email"),
					req.getParameter("firstName"), req.getParameter("lastName"), getIntFromParameter(req.getParameter("id")));
			
			System.out.println("User Created in Servlet");
			System.out.println(user.getPassword() + "," + user.getUserName() + "," +  user.getFullName() + "," +
					user.getEmail() + "," + user.getId() + "," + user.getIsFaculty());
		} 
		catch (NumberFormatException e) 
		{
			errorMessage = "Invalid double";
		}
		req.setAttribute("user", user);
		req.setAttribute("errorMessage", errorMessage);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/accountCreation.jsp").forward(req, resp);
	}

	private Integer getIntFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Integer.parseInt(s);
		}
	}
}