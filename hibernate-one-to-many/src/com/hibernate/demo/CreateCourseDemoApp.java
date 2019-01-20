package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Course;
import com.srp.hibernate.demo.entity.Instructor;
import com.srp.hibernate.demo.entity.InstructorDetail;
// import com.srp.hibernate.demo.entity.Student;


public class CreateCourseDemoApp {

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
			System.out.println("Creating");
			
			// start a transaction
			session.beginTransaction();
			
			
			// get the instructor from db
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			
			Course newCourse1 = new Course("CPSC 445");
			Course newCourse2 = new Course("Independent Study");
			
			// add courses to the instructor
			instructor.add(newCourse1);
			instructor.add(newCourse2);
			
			session.save(newCourse1);
			session.save(newCourse2);
			
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
