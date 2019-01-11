package com.assimilate.emp.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.assimilate.emp.app.config.EmployeeAppConfiguration;
import com.assimilate.emp.app.model.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeAppConfiguration.class);
		
		Employee employee = context.getBean(Employee.class);
		
		System.out.println(employee);
	}
}
