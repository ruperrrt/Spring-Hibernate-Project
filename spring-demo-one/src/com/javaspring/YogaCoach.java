package com.javaspring;

public class YogaCoach implements Coach {
	
	private FortuneService fortuneService;
	
	// add new fields
	private String emailAddress;
	private String team;
	
	
	public String getEmailAddress() {
		return emailAddress;
	}


	public void setEmailAddress(String emailAddress) {
		System.out.println("YogaCoach: -- inside --- setEmailAddress ");
		this.emailAddress = emailAddress;
	}


	public String getTeam() {
		return team;
	}


	public void setTeam(String team) {
		System.out.println("YogaCoach: -- inside --- setTeam");
		this.team = team;
	}


	public YogaCoach() {
		System.out.println("hhhhhhhhh");
	}
	
	
	// setter method    called by Spring (setter injection)
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
		System.out.println("66666666");
	}



	@Override
	public String getDailyWorkout() {
		return "Practice yoga for at least one hour";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
