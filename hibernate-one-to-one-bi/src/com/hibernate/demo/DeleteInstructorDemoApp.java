package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Instructor;
import com.srp.hibernate.demo.entity.InstructorDetail;
// import com.srp.hibernate.demo.entity.Student;


public class DeleteInstructorDemoApp {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			
			// start a transaction
			session.beginTransaction();
			
			// get the instructor
			int id = 2;
			Instructor toDelete = session.get(Instructor.class, id);
			System.out.println("Find the instructor: " + toDelete);
			
			// delete the instructor  => detail deleted too (cascade)
			session.delete(toDelete);
			System.out.println("Deletion success!");
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
