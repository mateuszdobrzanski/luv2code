package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	//define private field for the dependency
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public BaseballCoach(FortuneService fortuneService) 
	{
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout()
	{
		return "Spend 30 mins on batting practice";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get daily fortune
		return fortuneService.getFortune();
	}
}
