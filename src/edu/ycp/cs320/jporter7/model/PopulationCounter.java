package edu.ycp.cs320.jporter7.model;


public class PopulationCounter 
{
	private int popTotal, pool, racquet, wolfBasketball, weightRoom, fieldHouse,
	rockWall, danceRoom, wrestlingRoom;
	
	//Constructor
	public PopulationCounter()
	{
		this.popTotal = 0; 
		this.pool = 0; 
		this.racquet = 0; 
		this.wolfBasketball = 0; 
		this.weightRoom = 0; 
		this.fieldHouse = 0;
		this.rockWall = 0; 
		this.danceRoom = 0; 
		this.wrestlingRoom = 0;
	}
	
	//Getters
	public int getPopTotal()
	{
		return popTotal;
	}
	
	public int getPool()
	{
		return pool;
	}
	
	public int getRacquet()
	{
		return racquet;
	}
	
	public int getWolfBasketball()
	{
		return wolfBasketball;
	}
	
	public int getWeightRoom()
	{
		return weightRoom;
	}
	
	
	public int getFieldHouse()
	{
		return fieldHouse;
	}
	
	public int getRockWall()
	{
		return rockWall;
	}
	
	public int getDanceRoom()
	{
		return danceRoom;
	}
	
	public int getWrestlingRoom()
	{
		return wrestlingRoom;
	}
	
	
	//Setters
	public void setPopTotal(int popTotal)
	{
		this.popTotal = popTotal;
	}
	
	public void setPool(int pool)
	{
		this.pool = pool;
	}
	
	public void setRacquet(int racquet)
	{
		this.racquet = racquet;
	}
	
	public void setWolfBasketball(int wolfBasketball)
	{
		this.wolfBasketball = wolfBasketball;
	}
	
	public void setWeightRoom(int weightRoom)
	{
		this.weightRoom = weightRoom;
	}
	
	
	public void setFieldHouse(int fieldHouse)
	{
		this.fieldHouse = fieldHouse;
	}
	
	public void setRockWall(int rockWall)
	{
		this.rockWall = rockWall;
	}
	
	public void setDanceRoom(int danceRoom)
	{
		this.danceRoom = danceRoom;
	}
	
	public void setWrestlingRoom(int wrestlingRoom)
	{
		this.wrestlingRoom = wrestlingRoom;
	}
}
