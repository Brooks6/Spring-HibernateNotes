package com.brooks.springDemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		// load the spring configuration file
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("beanScopeApplicationContext.xml");
		// retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		//check if they are the same
		boolean result = (theCoach == alphaCoach);
		System.out.println(result);
		System.out.println(theCoach);
		System.out.println(alphaCoach);
	}

}
