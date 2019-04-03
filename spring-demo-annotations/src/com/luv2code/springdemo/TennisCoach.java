package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("fileFortuneService") //in brackets bean id
	private fortuneService theFortuneService; 
	
	/*
	@Autowired
	public TennisCoach(fortuneService theFortuneService) {
		this.theFortuneService = theFortuneService;
	}
	 */
	
	
	// define my init method
	
	@PostConstruct
	public void doMyStartUpStuff() {
		System.out.println("Inside doMyStartUpStuff()");
	}
	
	
	// define my destroy methods
	@PreDestroy
	public void doMyCleanupMethod() {
		System.out.println("Inside doMyCleanupMethod()");
	}
	
	//define a default constructor
	public TennisCoach() {
		System.out.println(">> TennisCoach: inside default constructor");
	}
	
	
	
	/*
	// define a setter method
	@Autowired
	public void setFortuneService(fortuneService theFortuneService)
	{
		System.out.println(">> TennisCoach: inside in the setter method");		
		this.theFortuneService = theFortuneService;
	}
	*/
	
	/*
	// define a method injection
	@Autowired
	public void anyNameForUsMethod(fortuneService theFortuneService)
	{
		System.out.println(">> TennisCoach: inside in the setter method");		
		this.theFortuneService = theFortuneService;
	}
	*/
	
	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String geyDailyFortune() {
		// TODO Auto-generated method stub
		return theFortuneService.getFortune();
	}

}
