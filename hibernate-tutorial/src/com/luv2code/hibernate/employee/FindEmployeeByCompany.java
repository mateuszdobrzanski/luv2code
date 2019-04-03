package com.luv2code.hibernate.employee;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;
import com.luv2code.hibernate.employee.entity.Employee;

public class FindEmployeeByCompany {

	public static void main(String[] args) {

		Scanner enterText = new Scanner(System.in);
		
		System.out.println("Read existing emplyee by company name...");
		System.out.print("Enter employee company: ");
		String compnayName = enterText.nextLine();
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
			
			// querry employees where working on entered company name 
			List<Employee> employeeList = session.createQuery("FROM Employee e WHERE e.company='" + compnayName + "'").getResultList();
			displayMethods(employeeList);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
	private static void displayMethods(List<Employee> theEmployes) {
		System.out.println("Number of employees: [" + theEmployes.size() + "]");
		for (Employee tempEmployee : theEmployes) {
			System.out.println(tempEmployee);
		}
	}

}
