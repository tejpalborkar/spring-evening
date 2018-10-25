package com.assisimilate.spring.first;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Client {

	public static void main(String[] args) {

		Resource resource = new ClassPathResource("spring-beans.xml");

		//Core IoC container
		//Lazy Container
//		BeanFactory beanFactory = new XmlBeanFactory(resource);
		
		
		//Advance container
		//Eager container
		String springXmlPath = "spring-beans.xml";
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(springXmlPath);
		
		
		/*Employee emp =(Employee) applicationContext.getBean("employee");
		System.out.println("Firstname: "+emp.getFirstName());
		System.out.println("Id: "+emp.getId());
		System.out.println("Addres: "+emp.getEmpAddress());
		
		*/
		Fruits fruits =(Fruits) applicationContext.getBean("fruits");
		
		fruits.getFruitNames().forEach(System.out::println);
		
	/*	List<String> fruitList= fruits.getFruitNames();
		for (String name : fruitList) {
			System.out.println(name);
		}
	*/	
		
		
	}
}
