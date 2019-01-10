package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Student;


public class UpdateStudentDemoApp {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {

			// start a transaction
			session.beginTransaction();
			
			// using java to update
			int studentId = 1;
			Student s = session.get(Student.class, studentId);
			s.setFirstName("Mao");
			
			
			// using HQL to update
			session
				.createQuery("update Student s set email='foobar@gmail.com'"
						+ " where s.lastName='Yin'")
				.executeUpdate();
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
