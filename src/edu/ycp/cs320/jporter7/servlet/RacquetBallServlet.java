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


public class RacquetBallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IDatabase db;
	private Calendar date;
	private String today;
	private User userWithReservation = null;
	private Object user;
	
	//@Override
    public void init(HttpServletRequest req) throws ServletException
    {
        this.db = (IDatabase)getServletContext().getAttribute("database");
        this.date = Calendar.getInstance();
        this.today = Integer.toString(date.get(Calendar.MONTH) + 1) + "/" + Integer.toString(date.get(Calendar.DAY_OF_MONTH)) 
		+ "/" + Integer.toString(date.get(Calendar.YEAR));
        user = req.getSession().getAttribute("user");
    }
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		this.init(req);
		ArrayList<Reservation> test2 = new ArrayList<Reservation>();
		ArrayList<User> users = new ArrayList<User>();
		//users = db.getUserFromReservationTime(room, time);
		test2 = db.getReservationsForRoom("4", today);
		for (int i = 0; i < test2.size(); i++)
		{
			users.add(db.getUserFromReservationTime("4", test2.get(i).getStartTime()));
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
			req.getRequestDispatcher("/_view/racquetBall.jsp").forward(req, resp);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		// Decode form parameters and dispatch to controller
		ArrayList<Reservation> test2 = new ArrayList<Reservation>();
		System.out.println(today);
		test2 = db.getReservationsForRoom("4", today);
		ArrayList<User> users = new ArrayList<User>();
		
		for (int i = 0; i < test2.size(); i++)
		{
			users.add(db.getUserFromReservationTime("4", test2.get(i).getStartTime()));
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
			if (req.getParameter("logout") != null)
			{
				req.getSession().invalidate();
				resp.sendRedirect(req.getContextPath() + "/login");
			}
			else if(req.getParameter("time").equals("8:00am"))
			{
				this.makeReservationForTime("8:00am");
			}
			else if(req.getParameter("time").equals("8:30am"))
			{
				this.makeReservationForTime("8:30am");
			}
			else if (req.getParameter("time").equals("9:00am"))
			{
				this.makeReservationForTime("9:00am");
			}
			else if (req.getParameter("time").equals("9:30am"))
			{
				this.makeReservationForTime("9:30am");
			}
			else if (req.getParameter("time").equals("10:00am"))
			{
				this.makeReservationForTime("10:00am");
			}
			else if (req.getParameter("time").equals("10:30am"))
			{
				this.makeReservationForTime("10:30am");
			}
			else if (req.getParameter("time").equals("11:00am"))
			{
				this.makeReservationForTime("11:00am");
			}
			else if (req.getParameter("time").equals("11:30am"))
			{
				this.makeReservationForTime("11:30am");
			}
			else if (req.getParameter("time").equals("12:00pm"))
			{
				this.makeReservationForTime("12:00pm");
			}
			else if (req.getParameter("time").equals("12:30pm"))
			{
				this.makeReservationForTime("12:30pm");
			}
			else if (req.getParameter("time").equals("1:00pm"))
			{
				this.makeReservationForTime("1:00pm");
			}
			else if (req.getParameter("time").equals("1:30pm"))
			{
				this.makeReservationForTime("1:30pm");
			}
			else if (req.getParameter("time").equals("2:00pm"))
			{
				this.makeReservationForTime("2:00pm");
			}
			else if (req.getParameter("time").equals("2:30pm"))
			{
				this.makeReservationForTime("2:30pm");
			}
			else if (req.getParameter("time").equals("3:00pm"))
			{
				this.makeReservationForTime("3:00pm");
			}
			else if (req.getParameter("time").equals("3:30pm"))
			{
				this.makeReservationForTime("3:30pm");
			}
			else if (req.getParameter("time").equals("4:00pm"))
			{
				this.makeReservationForTime("4:00pm");
			}
			else if (req.getParameter("time").equals("4:30pm"))
			{
				this.makeReservationForTime("4:30pm");
			}
			else if (req.getParameter("time").equals("5:00pm"))
			{
				this.makeReservationForTime("5:00pm");
			}
			else if (req.getParameter("time").equals("5:30pm"))
			{
				this.makeReservationForTime("5:30pm");
			}
			else if (req.getParameter("time").equals("6:00pm"))
			{
				this.makeReservationForTime("6:00pm");
			}
			else if (req.getParameter("time").equals("6:30pm"))
			{
				this.makeReservationForTime("6:30pm");
			}
			else if (req.getParameter("time").equals("7:00pm"))
			{
				this.makeReservationForTime("7:00pm");
			}
			else if (req.getParameter("time").equals("7:30pm"))
			{
				this.makeReservationForTime("7:30pm");
			}
			else if (req.getParameter("time").equals("8:00pm"))
			{
				this.makeReservationForTime("8:00pm");
			}
			else if (req.getParameter("time").equals("8:30pm"))
			{
				this.makeReservationForTime("8:30pm");
			}
			else if (req.getParameter("time").equals("9:00pm"))
			{
				this.makeReservationForTime("9:00pm");
			}
			else if (req.getParameter("time").equals("9:30pm"))
			{
				this.makeReservationForTime("9:30pm");
			}
		} 
		catch (NumberFormatException e) 
		{
			errorMessage = "Invalid double";
		}
		
		// Forward to view to render the result HTML document
		req.setAttribute("test", test);
		if (req.getParameter("logout") == null)
		{
			req.getRequestDispatcher("/_view/racquetBall.jsp").forward(req, resp);
		}
	}

	
	public void makeReservationForTime(String time)
	{
		User user2 = (User)user;
		ArrayList<Reservation> reservationLimitCheck = new ArrayList<Reservation>();
		reservationLimitCheck = db.getReservationsForUser(Integer.toString(user2.getDbId()));
		System.out.println(reservationLimitCheck.size());
		
		if (user2.getId() == 902000000)
		{
			user2.setIsFaculty(true);
		}
		
		if (reservationLimitCheck.size() < 2)
		{
			Reservation reservation = new Reservation(today, time, user2.getDbId(), 4);
			userWithReservation = null;
			userWithReservation = db.getUserFromReservationTime("4", time);
			
			if(user2.getIsFaculty() && userWithReservation != null)
			{
				if (userWithReservation.getId() == 902000000)
				{
					userWithReservation.setIsFaculty(true);
				}
				if (userWithReservation.getIsFaculty() == false)
				{
					db.removeReservation("4", time);
					db.insertReservation(reservation.getDate(), reservation.getStartTime(), 4, user2.getDbId());
					System.out.println("Reservation overwritten");
				}
				else
				{
					System.out.println("Reservation is for another faculty member");
				}
			}
			else if (userWithReservation == null)
			{
				db.insertReservation(reservation.getDate(), reservation.getStartTime(), 4, user2.getDbId());
				System.out.println("Reservation created");
			}
			else
			{
				System.out.println("Reservation can't be overwritten");
			}
		}
		else
		{
			System.out.println("User has too many reservations");
		}
	}
	
	
}