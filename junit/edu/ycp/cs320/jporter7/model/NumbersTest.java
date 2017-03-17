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
	
	public void testSetSecond() 
	{
		model.setSecond(5.4);
		assertTrue(5.4 == model.getSecond());
	}
	
	public void testSetThird() 
	{
		model.setThird(5123.8);
		assertTrue(5123.8 == model.getThird());
	}
	
	/*public void testGetAddResult()
	{
		Double result = model.getAddResult(10.0, 5.0, 20.0);
		assertTrue(35.0 == result);
	}
	
	public void testGetMultiplyResult()
	{
		Double result = model.getMultiplyResult(10.0, 5.0);
		assertTrue(50.0 == result);
	}*/
	

}
