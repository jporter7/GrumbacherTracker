package edu.ycp.cs320.jporter7.model;

public class Numbers 
{
	private Double first, second, third, addResult, multiplyResult;
	
	public Numbers()
	{
		
	}
	
	public Double getFirst()
	{
		return first;
	}
	
	public Double getSecond()
	{
		return second;
	}
	
	public Double getThird()
	{
		return third;
	}
	
	public Double getAddResult()
	{
		return addResult;
	}
	
	public Double getMultiplyResult()
	{
		return multiplyResult;
	}
	
	public void setFirst(Double first)
	{
		this.first = first;
	}
	
	public void setSecond(Double second)
	{
		this.second = second;
	}
	
	public void setThird(Double third)
	{
		this.third = third;
	}
	
	public void setAddResult(Double addResult)
	{
		this.addResult = addResult;
	}
	
	public void setMultiplyResult(Double multiplyResult)
	{
		this.multiplyResult = multiplyResult;
	}
	
	/*public Double addResult(Double first, Double second, Double third)
	{
		
		return first + second + third;
	}
	
	
	public Double multiplyResult(Double first, Double second)
	{
		return first * second;
	}*/
	
}
