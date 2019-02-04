package com.assimilate.springboot.example.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.springboot.example.model.Employee;
import com.assimilate.springboot.example.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

	Set<Employee> employees = new HashSet<>();

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/getAllEmployees")
	public List<Employee> getEmployee() {

		return employeeService.getAll();
	}

	
	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		employeeService.createEmployee(employee);
		return employee;
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employeeToUpdate) {

		employeeService.updateEmployee(employeeToUpdate);

		return employeeToUpdate;
	}

	@DeleteMapping("/delete/{employeeId}")
	public Employee deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		employeeService.deleteEmployeeById(employeeId);
		return null;

	}

}
