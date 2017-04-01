package edu.ycp.cs320.jporter7.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.jporter7.model.User;

public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		
	}
	
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{	
		
		if (req.getParameter("Create Account") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/accountCreation");
		}
		
		
		String errorMessage = null;
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean validCredentials = false;
		
		
		if (username == null || username.equals("") || password == null || password.equals("")) 
		{
		    errorMessage = "Please specify username and password";
		    System.out.println("null credentials");
		} 
		else 
		{
			req.getSession().setAttribute("username", username);
			req.getSession().setAttribute("password", password);
			if (username.equals("jporter") && password.equals("admin"))
			{
				validCredentials = true;
				System.out.println("valid credentials");
			}
			
		}
		
		
		if (req.getParameter("index") != null && validCredentials)
		{
			resp.sendRedirect(req.getContextPath() + "/index");
		}
		else if (req.getParameter("index") != null && !validCredentials)
		{
			//throw new ServletException("Unknown Command");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		
	}
	
}