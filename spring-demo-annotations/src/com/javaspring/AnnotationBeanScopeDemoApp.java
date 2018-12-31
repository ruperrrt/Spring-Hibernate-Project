package com.javaspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);
		Coach anotherCoach = context.getBean("tennisCoach", Coach.class);
		
		// check for singleton & prototype
		boolean temp = theCoach == anotherCoach;
		System.out.println("\nPointing to the same object => " + temp);
		System.out.println("\nMemory location for theCoach:" + theCoach);
		System.out.println("\nMemory location for anotherCoach:" + anotherCoach + "\n");
		
		// close context
		context.close();

	}

}
