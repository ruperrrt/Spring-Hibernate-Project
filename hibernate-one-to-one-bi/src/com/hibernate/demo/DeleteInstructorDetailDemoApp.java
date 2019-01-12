package com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.srp.hibernate.demo.entity.Instructor;
import com.srp.hibernate.demo.entity.InstructorDetail;
// import com.srp.hibernate.demo.entity.Student;


public class DeleteInstructorDetailDemoApp {

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
			
			// get the instruction detail 
			int id = 4;
			InstructorDetail myDetail = session.get(InstructorDetail.class, id);
			
			System.out.println("myInstructor detail: " + myDetail);
			
			System.out.println("The associated instructor: " + myDetail.getInstructor());
			
			// break the bi-directional link
			
			myDetail.getInstructor().setInstructorDetail(null);
			
			
			// delete the instructor detail (must cut it off)
			System.out.println("Deleting myInstructorDetail: " + myDetail);
			session.delete(myDetail);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// handle connection leak issue
			session.close();
			
			factory.close();
		}

	}

}
