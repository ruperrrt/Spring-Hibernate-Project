package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Instructor;
import com.srp.hibernate.demo.entity.InstructorDetail;
// import com.srp.hibernate.demo.entity.Student;


public class CreateInstructorDemoApp {

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
			// create a objects
			System.out.println("Creating");
			/*
			Instructor myinstructor = new Instructor("Shu", "Xiong", "xiongshu0101@qq.com");
			InstructorDetail mydetail = 
					new InstructorDetail("www.youtube/tony", "peach");
			*/
			Instructor myinstructor = new Instructor("Ting", "Lu", "luting0101@qq.com");
			InstructorDetail mydetail = 
					new InstructorDetail("www.youtube/TT", "majiang");
			
			// associate the two objects
			 myinstructor.setInstructorDetail(mydetail);
			 
			
			// start a transaction
			session.beginTransaction();
			
			 // save the instructor  =>  detail will be saved at the same time (cascade)
			System.out.println("Saving the student: " + myinstructor);
			session.save(myinstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}

	}

}
