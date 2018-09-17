package com.ioc.id.qualifier;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages="com.ioc.id.qualifier")
public class TrackCoach implements Coach {
	
	@Autowired
	@Qualifier("sadFortuneService")
	private FortuneService FortuneServiceSad;
	
	private FortuneService FortuneServiceHappy;
	
	private Random random;
	
	public TrackCoach(@Qualifier("happyFortuneService") FortuneService fortuneServiceHappy) {
		FortuneServiceHappy = fortuneServiceHappy;
	}

	public void setFortuneServiceSad(FortuneService fortuneServiceSad) {
		FortuneServiceSad = fortuneServiceSad;
	}

	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k";
	}

	@Override
	public String getDailFortune() {
		random = new Random();
		int index = random.nextInt(2)+1;
		if (index==1) {
			return FortuneServiceSad.getFortune();
		}else
		return FortuneServiceHappy.getFortune();
	}
	
	

}
