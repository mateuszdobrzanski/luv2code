package com.luv2code.springdemo;

public class SwimmingCoach implements Coach {
	
	//define private field for the dependency
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public SwimmingCoach(FortuneService fortuneService) 
	{
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() 
	{
		return "Swim the pool 10 times";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get daily fortune
		return fortuneService.getFortune();
	}

}
