package com.ioc.beanspoce.singleton;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyApp {

	public static void main(String[] args) {
		// load the spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TrackCoach.class);
		// retrieve bean from spring container
		Coach theCoach = context.getBean("trackCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("trackCoach", Coach.class);
		
		// check if they are the same
		boolean result = (theCoach==alphaCoach);
		
		// pring out result
		System.out.println("\nPointing to the same Object "+result);
		System.out.println("\nMemory location of theCoach "+theCoach);
		System.out.println("\nMemory location of alphaCoach "+alphaCoach);

		//close the context
		context.close();

	}

}
