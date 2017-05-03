package edu.ycp.cs320.jporter7.model;

public class Reservation 
{
	private String date, startTime, endTime;
	private int userId, reservationId, roomNumber;
	
	public Reservation()
	{
		
	}
	
	public Reservation(String date, String startTime, int userId, int roomNumber)
	{
		this.reservationId = reservationId;
		this.date = date;
		this.startTime = startTime;
		//this.endTime = endTime;
		this.userId = userId;
		this.roomNumber = roomNumber;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}
	
	public void setUserId(int userId)
	{
		this.userId = userId;
	}
	
	public void setReservationId(int reservationId)
	{
		this.reservationId = reservationId;
	}
	
	public void setRoomNumber(int roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getStartTime()
	{
		return startTime;
	}
	
	public int getReservationId()
	{
		return reservationId;
	}
	
	public int getUserId()
	{
		return userId;
	}
	
	public int getRoomNumber()
	{
		return roomNumber;
	}
}
