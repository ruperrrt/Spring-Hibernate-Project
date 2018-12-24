package com.javaspring;

public class MyApp {

	public static void main(String[] args) {
 
		Coach coach = new BaseballCoach();
		Coach anotherCoach = new TennisCoach();
		System.out.println(anotherCoach.getDailyWorkout());
	}

}
