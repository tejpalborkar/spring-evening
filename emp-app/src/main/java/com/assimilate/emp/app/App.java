package com.assimilate.emp.app;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.assimilate.emp.app.config.EmployeeAppConfiguration;
import com.assimilate.emp.app.model.Employee;
import com.assimilate.emp.app.service.EmployeeService;
import com.assimilate.emp.app.service.EmployeeServiceImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(EmployeeAppConfiguration.class);

		// Employee employee = context.getBean(Employee.class);

		EmployeeService employeeService = (EmployeeService) context.getBean(EmployeeServiceImpl.class);

		System.out.println(employeeService);

		Employee employee = new Employee();
		employee.setId(1001);
		employee.setName("John");
		employee.setSalary(87690);

//		employeeService.createEmployee(employee);

		List<Employee> employeesFromDb = employeeService.getAll();

		System.out.println("========== employeeService.getAll()  ==> Employees==============");
		for (Employee e : employeesFromDb) {
			System.out.println(e);
		}
		int status = 0;
		// System.out.println("insert status: " + status);

		employeeService.updateEmployee(new Employee(3020, "Sandeep", 50000));
		System.out.println("update status: " + status);

		/*
		 * Employee e = new Employee(); e.setId(109); status = dao.deleteEmployee(e);
		 */

		status = employeeService.deleteEmployeeById(102);
		System.out.println("delete status: " + status);

		List<Employee> empList = employeeService.findEmployeeByName("Amit");
		System.out.println("========== findEmployeeByName ==> Employees==============");
		for (Employee e : empList) {
			System.out.println(e);
		}
		
		employeesFromDb = employeeService.getAll();

		System.out.println("========== employeeService.getAll()  ==> Employees==============");
		for (Employee e : employeesFromDb) {
			System.out.println(e);
		}


	}
}
