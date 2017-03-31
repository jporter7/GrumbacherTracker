package edu.ycp.cs320.jporter7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class WeightRoomServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
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
			req.getRequestDispatcher("/_view/weightRoom.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{
		
		
		
		
	}
	
	
}
