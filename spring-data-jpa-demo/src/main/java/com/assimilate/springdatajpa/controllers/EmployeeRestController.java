package com.assimilate.springdatajpa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.springdatajpa.model.Employee;
import com.assimilate.springdatajpa.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/api/employees")
public class EmployeeRestController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping("/getAllEmployees")
	public List<Employee> getEmployee() {

		return employeeRepository.findAll();
	}

	@PostMapping("/create")
	public Employee createEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return employee;
	}

	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employeeToUpdate) {
		employeeRepository.save(employeeToUpdate);
		return employeeToUpdate;
	}

	@DeleteMapping("/delete/{employeeId}")
	public Employee deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
		employeeRepository.delete(employeeId);
		return null;

	}

	@GetMapping("/getEmployeeByName/{name}")
	public List<Employee> getByEmployeeName(@PathVariable("name") String employeeName) {

		return employeeRepository.findByName(employeeName);
	}

	@GetMapping("/getEmployeeByDesignation/{designation}")
	public List<Employee> getByDesignation(@PathVariable("designation") String designation) {

		return employeeRepository.findByDesignation(designation);
	}
}
