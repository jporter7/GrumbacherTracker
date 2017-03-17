package edu.ycp.cs320.jporter7.controller;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.jporter7.model.Numbers;

public class NumbersControllerTest 
{
	private Numbers model;
	private NumbersController controller;
	
	@Before
	public void setUp() 
	{
		model = new Numbers();
		controller = new NumbersController(model);
		
	}
	
	
	@Test
	public void testAdd() 
	{
		model.setFirst(10.9);
		model.setSecond(20.2);
		model.setThird(15.5);
		
		//Double first = model.getFirst();
		//Double second = model.getSecond();
		//Double third = model.getThird();
		
		controller.add();
		
		assertTrue(model.getAddResult() == 46.6);
		
	}
	
	public void testMultiply() 
	{
		model.setFirst(10.0);
		model.setSecond(20.2);
		
		//Double first = model.getFirst();
		//Double second = model.getSecond();
		
		controller.multiply();
		
		assertTrue(model.getMultiplyResult() == 202.0);
		
	}

}
