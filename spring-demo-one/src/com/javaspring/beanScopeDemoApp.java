package com.javaspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class beanScopeDemoApp {

	public static void main(String[] args) {
		// load Config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("beanScope-appContext.xml");
		
		// retrieve bean from container (getBean singleton or prototype)
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach anotherCoach = context.getBean("myCoach", Coach.class);
		
		// check for singleton & prototype
		boolean temp = theCoach == anotherCoach;
		System.out.println("\nPointing to the same object => " + temp);
		System.out.println("\nMemory location for theCoach:" + theCoach);
		System.out.println("\nMemory location for anotherCoach:" + anotherCoach);
		
		context.close();
	}

}
