package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Student;


public class DeleteStudentDemoApp {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create a student object
			//System.out.println("Creating");
			//Student mystudent = new Student("Bruce", "Lin", "lwl0101@qq.com");
			
			// start a transaction
			session.beginTransaction();
			
			// delete using java
			session.delete(session.get(Student.class, 5));
			
			// session.save(mystudent);
			
			// delete using HQL
			
			session
				.createQuery("delete from Student where id=6")
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
