package com.javaspring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
 
		// load spring config file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		// retrieve bean from spring container
		YogaCoach demoCoach = context.getBean("myYogaCoach", YogaCoach.class);
		// call methods on the bean
		System.out.println(demoCoach.getDailyWorkout());
		System.out.println(demoCoach.getDailyFortune());
		
		// call new methods for literal values
		System.out.println(demoCoach.getEmailAddress());
		System.out.println(demoCoach.getTeam());
		
		// close the context
		context.close();
	}

}
