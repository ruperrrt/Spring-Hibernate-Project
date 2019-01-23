package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Course;
import com.srp.hibernate.demo.entity.Instructor;
import com.srp.hibernate.demo.entity.InstructorDetail;
import com.srp.hibernate.demo.entity.Review;
// import com.srp.hibernate.demo.entity.Student;


public class CreateCourseAndReviewsDemoApp {

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
			
			// create a course
			Course myCourse = new Course("CS561");
			
			// Add some reviews
			Review rev1 = new Review("shabi ke");
			Review rev2 = new Review("laji ke");
			Review rev3 = new Review("shangke jiu fankun");
			myCourse.addReview(rev1);
			myCourse.addReview(rev2);
			myCourse.addReview(rev3);
			
			// cascade to save all reviews!!! CASCADE MAGIC!
			session.save(myCourse);

			
			
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
