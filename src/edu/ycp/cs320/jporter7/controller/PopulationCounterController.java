package edu.ycp.cs320.jporter7.controller;

import java.util.ArrayList;

import edu.ycp.cs320.jporter7.model.PopulationCounter;
import edu.ycp.cs320.jporter7.model.User;
import edu.ycp.cs320.jporter7.populationdb.persist.IDatabase;

public class PopulationCounterController 
{
	private PopulationCounter model;
	private IDatabase db;
	
	public PopulationCounterController(PopulationCounter model, IDatabase db)
	{
		this.model = model;
		this.db = db;
		/*model.setDanceRoom(0);
		model.setFieldHouse(0);
		model.setPool(0);
		model.setPopTotal(0);
		model.setRacquet(0);
		model.setRockWall(0);
		model.setWeightRoom(0);
		model.setWolfBasketball(0);
		model.setWrestlingRoom(0);*/
	}
	
	public void setModel()
	{
		ArrayList<User> activeUsers = new ArrayList<User>();
		activeUsers = db.getActiveUsers();
		model.setDanceRoom(activeUsers.size());
		model.setFieldHouse(0);
		model.setPool(0);
		model.setPopTotal(activeUsers.size());
		model.setRacquet(activeUsers.size());
		model.setRockWall(0);
		model.setWeightRoom(activeUsers.size());
		model.setWolfBasketball(0);
		model.setWrestlingRoom(activeUsers.size());
	}
	

}
