package edu.ycp.cs320.jporter7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		System.out.println("In the Index servlet");
		
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{
		if (req.getParameter("Grumbacher") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/grumbacher");
		}
		else if (req.getParameter("GuessingGame") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/guessingGame");
		}
		else if (req.getParameter("MultiplyNumbers") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/multiplyNumbers");
		}
		else if (req.getParameter("WeightRoom") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/weightRoom");
		}
		else if (req.getParameter("Create Account") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/accountCreation");
		}
		else
		{
			throw new ServletException("Unknown Command");
		}
		
	}
	
}
