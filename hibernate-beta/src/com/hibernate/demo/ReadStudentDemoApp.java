package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Student;


public class ReadStudentDemoApp {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// read a student object from database
			System.out.println("Creating");
			Student mystudent = new Student("Jie", "Yin", "yinjie666@qq.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save object
			System.out.println("Saving the student");
			System.out.println(mystudent);
			session.save(mystudent);
			
			// commit transaction
			session.getTransaction().commit();
			
			// *** RETRIEVE STUDENT
			
			// find out primary key
			System.out.println("Student saved. Generated id: " + mystudent.getId() );
			
			// start new session/transaction  => get student via id => commit
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			
			System.out.println("\nGetting student with id: " + mystudent.getId());
			Student tempStudent = session.get(Student.class, mystudent.getId());
			
			System.out.println("Get completed: " + tempStudent);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
