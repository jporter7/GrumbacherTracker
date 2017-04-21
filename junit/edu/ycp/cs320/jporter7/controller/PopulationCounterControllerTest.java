package edu.ycp.cs320.jporter7.controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;

import edu.ycp.cs320.jporter7.model.*;
import edu.ycp.cs320.jporter7.populationdb.persist.*;
import edu.ycp.cs320.jporter7.controller.*;

public class PopulationCounterControllerTest 
{
	private PopulationCounter model;
	private PopulationCounterController controller;
	private IDatabase db;
	private ArrayList<User> totalUsers, activeUsers;
	
	@Before
	public void setUp()
	{
		db = new DerbyDatabase();
		model = new PopulationCounter();
		controller = new PopulationCounterController(model, db);
		controller.setModel();
		
		totalUsers = db.getAllUsers();
		activeUsers = db.getActiveUsers();
		
	}
	
	
	
	@Test
	public void testGetActiveUsers() 
	{
		assertEquals(activeUsers.size(), model.getPopTotal());
	}
	
	@Test
	public void testGetRoomUsages()
	{
		assertEquals(5, model.getWeightRoom());
		assertEquals(3, model.getRacquet());
		assertEquals(1, model.getPool());
		assertEquals(0, model.getFieldHouse());
		assertEquals(1, model.getPool());
		assertEquals(0, model.getRockWall());
		assertEquals(0, model.getWolfBasketball());
		assertEquals(1, model.getDanceRoom());
	}

}
