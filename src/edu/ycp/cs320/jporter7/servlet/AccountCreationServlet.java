package edu.ycp.cs320.jporter7.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.jporter7.controller.UserController;
import edu.ycp.cs320.jporter7.model.User;
import edu.ycp.cs320.jporter7.populationdb.persist.IDatabase;
import edu.ycp.cs320.jporter7.populationdb.persist.DerbyDatabase;

public class AccountCreationServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private IDatabase db;
	
	@Override
    public void init() throws ServletException
    {
        this.db = (IDatabase)getServletContext().getAttribute("database");
    }

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
		String errorMessage = null;
		
		try 
		{
			//create a user and controller, set the user's fields using the parameters 
			//that are input from the webpage (jsp)
			user = new User();
			controller = new UserController(user);
			controller.createUser(req.getParameter("password"), req.getParameter("username"), req.getParameter("email"),
					req.getParameter("firstName"), req.getParameter("lastName"), getIntFromParameter(req.getParameter("id")));
			
			//if all of the parameters meet certain criteria in the controller, create the user and insert
			//user into the database
			if (user.getPassword() != null && user.getUserName() != null && user.getFirstName() != null && user.getLastName() != null
					&& user.getId() != 0)
			{
				User user2 = db.insertUser(user.getPassword(), user.getUserName(), user.getEmail(), 
						user.getFirstName(), user.getLastName(), Integer.toString(user.getId()));
				System.out.println("user added to database");
				req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
			}
			else
			{
				System.out.println("user was not created correctly");
				req.getRequestDispatcher("/_view/accountCreation.jsp").forward(req, resp);
			}
			
		} 
		catch (NumberFormatException e) 
		{
			errorMessage = "Invalid double";
		}
		
		req.setAttribute("user", user);
		req.setAttribute("errorMessage", errorMessage);
		
	}

	private Integer getIntFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Integer.parseInt(s);
		}
	}
}