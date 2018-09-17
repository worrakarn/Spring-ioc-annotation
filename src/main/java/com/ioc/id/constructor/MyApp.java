package com.ioc.id.constructor;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// load the spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TrackCoach.class);
		Coach theCoach = context.getBean("trackCoach", Coach.class);
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailFortune());
		System.out.println(theCoach.getRandomFortune());
		//close the context
		context.close();

	}

}
