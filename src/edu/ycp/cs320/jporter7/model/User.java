package edu.ycp.cs320.jporter7.model;

public class User 
{
	private String password, userName, email, firstName, lastName;
	
	public User(String password, String userName, String email, String firstName, String lastName)
	{
		this.password = password;
		this.userName = userName;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public String getfirstName()
	{
		return firstName;
	}
	
	public String getlastName()
	{
		return lastName;
	}
	
	public String getFullName()
	{
		return firstName + " " + lastName;
	}
	
	public boolean isFaculty()
	{
		return false;
	}
	
	
}
