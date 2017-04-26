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
	private Calendar date;
	private String today;
	private User userWithReservation = null;
	
	@Override
    public void init() throws ServletException
    {
        this.db = (IDatabase)getServletContext().getAttribute("database");
        this.date = Calendar.getInstance();
        this.today = Integer.toString(date.get(Calendar.MONTH) + 1) + "/" + Integer.toString(date.get(Calendar.DAY_OF_MONTH)) 
		+ "/" + Integer.toString(date.get(Calendar.YEAR));
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		ArrayList<Reservation> test2 = new ArrayList<Reservation>();
		ArrayList<User> users = new ArrayList<User>();
		//users = db.getUserFromReservationTime(room, time);
		test2 = db.getReservationsForRoom("25", today);
		for (int i = 0; i < test2.size(); i++)
		{
			users.add(db.getUserFromReservationTime("25", test2.get(i).getStartTime()));
		}
		for (int i = 0; i < users.size(); i++)
		{
			if (users.get(i).getId() == 902000000)
			{
				users.get(i).setIsFaculty(true);
			}
		}
		Room test = new Room(test2, users);
		
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
		test2 = db.getReservationsForRoom("25", today);
		ArrayList<User> users = new ArrayList<User>();
		
		for (int i = 0; i < test2.size(); i++)
		{
			users.add(db.getUserFromReservationTime("25", test2.get(i).getStartTime()));
		}
		for (int i = 0; i < users.size(); i++)
		{
			if (users.get(i).getId() == 902000000)
			{
				users.get(i).setIsFaculty(true);
			}
		}
		Room test = new Room(test2, users);
			
		
		String errorMessage = null;
		try 
		{
			
			//Date date = new Date();
			//c.setTime(date);
			
			System.out.println("checking which reservation was taken");
			if(req.getParameter("time").equals("8:30am"))
			{
				Object user = req.getSession().getAttribute("user");
				User user2 = (User)user;
				//System.out.println(user2.getId());
				if (user2.getId() == 902000000)
				{
					user2.setIsFaculty(true);
				}
				
				Reservation reservation = new Reservation(today, "8:30am", user2.getDbId(), 25);
				userWithReservation = null;
				userWithReservation = db.getUserFromReservationTime("25", "8:30am");
				//System.out.println("current user is faculty: " + user2.getIsFaculty());
				//System.out.println(userWithReservation.getIsFaculty());
				if(user2.getIsFaculty() && userWithReservation != null)
				{
					if (userWithReservation.getId() == 902000000)
					{
						userWithReservation.setIsFaculty(true);
					}
					if (userWithReservation.getIsFaculty() == false)
					{
						db.removeReservation("25", "8:30am");
						db.insertReservation(reservation.getDate(), reservation.getStartTime(), 25, user2.getDbId());
						System.out.println("Reservation overwritten");
					}
					else
					{
						System.out.println("Reservation is for another faculty member");
					}
				}
				else if (userWithReservation == null)
				{
					db.insertReservation(reservation.getDate(), reservation.getStartTime(), 25, user2.getDbId());
					System.out.println("Reservation created");
				}
				else
				{
					System.out.println("Reservation can't be overwritten");
				}
				
				
			}
			else if (req.getParameter("time").equals("9:00am"))
			{
				Object user = req.getSession().getAttribute("user");
				User user2 = (User)user;
				//System.out.println(user2.getId());
				if (user2.getId() == 902000000)
				{
					user2.setIsFaculty(true);
				}
				
				Reservation reservation = new Reservation(today, "9:00am", user2.getDbId(), 25);
				userWithReservation = null;
				userWithReservation = db.getUserFromReservationTime("25", "9:00am");
				//System.out.println("current user is faculty: " + user2.getIsFaculty());
				//System.out.println(userWithReservation.getIsFaculty());
				if(user2.getIsFaculty() && userWithReservation != null)
				{
					if (userWithReservation.getId() == 902000000)
					{
						userWithReservation.setIsFaculty(true);
					}
					if (userWithReservation.getIsFaculty() == false)
					{
						db.removeReservation("25", "9:00am");
						db.insertReservation(reservation.getDate(), reservation.getStartTime(), 25, user2.getDbId());
						System.out.println("Reservation overwritten");
					}
					else
					{
						System.out.println("Reservation is for another faculty member");
					}
				}
				else if (userWithReservation == null)
				{
					db.insertReservation(reservation.getDate(), reservation.getStartTime(), 25, user2.getDbId());
					System.out.println("Reservation created");
				}
				else
				{
					System.out.println("Reservation can't be overwritten");
				}
				
			}
			else if (req.getParameter("time").equals("9:30am"))
			{
				Object user = req.getSession().getAttribute("user");
				User user2 = (User)user;
				//System.out.println(user2.getId());
				if (user2.getId() == 902000000)
				{
					user2.setIsFaculty(true);
				}
				
				Reservation reservation = new Reservation(today, "9:30am", user2.getDbId(), 25);
				userWithReservation = null;
				userWithReservation = db.getUserFromReservationTime("25", "9:30am");
				
				if(user2.getIsFaculty() && userWithReservation != null)
				{
					if (userWithReservation.getId() == 902000000)
					{
						userWithReservation.setIsFaculty(true);
					}
					if (userWithReservation.getIsFaculty() == false)
					{
						db.removeReservation("25", "9:30am");
						db.insertReservation(reservation.getDate(), reservation.getStartTime(), 25, user2.getDbId());
						System.out.println("Reservation overwritten");
					}
					else
					{
						System.out.println("Reservation is for another faculty member");
					}
				}
				else if (userWithReservation == null)
				{
					db.insertReservation(reservation.getDate(), reservation.getStartTime(), 25, user2.getDbId());
					System.out.println("Reservation created");
				}
				else
				{
					System.out.println("Reservation can't be overwritten");
				}
				
			}
			else if (req.getParameter("time").equals("10:00am"))
			{
				Object user = req.getSession().getAttribute("user");
				User user2 = (User)user;
				//System.out.println(user2.getId());
				if (user2.getId() == 902000000)
				{
					user2.setIsFaculty(true);
				}
				
				Reservation reservation = new Reservation(today, "10:00am", user2.getDbId(), 25);
				userWithReservation = null;
				userWithReservation = db.getUserFromReservationTime("25", "10:00am");
				//System.out.println("current user is faculty: " + user2.getIsFaculty());
				//System.out.println(userWithReservation.getIsFaculty());
				if(user2.getIsFaculty() && userWithReservation != null)
				{
					if (userWithReservation.getId() == 902000000)
					{
						userWithReservation.setIsFaculty(true);
					}
					if (userWithReservation.getIsFaculty() == false)
					{
						db.removeReservation("25", "10:00am");
						db.insertReservation(reservation.getDate(), reservation.getStartTime(), 25, user2.getDbId());
						System.out.println("Reservation overwritten");
					}
					else
					{
						System.out.println("Reservation is for another faculty member");
					}
				}
				else if (userWithReservation == null)
				{
					db.insertReservation(reservation.getDate(), reservation.getStartTime(), 25, user2.getDbId());
					System.out.println("Reservation created");
				}
				else
				{
					System.out.println("Reservation can't be overwritten");
				}
				
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
		reservations = db.getReservationsForRoom("25", today);
		for (Reservation r : reservations)
		{
			date = r.getDate();
		}
		
		return date;
	}
}