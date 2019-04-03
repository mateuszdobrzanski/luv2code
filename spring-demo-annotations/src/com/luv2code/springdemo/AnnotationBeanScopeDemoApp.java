package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		// load spring config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		
		Coach aplhaCoach = context.getBean("tennisCoach", Coach.class);
		
		// check if objects are same
		boolean result = (theCoach == aplhaCoach);
		
		// print out the result
		System.out.println("Are same objects? " + result);
		
		System.out.println("Memory location theCoach: " + theCoach);
		System.out.println("Memory location aplhaCoach: " + aplhaCoach);
		
		// close context
		context.close();
	}

}
