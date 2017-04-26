package edu.ycp.cs320.jporter7.model;

import java.util.ArrayList;

public class Room 
{
	private ArrayList<Reservation> reservations;
	private ArrayList<User> users;
	
	public Room(ArrayList<Reservation> reservations, ArrayList<User> users)
	{
		this.reservations = reservations;
		this.users = users;
	}
	
	public ArrayList<Reservation> getReservations()
	{
		return reservations;
	}
	
	public ArrayList<User> getUsersWithReservations()
	{
		return users;
	}
	
}
