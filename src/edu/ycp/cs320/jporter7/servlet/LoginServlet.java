package edu.ycp.cs320.jporter7.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.jporter7.model.PopulationCounter;
import edu.ycp.cs320.jporter7.model.User;
import edu.ycp.cs320.jporter7.populationdb.InitDatabase;
import edu.ycp.cs320.jporter7.populationdb.persist.DatabaseProvider;
import edu.ycp.cs320.jporter7.populationdb.persist.IDatabase;
import edu.ycp.cs320.jporter7.controller.PopulationCounterController;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	private static final String PopulationCounterController = null;
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
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		
	}
	
	//@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{	
				
		//redirect to the account creation page if it was clicked
		if (req.getParameter("Create Account") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/accountCreation");
		}
		
		
		String errorMessage = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User user = null;
		boolean validCredentials = false;
		
		//get all of the users rom the database
		ArrayList<User> userList = db.getAllUsers();
		
		//check if the username and password entered are present in the database
		if (username == null || username.equals("") || password == null || password.equals("")) 
		{
		    errorMessage = "Please specify username and password";
		    System.out.println("null credentials");
		} 
		else 
		{
			//set session information if the user logged in correctly
			req.getSession().setAttribute("username", username);
			req.getSession().setAttribute("password", password);
			for (int i = 0; i < userList.size(); i++)
			{
				if (userList.get(i).getUserName().equals(username) && userList.get(i).getPassword().equals(password))
				{
					validCredentials = true;
					user = userList.get(i);
					System.out.println("valid credentials");
				}
			}
			if (!validCredentials)
			{
				errorMessage = "Incorrect username or password";
				System.out.println(errorMessage);
			}
			
		}
		
		//redirect the user based on their login information
		req.getSession().setAttribute("user", user);
		if (req.getParameter("index") != null && validCredentials)
		{
			resp.sendRedirect(req.getContextPath() + "/index");
		}
		else if (req.getParameter("index") != null && !validCredentials)
		{
			//throw new ServletException("Unknown Command");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		req.setAttribute("errorMessage", errorMessage);
	}
	
}