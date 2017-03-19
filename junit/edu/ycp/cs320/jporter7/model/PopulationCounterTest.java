package edu.ycp.cs320.jporter7.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PopulationCounterTest 
{
	private PopulationCounter model;
	
	@Before
	public void setUp()
	{
		model = new PopulationCounter();
	}
	
	@Test
	public void testgetDanceRoom() 
	{
		model.setDanceRoom(20);
		assertEquals(20, model.getDanceRoom());
	}

}
