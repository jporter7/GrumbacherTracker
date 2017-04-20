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
		int dance = 0, fieldHouse = 0, pool = 0, racquet = 0, rockWall = 0,
				weightRoom = 0, wolfBasketball = 0, wrestlingRoom = 0;
		
		ArrayList<User> activeUsers = new ArrayList<User>();
		activeUsers = db.getActiveUsers();
		for (int i = 0; i < activeUsers.size(); i++)
		{
			System.out.println(activeUsers.get(i).getRoom());
			
			if (activeUsers.get(i).getRoom() == 1)
			{
				dance++;
			}
			else if (activeUsers.get(i).getRoom() == 2)
			{
				fieldHouse++;
			}
			else if (activeUsers.get(i).getRoom() == 3)
			{
				pool++;
			}
			else if (activeUsers.get(i).getRoom() == 4)
			{
				racquet++;
			}
			else if (activeUsers.get(i).getRoom() == 5)
			{
				rockWall++;
			}
			else if (activeUsers.get(i).getRoom() == 6)
			{
				weightRoom++;
			}
			else if (activeUsers.get(i).getRoom() == 7)
			{
				wolfBasketball++;
			}
			else if (activeUsers.get(i).getRoom() == 8)
			{
				wrestlingRoom++;
			}
			
		}
		
		model.setPopTotal(activeUsers.size());
		model.setDanceRoom(dance);
		model.setFieldHouse(fieldHouse);
		model.setPool(pool);
		model.setRacquet(racquet);
		model.setRockWall(rockWall);
		model.setWeightRoom(weightRoom);
		model.setWolfBasketball(wolfBasketball);
		model.setWrestlingRoom(weightRoom);
	}
	

}
