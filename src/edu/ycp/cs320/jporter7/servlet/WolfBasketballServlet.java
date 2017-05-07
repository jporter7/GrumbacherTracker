package edu.ycp.cs320.jporter7.servlet;

/*
 * this servlet is unused
 */
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.jporter7.model.User;

public class WolfBasketballServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		//req.getRequestDispatcher("/_view/multiplyNumbers.jsp").forward(req, resp);
		Object username = req.getSession().getAttribute("username");
		Object password = req.getSession().getAttribute("password");
		Object user = req.getSession().getAttribute("user");
		User user2 = (User)user;
		if (username == null || username.equals("") || password == null || password.equals(""))
		{
			System.out.println("Need to login");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else
		{
			req.getRequestDispatcher("/_view/wolfBasketball.jsp").forward(req, resp);
		}
	}
	
	
	@SuppressWarnings("unused")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller

		String errorMessage = null;
		//Double result = null;
		try 
		{
			if (false)
			{
				
			}
			else
			{
				
			}
		} 
		catch (NumberFormatException e) 
		{
			errorMessage = "Invalid double";
		}
		
		
		req.setAttribute("errorMessage", errorMessage);
		
		// Forward to view to render the result HTML document
		//req.getRequestDispatcher("/_view/multiplyNumbers.jsp").forward(req, resp);
	}

	private Double getDoubleFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Double.parseDouble(s);
		}
	}
}
