package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Course;
import com.srp.hibernate.demo.entity.Instructor;
import com.srp.hibernate.demo.entity.InstructorDetail;
import com.srp.hibernate.demo.entity.Review;
// import com.srp.hibernate.demo.entity.Student;
import com.srp.hibernate.demo.entity.Student;


public class DeleteCourseCS561DemoApp {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();
			
			int cId = 10;
			Course cs561 = session.get(Course.class, cId);
			
			session.delete(cs561);
			
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
