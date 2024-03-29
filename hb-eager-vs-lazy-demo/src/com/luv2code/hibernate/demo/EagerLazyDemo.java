package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// start a transaction
			session.beginTransaction();
			
			// get instructor by id form db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("luv2cod3: Instructor: " + tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			// since courses are lazy loaded... this should fail
			// to resolve this problem we can:
			// option 1: call the getter method while session is open
				// move tempInstructor.getCourses() higher then session.close();
			
			
			// get course for the instructor
			System.out.println("luv2cod3: Courses: " + tempInstructor.getCourses());
			
			System.out.println("luv2cod3: Done!");
		}
		finally {
			// add clean up code
			session.close();
			factory.close();
		}
	}
}