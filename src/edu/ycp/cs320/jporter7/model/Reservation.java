package edu.ycp.cs320.jporter7.model;

public class Reservation 
{
	private String date, startTime, endTime;
	private User user;
	
	public Reservation(String date, String startTime, String endTime, User user)
	{
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.user = user;
	}
	
	public void setDate(String date)
	{
		this.date = date;
	}
	
	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}
	
	public void setUser(User user)
	{
		this.user = user;
	}
	
	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}
	
	public String getDate()
	{
		return date;
	}
	
	public String getStartTime()
	{
		return startTime;
	}
	
	public String getEndTime()
	{
		return endTime;
	}
	
	public User getUser()
	{
		return user;
	}
}
