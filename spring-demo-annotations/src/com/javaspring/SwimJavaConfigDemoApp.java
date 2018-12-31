package com.javaspring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring config file
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(SportConfig.class);
		// get bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call method to get daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// test swim coach methods
		System.out.println("\nemail: " + theCoach.getEmail());
		System.out.println("\nteam: " + theCoach.getTeam());
		
		// close context
		context.close();
	}

}
