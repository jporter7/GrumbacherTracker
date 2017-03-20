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
	public void testGetDanceRoom() 
	{
		model.setDanceRoom(4);
		assertEquals(4, model.getDanceRoom());
	}
	
	@Test
	public void testGetPopTotal() 
	{
		model.setPopTotal(100);
		assertEquals(100, model.getPopTotal());
	}
	
	@Test
	public void testGetPool() 
	{
		model.setPool(0);
		assertEquals(0, model.getPool());
	}
	
	@Test
	public void testGetRacquet() 
	{
		model.setRacquet(4);
		assertEquals(4, model.getRacquet());
	}
	
	@Test
	public void testGetWolfBasketball() 
	{
		model.setWolfBasketball(50);
		assertEquals(50, model.getWolfBasketball());
	}
	
	@Test
	public void testGetWeightRoom() 
	{
		model.setWeightRoom(20);
		assertEquals(20, model.getWeightRoom());
	}
	
	@Test
	public void testGetFieldHouse() 
	{
		model.setFieldHouse(2);
		assertEquals(2, model.getFieldHouse());
	}
	
	@Test
	public void testGetRockWall() 
	{
		model.setRockWall(7);
		assertEquals(7, model.getRockWall());
	}
	
	@Test
	public void testGetWrestlingRoom() 
	{
		model.setWrestlingRoom(13);
		assertEquals(13, model.getWrestlingRoom());
	}
}
