package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements fortuneService {
	
	private static String data[] = new String [10];
	
	private static void readFromFile()
	{
		try {
		    BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Mateusz\\Desktop\\fortune.txt"));
		    String str;
		    int i = 0;
		    while ((str = in.readLine()) != null) {
		    	data[i] = str;
			    i++;
		    }
		    in.close();
		} catch (IOException e) {
		}
	}
	
	private static String getRandom(String[] array) {
		readFromFile();
		int rnd = new Random().nextInt(array.length);
		return array[rnd];
	}

	@Override
	public String getFortune() {
		return getRandom(data);
	}

}
