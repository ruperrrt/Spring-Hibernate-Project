package com.javaspring;

public class TennisCoach implements Coach {
	
	private FortuneService fortuneService;
	
	public TennisCoach(FortuneService fService) {
		fortuneService = fService;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Spend 45 minutes hitting to the wall.";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
	
	// add init method
	public void startUpStuff() {
		System.out.println("TennisCoach => inside method startUpStuff");
	}
	
	// add destroy method
	public void cleanUpStuff() {
		System.out.println("TennisCoach => inside method cleanUpStuff");
	}
}
