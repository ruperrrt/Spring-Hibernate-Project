package com.javaspring;

public class BaseballCoach implements Coach {
	@Override
	public String getDailyWorkout() {
		return "Spend 30 minutes running.";
	}
}
