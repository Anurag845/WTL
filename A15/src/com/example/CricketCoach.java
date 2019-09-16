package com.example;

public class CricketCoach implements Coach{
	
	private FortuneService fortuneService;

	public CricketCoach(FortuneService fortuneService) {
		super();
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "2 hours every day.";
	}

	@Override
	public String getDailyFortune() {
		return "Today is your lucky day wrt Cricket.";
	}

}
