package com.luv2code.springdemo;

public class SadFortuneService implements fortuneService {

	@Override
	public String getFortune() {
		return "Today is a sad day :(";
	}

}
