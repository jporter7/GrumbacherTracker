package edu.ycp.cs320.jporter7.model;

public class User 
{
	private String password, username, email;
	
	public User(String password, String username, String email)
	{
		this.password = password;
		this.username = username;
		this.email = email;
	}
	
	public boolean isFaculty()
	{
		return false;
	}
	
	
	
	
}
