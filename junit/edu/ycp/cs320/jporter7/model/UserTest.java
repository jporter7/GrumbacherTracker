package edu.ycp.cs320.jporter7.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest 
{
	private User studentUser, facultyUser;
	
	@Before
	public void setUp()
	{
		studentUser = new User("YCPnet2005", "jporter7", "jporter7@ycp.edu", "Jason", "Porter" );
		//facultyUser = new User();
	}
	
	@Test
	public void testisFaculty() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetPassword() 
	{
		//fail("Not yet implemented");
		assertEquals("YCPnet2005", studentUser.getPassword());
	}
	
	@Test
	public void testGetUserName() 
	{
		//fail("Not yet implemented");
		assertEquals("jporter7", studentUser.getUserName());
	}
	
	@Test
	public void testGetFullName() 
	{
		//fail("Not yet implemented");
		assertEquals("Jason Porter", studentUser.getFullName());
	}
	
	@Test
	public void testGetEmail() 
	{
		//fail("Not yet implemented");
		assertEquals("jporter7@ycp.edu", studentUser.getEmail());
	}
	
	@Test
	public void testDeleteUser() 
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void testCreateUser() 
	{
		fail("Not yet implemented");
	}
	
}
