package com.luv2code.springdemo;

import org.springframework.stereotype.Component;

@Component
public class NotACreativeCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Do something, I'm not creative today";
	}

	@Override
	public String geyDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}

}
