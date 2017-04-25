package edu.ycp.cs320.jporter7.model;

import java.util.ArrayList;

public class Room 
{
	private ArrayList<Reservation> reservations;
	
	public Room(ArrayList<Reservation> reservations)
	{
		this.reservations = reservations;
	}
	
	public ArrayList<Reservation> getReservations()
	{
		return reservations;
	}
}
