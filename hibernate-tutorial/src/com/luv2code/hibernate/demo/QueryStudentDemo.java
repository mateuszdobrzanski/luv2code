package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			session.beginTransaction();

			// query students 
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// display students
			displayMethods(theStudents);
			
			System.out.println("\n");
			
			// query students lastName: "Duck"
			theStudents = session.createQuery("from Student s where s.lastName='Duck'").getResultList();
			displayMethods(theStudents);			
			
			System.out.println("\n");
			
			// query students lastName: "Duck" OR firstName: "Adam"  
			theStudents = session.createQuery("from Student s where " 
						+ "s.lastName = 'Duck' OR s.firstName = 'Adam'").getResultList();
			displayMethods(theStudents);
			
			System.out.println("\n");
			
			// query studends where email NOT ends "luv2code.com"
			theStudents = session.createQuery("from Student s where "
						+ "s.email NOT LIKE '%luv2code.com'").getResultList();
			displayMethods(theStudents);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayMethods(List<Student> theStudents) {
		System.out.println("Number of students: [" + theStudents.size() + "]");
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}
}