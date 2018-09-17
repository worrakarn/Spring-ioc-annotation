package com.ioc.basepack;

import org.springframework.stereotype.Component;

@Component("myCoach")
public class TrackCoach implements Coach {

	private FortuneService FortuneServiceHappy;
	
	private FortuneService FortuneServiceRandom;

	public TrackCoach(FortuneService happyFortuneService ,FortuneService randomFortuneService) {
		this.FortuneServiceHappy = happyFortuneService;
		this.FortuneServiceRandom = randomFortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailFortune() {
		return FortuneServiceHappy.getFortune();
	}

	@Override
	public String getRandomFortune() {
		return FortuneServiceRandom.getFortune();
	}

}
