package com.ioc.id.bean.value;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// load the spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		// retrieve bean from spring container
		TrackCoach theCoach = context.getBean("trackCoach", TrackCoach.class);
		//call methods on the bean
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailFortune());
		System.out.println("Email:"+theCoach.getEmail());
		System.out.println("Team:"+theCoach.getTeam());
		//close the context
		context.close();

	}

}
