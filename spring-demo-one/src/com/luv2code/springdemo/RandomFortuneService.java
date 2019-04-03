package com.luv2code.springdemo;

import java.util.Random;

public class RandomFortuneService implements FortuneService {
	
	private String yourFortune[] = {
			"Today is your lucky day motherfucker",
			"Stay at home, loser",
			"Today is your day",
			"Try tomorow"
	};

	private static String getRandom(String[] array) {
	int rnd = new Random().nextInt(array.length);
	return array[rnd];
	}

	@Override
	public String getFortune() {
		return getRandom(yourFortune);
	}

}
