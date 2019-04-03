package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
			Query<Instructor> query = session.createQuery("SELECT i FROM Instructor i "
														+ "JOIN FETCH i.courses "
														+ "WHERE i.id=:theInstructorId",
					Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();
			
			System.out.println("luv2cod3: Instructor: " + tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			// close the session
			session.close();
			
			// since courses are lazy loaded... this should fail
			// to resolve this problem we can:
			// option 2: Hibernate Query with HQL
			
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