package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Course;
import com.srp.hibernate.demo.entity.Instructor;
import com.srp.hibernate.demo.entity.InstructorDetail;
import com.srp.hibernate.demo.entity.Review;
// import com.srp.hibernate.demo.entity.Student;


public class GetCourseAndReviewsDemoApp {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a objects
			System.out.println("Creating");
			
			// start a transaction
			session.beginTransaction();
			
			/*
			int rId = 1;
			Review tempReview = session.get(Review.class, rId);
			session.delete(tempReview);
			*/
			
			int cId = 13;
			session.delete(session.get(Course.class, cId));
			
			
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
