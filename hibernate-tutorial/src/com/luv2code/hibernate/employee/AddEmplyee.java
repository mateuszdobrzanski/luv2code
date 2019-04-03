package com.luv2code.hibernate.employee;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.employee.entity.Employee;

public class AddEmplyee {

	public static void main(String[] args) {

		Scanner enterText = new Scanner(System.in);
		
		System.out.println("Adding new emplyee...");
		System.out.print("Enter first name: ");
		String firstName = enterText.nextLine();
		System.out.println();
		
		System.out.print("Enter last name: ");
		String lastName = enterText.nextLine();
		System.out.println();
		
		System.out.print("Enter comapny name: ");
		String currentComapny = enterText.nextLine();
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
			// create a student object
			System.out.println("Creating new student object...");
			Employee newEmployee = new Employee(firstName, lastName, currentComapny);
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the new employee...");
			session.save(newEmployee);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}
