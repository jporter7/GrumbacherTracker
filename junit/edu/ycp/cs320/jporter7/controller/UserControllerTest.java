package edu.ycp.cs320.jporter7.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.jporter7.model.User;

public class UserControllerTest 
{
	private User user;
	private UserController controller;
	
	@Before
	public void setUp()
	{
		user = new User();
		controller = new UserController(user);
	}
	
	
	@Test
	public void testCreateUser() 
	{
		controller.createUser("admin1234", "jsmith", "jsmith@ycp.edu", "John", "Smith", 903182437);
		
		assertEquals("admin1234", user.getPassword());
		assertEquals("jsmith", user.getUserName());
		assertEquals("jsmith@ycp.edu", user.getEmail());
		assertEquals("John", user.getFirstName());
		assertEquals("Smith", user.getLastName());
		assertEquals("John Smith", user.getFullName());
		assertEquals(903182437, user.getId());
		
	}
	
	@Test
	public void testBadPassword() 
	{
		controller.createUser("admin", "jsmith", "jsmith@ycp.edu", "John", "Smith", 903182437);
		
		assertEquals(null, user.getPassword());
		assertEquals("jsmith", user.getUserName());
		assertEquals("jsmith@ycp.edu", user.getEmail());
		assertEquals("John", user.getFirstName());
		assertEquals("Smith", user.getLastName());
		assertEquals("John Smith", user.getFullName());
		assertEquals(903182437, user.getId());
		
	}
	
	@Test
	public void testBadEmail() 
	{
		controller.createUser("admin123", "jsmith", "jsmith@gmail.edu", "John", "Smith", 903182437);
		
		assertEquals("admin123", user.getPassword());
		assertEquals("jsmith", user.getUserName());
		assertEquals(null, user.getEmail());
		assertEquals("John", user.getFirstName());
		assertEquals("Smith", user.getLastName());
		assertEquals("John Smith", user.getFullName());
		assertEquals(903182437, user.getId());
		
	}
	
	@Test
	public void testBadId() 
	{
		controller.createUser("admin@$", "jsmith", "jsmith@ycp.edu", "John", "Smith", 9032);
		
		assertEquals("admin@$", user.getPassword());
		assertEquals("jsmith", user.getUserName());
		assertEquals("jsmith@ycp.edu", user.getEmail());
		assertEquals("John", user.getFirstName());
		assertEquals("Smith", user.getLastName());
		assertEquals("John Smith", user.getFullName());
		assertEquals(0, user.getId());
		
	}
	

}