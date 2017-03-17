package edu.ycp.cs320.jporter7.controller;

import edu.ycp.cs320.jporter7.model.Numbers;

public class NumbersController 
{
	private Numbers model;
	
	public NumbersController(Numbers model)
	{
		this.model = model;
	}
	
	public void startGame()
	{
		model.setFirst(null);
		model.setSecond(null);
		model.setThird(null);
	}
	
	public void add() 
	{
		model.setAddResult(model.getFirst() + model.getSecond() + model.getThird());
	}
	
	public void multiply()
	{
		model.setMultiplyResult(model.getFirst() * model.getSecond());
	}
}
