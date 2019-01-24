package com.assimilate.springboot.example.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.springboot.example.model.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	Set<Employee> employees = new HashSet<>();

	@GetMapping("/getAllEmployees")
	public Set<Employee> getEmployee() {
		return employees;
	}

	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		employees.add(employee);
		return employee;
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employeeToUpdate) {

		for (Employee employee : employees) {
			if (employee.getId().equals(employeeToUpdate.getId())) {
				employee.setName(employeeToUpdate.getName());
				employee.setSalary(employeeToUpdate.getSalary());
			}
		}

		return employeeToUpdate;
	}

	@DeleteMapping("/delete/{employeeId}")
	public Employee deleteEmployee(@PathVariable("employeeId") Integer employeeId) {

		Iterator<Employee> empIterator = employees.iterator();
		while (empIterator.hasNext()) {
			Employee emp = empIterator.next();
			if (emp.getId().equals(employeeId)) {
				empIterator.remove();
				break;
			}
		}
		return null;
	}

}
