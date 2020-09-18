package com.au.usyd.brooks;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// read spring config file
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(SportConfig.class);
		// get the bean from spring container
		Coach theCoach = context.getBean("swimCoach", SwimCoach.class);
		// call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		// call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		//call our new swim coach methods...has the props values injected
		System.out.println(((SwimCoach) theCoach).getEmail());
		System.out.println(((SwimCoach) theCoach).getTeam());
		// close the text
		context.close();
	}

}
