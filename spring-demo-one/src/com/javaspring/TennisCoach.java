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

}
