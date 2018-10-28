package com.assisimilate.spring.autowiring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		String springXmlPath = "spring-application-beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springXmlPath);

		Car car = (Car) applicationContext.getBean("car");
		System.out.println(car);
		
		Engine engine = (Engine) applicationContext.getBean("engine");
		
		System.out.println("Engine bean: "+ engine);

	}
}
