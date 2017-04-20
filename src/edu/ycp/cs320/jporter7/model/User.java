package edu.ycp.cs320.jporter7.model;

public class User 
{
	private String password, userName, email, firstName, lastName;
	private int id, dbId, room;
	private boolean isFaculty;
	
	public User()
	{

	}
	
	/////////////////////////////////////////////////
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public void setfirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setlastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setIsFaculty(boolean isFaculty)
	{
		this.isFaculty = isFaculty;
	}
	
	public void setDbId(int dbId)
	{
		this.dbId = dbId;
	}
	public void setRoom(int room)
	{
		this.room = room;
	}
	
	////////////////////////////////////////////////
	
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
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getFullName()
	{
		return firstName + " " + lastName;
	}
	
	public int getId()
	{
		return id;
	}
	
	public boolean getIsFaculty()
	{
		return isFaculty;
	}
	
	public int getDbId()
	{
		return dbId;
	}
	
	public int getRoom()
	{
		return room;
	}
	
}
