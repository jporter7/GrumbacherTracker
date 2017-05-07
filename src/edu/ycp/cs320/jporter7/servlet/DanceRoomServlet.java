package edu.ycp.cs320.jporter7.servlet;
/*
 * All servlets for rooms with reservations are fairly identical, except 
 * that the room number for creating and checking reservations is different.
 * This servlet has the comments for the pieces of logic that goes along with making a reservation.
 */

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


public class DanceRoomServlet extends HttpServlet {
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
		//initialize the servlet and get the reservations for this room and day
		this.init(req);
		ArrayList<Reservation> test2 = new ArrayList<Reservation>();
		ArrayList<User> users = new ArrayList<User>();
		test2 = db.getReservationsForRoom("1", today);
		
		//add the users from the reservations that are currently made in for this room
		//and set whether or not they are faculty members 
		for (int i = 0; i < test2.size(); i++)
		{
			users.add(db.getUserFromReservationTime("1", test2.get(i).getStartTime()));
		}
		for (int i = 0; i < users.size(); i++)
		{
			if (users.get(i).getId() == 902000000)
			{
				users.get(i).setIsFaculty(true);
			}
		}
		//create room object
		Room test = new Room(test2, users);
		
		//check whether a user is logged in or not and redirect them accordingly
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
			req.getRequestDispatcher("/_view/danceRoom.jsp").forward(req, resp);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		
		//Get all of the reservations for this room
		ArrayList<Reservation> test2 = new ArrayList<Reservation>();
		test2 = db.getReservationsForRoom("1", today);
		ArrayList<User> users = new ArrayList<User>();
		
		//set whether the users with reservations in this room are faculty or not
		for (int i = 0; i < test2.size(); i++)
		{
			users.add(db.getUserFromReservationTime("1", test2.get(i).getStartTime()));
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
			
			//check which reservation was taken and attempt to make a reservation
			//for that time, but first check if the logout button has been clicked
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
		req.getRequestDispatcher("/_view/danceRoom.jsp").forward(req, resp);
	
		}
	}
	
	public void makeReservationForTime(String time)
	{
		User user2 = (User)user;
		ArrayList<Reservation> reservationLimitCheck = new ArrayList<Reservation>();
		reservationLimitCheck = db.getReservationsForUserAndDate(Integer.toString(user2.getDbId()), today);
		System.out.println(reservationLimitCheck.size());
		
		//check if the user is faculty and also if they have less than 2 reservations
		if (user2.getId() == 902000000)
		{
			user2.setIsFaculty(true);
		}
		
		if (reservationLimitCheck.size() < 2)
		{
			Reservation reservation = new Reservation(today, time, user2.getDbId(), 1);
			userWithReservation = null;
			userWithReservation = db.getUserFromReservationTime("1", time);
			
			//check whether the user is faculty and if the user is not and make reservation based on this
			//information
			if(user2.getIsFaculty() && userWithReservation != null)
			{
				if (userWithReservation.getId() == 902000000)
				{
					userWithReservation.setIsFaculty(true);
				}
				if (userWithReservation.getIsFaculty() == false)
				{
					//overwrite the reservation if the user is a faculty member and the 
					//user with the reservation is a student
					db.removeReservation("1", time);
					db.insertReservation(reservation.getDate(), reservation.getStartTime(), 1, user2.getDbId());
					System.out.println("Reservation overwritten");
				}
				else
				{
					System.out.println("Reservation is for another faculty member");
				}
			}
			else if (userWithReservation == null)
			{
				//if there is no user with a reservation, then create one
				db.insertReservation(reservation.getDate(), reservation.getStartTime(), 1, user2.getDbId());
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