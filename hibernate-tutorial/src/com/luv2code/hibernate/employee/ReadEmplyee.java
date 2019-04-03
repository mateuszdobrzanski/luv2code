package com.luv2code.hibernate.employee;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.employee.entity.Employee;

public class ReadEmplyee {

	public static void main(String[] args) {

		Scanner enterText = new Scanner(System.in);
		
		System.out.println("Read existing emplyee by ID...");
		System.out.print("Enter employee ID: ");
		int inputIdField = enterText.nextInt();
		System.out.println();
		
		enterText.close();
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate_employee.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
			
		try {			
			// start a transaction
			session.beginTransaction();
			
			// retrieve employee by ID
			System.out.println("Get employee by ID: " + inputIdField);
			Employee myEmployee = session.get(Employee.class, inputIdField);
			System.out.println("Get complete: " + myEmployee);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			System.out.println("Employee not exist!");
			factory.close();
		}
	}

}
