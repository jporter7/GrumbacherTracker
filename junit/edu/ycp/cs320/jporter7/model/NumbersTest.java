package edu.ycp.cs320.jporter7.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NumbersTest 
{
	private Numbers model;
	
	@Before
	public void setUp() 
	{
		model = new Numbers();
	}
	
	
	@Test
	public void testSetFirst() 
	{
		model.setFirst(10.0);
		assertTrue(10.0 == model.getFirst());
	}
	
	@Test
	public void testSetSecond() 
	{
		model.setSecond(5.4);
		assertTrue(5.4 == model.getSecond());
	}
	
	@Test
	public void testSetThird() 
	{
		model.setThird(5123.8);
		assertTrue(5123.8 == model.getThird());
	}
	
	

}
