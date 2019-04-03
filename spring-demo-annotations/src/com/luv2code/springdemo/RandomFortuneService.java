package com.luv2code.springdemo;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements fortuneService {

	// array of strings
	private String yourFortune[] = {
			"Today is your lucky day motherfucker",
			"Stay at home, loser",
			"Today is your day",
			"Try tomorow"
	};

	// chose one fortune
	private static String getRandom(String[] array) {
		int rnd = new Random().nextInt(array.length);
		return array[rnd];
	}

	@Override
	public String getFortune() {
		// pick a random fortune
		return getRandom(yourFortune);
	}

}
