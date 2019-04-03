package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	//define private field for the dependency
	private FortuneService fortuneService;
	
	//define a constructor for dependency injection
	public TrackCoach(FortuneService fortuneService) 
	{
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout()
	{
		return "Run for 25 mins.";
	}

	@Override
	public String getDailyFortune() {
		// use my fortuneService to get daily fortune
		return fortuneService.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff()
	{
		System.out.println("TrackCoach: inside method doMyStartupStuff()");
	}
	
	//ad a destroy method
	public void doMyCleanupStuff()
	{
		System.out.println("TrackCoach: inside method doMyCleanupStuff()");
	}
	
}
