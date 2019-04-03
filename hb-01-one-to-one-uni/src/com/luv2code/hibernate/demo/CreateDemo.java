package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class CreateDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
/*
			// create the objects
			Instructor tempInstructor = new Instructor("Cahd", "Darby", "darby@example.com");
			InstructorDetail tempInstructorDetails = new InstructorDetail("youtube.com/chad_darby", "Hobby");
*/
			// create the objects
			Instructor tempInstructor = new Instructor("Muhamed", "Wisi mu L'aha", "destroyer@example.com");
			InstructorDetail tempInstructorDetails = new InstructorDetail("youtube.com/destroYeR", "Destroy everything and anything");
			
			// associate the objects
			tempInstructor.setInstrudtorDetail(tempInstructorDetails);
			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// NOTE: This will ALSO save the object's details
			// because of CascadeType.ALL
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
}