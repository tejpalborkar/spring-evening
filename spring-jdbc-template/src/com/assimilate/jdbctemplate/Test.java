package com.assimilate.jdbctemplate;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");
		
		int status =0;
		status =dao.saveEmployee(new Employee(201, "Sandeep", 25000));
		System.out.println("insert status: " + status);

		status = dao.updateEmployee(new Employee(201, "Sandeep", 25000));
		System.out.println("update status: " + status);

		Employee e = new Employee();
		e.setId(201);
		status = dao.deleteEmployee(e);
		System.out.println("delete status: " + status);
		
		
		List<Employee> empList = dao.getEmployeesByName("Sandeep");
		System.out.println("==========Employees==============");
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		
//		empList.forEach(e -> System.out.println(e));

	}

}
