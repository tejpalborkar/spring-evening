package com.assimilate.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

		EmployeeDao dao = (EmployeeDao) ctx.getBean("edao");

		int status = 0;
/*		boolean result = dao.saveEmployeeByPreparedStatement(new Employee(3020, "Sandeep", 25000));
		System.out.println("insert status: " + result);

		status = dao.saveEmployee(new Employee(111, "Sandeep", 25000));
		System.out.println("update status: " + status);

		Employee e = new Employee();
		e.setId(109);
		status = dao.deleteEmployee(e);
		System.out.println("delete status: " + status);
*/
		List<Employee> empList = dao.getEmployeesByName("Sandeep");
		System.out.println("==========Employees==============");
		for (Employee employee : empList) {
			System.out.println(employee);
		}

		// empList.forEach(e -> System.out.println(e));

		
		
		EmpDao empDao = (EmpDao) ctx.getBean("empDao");
		
		System.out.println(empDao.save(new Employee(3023, "Tejpal", 25000)));
		
		
		
		 empList = dao.getEmployeesByName("Tejpal");
		System.out.println("==========Employees After==============");
		for (Employee employee : empList) {
			System.out.println(employee);
		}

	}

}
