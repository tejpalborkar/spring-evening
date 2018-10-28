package com.assimililate.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	
	
	/**
	 * 
	 *
	 * 
CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `salary` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringJDBCConfiguration.class);

		EmployeeDao dao = (EmployeeDao) ctx.getBean("employeeDAO");

		int status = 0;
		// System.out.println("insert status: " + status);

//		status = dao.updateEmployee(new Employee(109, "Sandeep", 25000));
//		System.out.println("update status: " + status);

	/*	Employee e = new Employee();
		e.setId(109);
		status = dao.deleteEmployee(e);
		System.out.println("delete status: " + status);
	*/	
		
		List<Employee> empList = dao.getEmployeesByName("Amit");
		System.out.println("==========Employees==============");
		for (Employee employee : empList) {
			System.out.println(employee);
		}
		
//		empList.forEach(e -> System.out.println(e));

	}

}
