package edu.ycp.cs320.jporter7.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.ycp.cs320.jporter7.controller.PopulationCounterController;
import edu.ycp.cs320.jporter7.model.PopulationCounter;
import edu.ycp.cs320.jporter7.model.User;
import edu.ycp.cs320.jporter7.populationdb.persist.IDatabase;
import edu.ycp.cs320.jporter7.simulator.SwipeSimulator;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class IndexServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	
	private IDatabase db;
	private User newSwipeUser = new User();
	private SwipeSimulator swipeSim = new SwipeSimulator(newSwipeUser, db);
	private int counter;
	private SwipeSimulator sim;
	private int swipeloop = 0;
	private int swipeEnable = 0;

    @Override
    public void init() throws ServletException
    {
    	//get the instance of the database and set the counter used to simulate
    	//swiping in and out of the faciities to 22 based on the csv files
        this.db = (IDatabase)getServletContext().getAttribute("database");
        this.counter = 22;
    }
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException 
	{
		//create a model for the population and a controller, then
		//set that model based on the database 
		PopulationCounter model = new PopulationCounter();
		PopulationCounterController popController = new PopulationCounterController(model, db);
		popController.setModel();
		req.setAttribute("model", model);
		
		//Check if the user is logged in or not
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
			req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		}
		
		// begin swipe stuff
		if (swipeEnable==0){
			swipeEnable = 1;
			while (swipeloop < 399){
				swipeSim.swipe(newSwipeUser, db, counter++);
				swipeloop++;
				//resp.addHeader("Refresh", "5");
				try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							//e.printStackTrace();
					}
			}
		}

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException
	{
		//Login check, get username and password for session and check if 
		//they are present in the database
		Object username = req.getSession().getAttribute("username");
		Object password = req.getSession().getAttribute("password");
		if (username == null || username.equals("") || password == null || password.equals(""))
		{
			System.out.println("Need to login");
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		
		
		//check which button was pressed and redirect accordingly
		if (req.getParameter("logout") != null)
		{
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		else if (req.getParameter("profile") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/userProfile");
		}
		else if (req.getParameter("TotalPopulation") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/index");
		}
		else if (req.getParameter("WeightRoom") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/weightRoom");
		}
		else if (req.getParameter("FieldHouse") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/index");
		}
		else if (req.getParameter("WolfBasketball") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/index");
		}
		else if (req.getParameter("Pool") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/pool");
		}
		else if (req.getParameter("DanceRoom") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/danceRoom");
		}
		else if (req.getParameter("RacquetBall") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/racquetBall");
		}
		else if (req.getParameter("RockWall") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/rockWall");
		}
		else if (req.getParameter("Test Button") != null)
		{
			resp.sendRedirect(req.getContextPath() + "/index");
		}
		else
		{
			throw new ServletException("Unknown Command");
		}
		
		//req.setAttribute("simulate", sim);
	}
	
}
