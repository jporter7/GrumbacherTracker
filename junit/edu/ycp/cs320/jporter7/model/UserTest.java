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
		studentUser = new User();
		facultyUser = new User();
		
		//set student user attributes
		studentUser.setEmail("jporter7@ycp.edu");
		studentUser.setPassword("YCPnet2005");
		studentUser.setUserName("jporter7");
		studentUser.setfirstName("Jason");
		studentUser.setlastName("Porter");
		studentUser.setId(903156845);
		studentUser.setIsFaculty(false);
		
		//set faculty user attributes
		facultyUser.setEmail("jsmith@ycp.edu");
		facultyUser.setPassword("YCP&&2005");
		facultyUser.setUserName("jsmith");
		facultyUser.setfirstName("John");
		facultyUser.setlastName("Smith");
		facultyUser.setId(902000000);
		facultyUser.setIsFaculty(true);
		
	}
	
	@Test
	public void testisFaculty() 
	{
		//fail("Not yet implemented");
		assertFalse(studentUser.getIsFaculty());
		assertTrue(facultyUser.getIsFaculty());
	}
	
	@Test
	public void testGetPassword() 
	{
		//fail("Not yet implemented");
		assertEquals("YCPnet2005", studentUser.getPassword());
		assertEquals("YCP&&2005", facultyUser.getPassword());
	}
	
	@Test
	public void testGetUserName() 
	{
		//fail("Not yet implemented");
		assertEquals("jporter7", studentUser.getUserName());
		assertEquals("jsmith", facultyUser.getUserName());
	}
	
	@Test
	public void testGetFullName() 
	{
		//fail("Not yet implemented");
		assertEquals("Jason Porter", studentUser.getFullName());
		assertEquals("John Smith", facultyUser.getFullName());
	}
	
	@Test
	public void testGetEmail() 
	{
		//fail("Not yet implemented");
		assertEquals("jporter7@ycp.edu", studentUser.getEmail());
		assertEquals("jsmith@ycp.edu", facultyUser.getEmail());
	}
	
	@Test
	public void testGetId() 
	{
		//fail("Not yet implemented");
		assertEquals(903156845, studentUser.getId());
		assertEquals(902000000, facultyUser.getId());
	}
	
}
