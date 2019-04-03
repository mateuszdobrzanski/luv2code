package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {

		//load the configuration file
		ClassPathXmlApplicationContext contex = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrive bean from application contex
		Coach theCoach = contex.getBean("myCoach", Coach.class);
		
		//call methods on the bean
		System.out.print(theCoach.getDailyFortune());
		System.out.print(" So.. ");
		System.out.println(theCoach.getDailyWorkout());
		
		//close the contex
		contex.close();
	}

}
