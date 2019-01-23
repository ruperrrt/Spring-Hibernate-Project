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


public class CreateCoursesAndStudentsDemoApp {

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
			
			// create students
			
			Student stu1 = new Student("rp", "s", "srp@usc.edu");
			Student stu2 = new Student("wl", "l", "lwl@usc.edu");
			Student stu3 = new Student("m", "l", "lm@usc.edu");
			
			// create courses
			Course myCourse1 = new Course("CS561");
			Course myCourse2 = new Course("CS526");
			Course myCourse3 = new Course("CS402");
			
				
			// Add some students
			myCourse1.addStudent(stu1);
			myCourse1.addStudent(stu2);
			myCourse2.addStudent(stu1);
			myCourse2.addStudent(stu3);
			myCourse3.addStudent(stu2);
			// cascade to save all reviews!!! CASCADE MAGIC!
			
			System.out.println("Saving the courses");
			session.save(myCourse1);
			session.save(myCourse2);
			session.save(myCourse3);
			
			System.out.println("Saving the students");
			session.save(stu1);
			session.save(stu2);
			session.save(stu3);
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
