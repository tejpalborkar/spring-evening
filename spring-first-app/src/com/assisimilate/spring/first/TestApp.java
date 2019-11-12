package com.assisimilate.spring.first;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class TestApp {
	public static void main(String[] args) {

		// core ioc container

		Resource resource = new ClassPathResource("spring-beans.xml");
		BeanFactory container = new XmlBeanFactory(resource);

		Employee employee = (Employee) container.getBean("employee");

		System.out.println(employee);

		// Advance container
		// Eager container
		String springXmlPath = "spring-beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springXmlPath);
		
		Employee emp = (Employee) applicationContext.getBean("employee");
		System.out.println(emp);

		Address addr = (Address) applicationContext.getBean("address");
		
		System.out.println(addr);
	}
}
