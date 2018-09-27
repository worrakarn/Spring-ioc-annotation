package com.ioc.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("com.ioc.id.lifecycle")
public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	private FortuneService fortuneServiceRandom;

	public TrackCoach(@Qualifier("happyFortuneService") FortuneService fortuneService ,@Qualifier("randomFortuneService") FortuneService fortuneServiceRandom) {
		this.fortuneService = fortuneService;
		this.fortuneServiceRandom = fortuneServiceRandom;
	}
	
	// add init-method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("Start");
	}
	
	// add destroy-method
	// For "prototype" scoped beans, Spring does not call the @PreDestroy method
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("Clean");
	}


	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailFortune() {
		return fortuneService.getFortune();
	}

	@Override
	public String getRandomFortune() {
		return fortuneServiceRandom.getFortune();
	}

}
