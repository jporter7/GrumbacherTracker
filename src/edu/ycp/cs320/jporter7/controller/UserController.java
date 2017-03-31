package edu.ycp.cs320.jporter7.controller;

import edu.ycp.cs320.jporter7.model.User;

public class UserController 
{
	private User user;
	
	public UserController(User user)
	{
		this.user = user;
	}
	
	public User createUser(String password, String userName, String email, String firstName, String lastName, int id)
	{
		//Check if password should be set
		if (password.length() > 5)
		{
			user.setPassword(password);
		}
		
		//Check if username should be set
		if (true)
		{
			user.setUserName(userName);
		}
		
		//Check if email should be set
		if (email.contains("@ycp.edu"))
		{
			user.setEmail(email);
		}
		
		//first name & last name
		user.setfirstName(firstName);
		user.setlastName(lastName);
		
		//Check if id is valid
		if (id == 902000000)
		{
			user.setId(id);
			user.setIsFaculty(true);
		}
		else if (id > 902000000 && id < 904000000)
		{
			user.setId(id);
			user.setIsFaculty(false);
		}
		
		
		return user;
	}
	
	
}
