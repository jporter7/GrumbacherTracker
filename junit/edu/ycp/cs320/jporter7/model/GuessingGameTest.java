package edu.ycp.cs320.jporter7.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.jporter7.model.GuessingGame;

public class GuessingGameTest {
	private GuessingGame model;
	
	@Before
	public void setUp() {
		model = new GuessingGame();
	}
	
	@Test
	public void testSetMin() {
		model.setMin(1);
		assertEquals(1, model.getMin());
	}
	
	@Test
	public void testSetMax() {
		model.setMax(100);
		assertEquals(100, model.getMax());
	}
	
	@Test
	public void testSetIsGreaterThan() 
	{
		model.setIsGreaterThan(50);
		assertEquals(51, model.getMin());
	}
	
	@Test
	public void testSetIsLessThan() 
	{
		model.setIsLessThan(50);
		assertEquals(49, model.getMax());
	}
	
	@Test
	public void testIsDone()
	{
		model.isDone();
		assertEquals(model.getMax(), model.getMin());
	}
}
