package edu.ycp.cs320.jporter7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class RacquetBallServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		//req.getRequestDispatcher("/_view/multiplyNumbers.jsp").forward(req, resp);
		Object username = req.getSession().getAttribute("username");
		Object password = req.getSession().getAttribute("password");
		HttpSession session= req.getSession(false); 
		if (username == null || username.equals("") || password == null || password.equals(""))
		{
			System.out.println("Need to login");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else
		{
			req.getRequestDispatcher("/_view/reservations.jsp").forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Decode form parameters and dispatch to controller
		//Numbers model = new Numbers();
		//NumbersController controller;
		
		String errorMessage = null;
		//Double result = null;
		try 
		{
			Double first = getDoubleFromParameter(req.getParameter("first"));
			Double second = getDoubleFromParameter(req.getParameter("second"));
			//Double third = getDoubleFromParameter(req.getParameter("third"));

			if (first == null || second == null) 
			{
				errorMessage = "Please specify two numbers";
			} 
			else 
			{
				//model.setFirst(first);
				//model.setSecond(second);
				//model.setThird(third);
				//controller = new NumbersController(model);
				//controller.multiply();
			}
		} 
		catch (NumberFormatException e) 
		{
			errorMessage = "Invalid double";
		}
		
		// Add parameters as request attributes
		//req.setAttribute("model.first", model.getFirst());
		//req.setAttribute("model.second", model.getSecond());
		//req.setAttribute("model", model);
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		//req.setAttribute("model.result", model.getMultiplyResult());
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/multiplyNumbers.jsp").forward(req, resp);
	}

	private Double getDoubleFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Double.parseDouble(s);
		}
	}
}
