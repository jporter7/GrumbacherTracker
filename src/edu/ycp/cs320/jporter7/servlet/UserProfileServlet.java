package edu.ycp.cs320.jporter7.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.jporter7.*;
import edu.ycp.cs320.jporter7.controller.PopulationCounterController;
import edu.ycp.cs320.jporter7.model.PopulationCounter;
import edu.ycp.cs320.jporter7.model.Reservation;
import edu.ycp.cs320.jporter7.model.User;
import edu.ycp.cs320.jporter7.populationdb.persist.IDatabase;
import edu.ycp.cs320.jporter7.simulator.SwipeSimulator;

public class UserProfileServlet extends HttpServlet
{
private static final long serialVersionUID = 1L;
	
	private IDatabase db;
	private int counter;
	private Calendar date;
	private String today;
	
    @Override
    public void init() throws ServletException
    {
    	//get the instance of the database and set the current day
        this.db = (IDatabase)getServletContext().getAttribute("database");
        this.counter = 22;
        this.date = Calendar.getInstance();
        this.today = Integer.toString(date.get(Calendar.MONTH) + 1) + "/" + Integer.toString(date.get(Calendar.DAY_OF_MONTH)) 
		+ "/" + Integer.toString(date.get(Calendar.YEAR));
    }
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{	
		//check if user is logged in
		Object username = req.getSession().getAttribute("username");
		Object password = req.getSession().getAttribute("password");
		Object user = req.getSession().getAttribute("user");
		User user2 = null;
		
		if (username == null || username.equals("") || password == null || password.equals(""))
		{
			System.out.println("Need to login");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else
		{
			//check the entire users page and set the current user equal to the user from the database
			//that matches the criteria of the session information
			ArrayList<User> users = db.getAllUsers();
			ArrayList<Reservation> reservations;
			for (User check : users)
			{
				if (check.getUserName().equals(username) && check.getPassword().equals(password))
				{
					user2 = check;
				}
			}
			
			//get the reservations for the user and current day to be displayed on the webpage
			reservations = db.getReservationsForUserAndDate(Integer.toString(user2.getDbId()), today);
			for (int i = 0; i < reservations.size(); i++)
			{
				Reservation res = reservations.get(i);
				
				//check which rooms the user has reservations for and send information to the jsp to be
				//displayed
				if (res.getRoomNumber() == 1)
				{
					req.setAttribute("name" + i, "Dance Room");
				}
				else if (res.getRoomNumber() == 3)
				{
					req.setAttribute("name" + i, "Pool");
				}
				else if (res.getRoomNumber() == 4)
				{
					req.setAttribute("name" + i, "Racquet Ball");
				}
				else if (res.getRoomNumber() == 5)
				{
					req.setAttribute("name" + i, "Rock Wall");
				}
				else if (res.getRoomNumber() == 6)
				{
					req.setAttribute("name" + i, "Weight Room");
				}
				else if (res.getRoomNumber() == 8)
				{
					req.setAttribute("name" + i, "Wrestling Room");
				}
			}
			
			req.setAttribute("reservations", reservations);
			req.setAttribute("user", user2);
			
			req.getRequestDispatcher("/_view/userProfile.jsp").forward(req, resp);
		}
	}
    
    
    
}
