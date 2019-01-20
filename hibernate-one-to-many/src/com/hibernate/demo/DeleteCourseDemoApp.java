package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Course;
import com.srp.hibernate.demo.entity.Instructor;
import com.srp.hibernate.demo.entity.InstructorDetail;
// import com.srp.hibernate.demo.entity.Student;


public class DeleteCourseDemoApp {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a objects
			System.out.println("Deleting Course");
			
			// start a transaction
			session.beginTransaction();
			
			
			// get the instructor from db
			int theId = 11;
			Course course = session.get(Course.class, theId);
			
			session.delete(course);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			// add clean up code
			session.close();
			
			factory.close();
		}

	}

}
