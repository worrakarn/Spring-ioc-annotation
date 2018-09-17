package com.ioc.basepack;
import java.util.*;

import org.springframework.stereotype.Component;

@Component
public class RandomFortuneService implements FortuneService{
	private String[] data = { 
			"Beware of the wolf in sheep's clothing",
			"Diligence is the mother of good luck",
			"The journey is the reward"
	};
	
	private Random random;
	
	public RandomFortuneService() {
		System.out.println("Random: inside RandomFortuneService");
	}

	@Override
	public String getFortune() {
		random = new Random();
		int index = random.nextInt(data.length);
		return String.valueOf(data[index]);
	}

}
