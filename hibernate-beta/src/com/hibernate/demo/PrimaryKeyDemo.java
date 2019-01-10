package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		// create session factory
		
		SessionFactory factory = new Configuration()
								.configure()
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();
		
		try {
			// create 3 student object
			System.out.println("Creating");
			Student mystudent1 = new Student("Shu", "Xiong", "xiongshu0101@qq.com");
			Student mystudent2 = new Student("Shuai", "Li", "xiongshu0101@126.com");
			Student mystudent3 = new Student("Mu", "Li", "xiongshu0101@163.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save object
			System.out.println("Saving the students");
			session.save(mystudent1);
			session.save(mystudent2);
			session.save(mystudent3);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
