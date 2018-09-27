package com.ioc.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages="com.ioc.id.constructor")
public class TrackCoach implements Coach {

	private FortuneService FortuneServiceHappy;

	private FortuneService FortuneServiceRandom;
	
	@Autowired
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
