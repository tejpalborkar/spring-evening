package com.assimilate.springboot.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.springboot.web.models.Employee;
import com.assimilate.springboot.web.services.EmployeeService;

@RequestMapping("/employees")
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(path = "/getEmployee")
	public Employee getEmployee() {
		Employee employee = new Employee("John", 123);
		return employee;

	}

	@RequestMapping(path = "/getAll")
	public List<Employee> getAllEmployee() {
		return employeeService.getEmployees();

	}

	@RequestMapping(path = "/getById/{id}")
	public ResponseEntity<Object> getByEmployee(@PathVariable("id") int id) {
		System.out.println("Finding the employee by ID : " + id);
		Employee e = employeeService.getEmployeeById(id);
		if (e == null) {
			return new ResponseEntity<Object>("Employee not found", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Object>(e, HttpStatus.OK);
		}

	}

	@RequestMapping(path = "/update")
	public String updateEmployee(@RequestBody Employee employee) {
		System.out.println("Employee updating");

		employeeService.updateEmployee(employee);

		System.out.println("Employee updated");
		return "Employee updated successfully";

	}

	@RequestMapping(path = "/create")
	public String createEmployee(@RequestBody Employee employee) {
		System.out.println("Employee created");

		int result = employeeService.createEmployee(employee);

		System.out.println("Employee saved");
		return "Employee saved successfully";

	}

	@RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") int id) {

		employeeService.delete(id);
		return "employee deleted successfully";
	}
}
