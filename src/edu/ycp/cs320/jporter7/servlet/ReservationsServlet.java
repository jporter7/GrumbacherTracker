package edu.ycp.cs320.jporter7.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.jporter7.model.Reservation;
import edu.ycp.cs320.jporter7.model.Room;
import edu.ycp.cs320.jporter7.model.User;
import edu.ycp.cs320.jporter7.populationdb.persist.IDatabase;


public class ReservationsServlet extends HttpServlet {
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
		ArrayList<Reservation> test2 = new ArrayList<Reservation>();
		test2 = db.getReservationsForRoom("25");
		Room test = new Room(test2);
		
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
			req.setAttribute("test", test);
			req.getRequestDispatcher("/_view/reservations.jsp").forward(req, resp);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		// Decode form parameters and dispatch to controller
		ArrayList<Reservation> test2 = new ArrayList<Reservation>();
		test2 = db.getReservationsForRoom("25");
		Room test = new Room(test2);
			
		
		String errorMessage = null;
		try 
		{
			
			Calendar date = Calendar.getInstance();
			//Date date = new Date();
			//c.setTime(date);
			
			String today = Integer.toString(date.get(Calendar.MONTH) + 1) + "/" + Integer.toString(date.get(Calendar.DAY_OF_MONTH)) 
					+ "/" + Integer.toString(date.get(Calendar.YEAR));
			System.out.println("checking which reservation was taken");
			if(req.getParameter("time").equals("830am"))
			{
				Object user = req.getSession().getAttribute("user");
				User user2 = (User)user;
				Reservation reservation = new Reservation(today, "830am", user2.getDbId(), 25);
				
				
				db.insertReservation(reservation.getDate(), reservation.getStartTime(), 25, user2.getDbId());
			}
			else if (req.getParameter("time").equals("9am"))
			{
				Object user = req.getSession().getAttribute("user");
				User user2 = (User)user;
				Reservation reservation = new Reservation(today, "9am", user2.getDbId(), 25);
				
				db.insertReservation(reservation.getDate(), reservation.getStartTime(), 25, user2.getDbId());
			}
		} 
		catch (NumberFormatException e) 
		{
			errorMessage = "Invalid double";
		}
		
		
		// Forward to view to render the result HTML document
		req.setAttribute("test", test);
		req.getRequestDispatcher("/_view/reservations.jsp").forward(req, resp);
	}

	private String getDateForReservations() 
	{
		String date = null;
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		reservations = db.getReservationsForRoom("25");
		for (Reservation r : reservations)
		{
			date = r.getDate();
		}
		
		return date;
	}
}