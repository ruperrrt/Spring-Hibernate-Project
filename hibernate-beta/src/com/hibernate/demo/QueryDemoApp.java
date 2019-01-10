package com.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Student;

public class QueryDemoApp {

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
			
			// query and display the students
			List<Student> studentList = session.createQuery("from Student").list();
			displayStudent(studentList);
			
			// query students: lastname = 'Xiong'
			studentList = session.createQuery("from Student s where s.lastName='Xiong'").list();
			System.out.println("\n\n Students whose last name is Xiong:");
			displayStudent(studentList);
			
			// query students: lastname = 'Xiong' OR fistname = "Jie"
			
			studentList = session.createQuery("from Student s where "
					+ "s.lastName='Xiong' OR s.firstName='Jie'").list();
			System.out.println("\n\n Students whose last name is Xiong or whose fist name is Jie:");
			displayStudent(studentList);
			
			
			// query students who has 126 mailbox
			studentList = session.createQuery("from Student s where "
					+ "s.email LIKE '%@126.com'").list();
			System.out.println("\n\n Students who have 126 mailbox:");
			displayStudent(studentList);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

	private static void displayStudent(List<Student> studentList) {
		for(Student s : studentList)
			System.out.println(s);
	}

}
