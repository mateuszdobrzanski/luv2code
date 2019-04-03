package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve been from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach aplhaCoach = context.getBean("myCoach", Coach.class);
		
		// compare two objects
		boolean result = (theCoach == aplhaCoach);

		// print out the result
		System.out.println("Are object same? " + result);
		
		System.out.println("Memory location for theCoach: " + theCoach);

		System.out.println("Memory location for aplhaCoach: " + aplhaCoach);
		
		// close context
		context.close();
	}

}
