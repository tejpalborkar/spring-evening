package com.assimilate.springbootdemo.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assimilate.springbootdemo.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {

	private List<Employee> employees = new ArrayList<>();

	@GetMapping("/getAll")
	public List<Employee> getAll() {

		
//		employeeService.getAll()
		Employee emp = new Employee();
		emp.setId(123);
		emp.setDesignation("Software Developer");
		emp.setName("Namrat");
		emp.setSalary(400000);

		return employees;
	}

	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		// write logic to save
		employees.add(employee);
		//employeeService.save(employee);
		return employee;
	}

	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee) {

//		employeeService.update(employee);
		Employee employeeToBeUpdated = employees.stream().filter(e -> employee.getId() == e.getId()).findFirst().get();

		if (employeeToBeUpdated != null) {
			employeeToBeUpdated.setDesignation(employee.getDesignation());
			employeeToBeUpdated.setSalary(employee.getSalary());
			employeeToBeUpdated.setName(employee.getName());
		}

		return employeeToBeUpdated;

	}

	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Integer id) {

		System.out.println("ID : " + id);
//		employeeService.delete(id);
		Iterator<Employee> employeeIterator = employees.iterator();
		while (employeeIterator.hasNext()) {
			Employee employee = (Employee) employeeIterator.next();

			if (employee.getId() == id) {
				employeeIterator.remove();
				return "deleted successfully";
			}

		}

		return "Employee not found";
	}

	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getById(@PathVariable Integer id) {

		//employeeService.getById(id);
		ResponseEntity<Object> response = null;
		List<Employee> employeesFiltered = employees.stream().filter(e -> e.getId() == id).collect(Collectors.toList());

		if (employeesFiltered.isEmpty()) {
			response = new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
			return response;
		} else {
			response = new ResponseEntity<>(employeesFiltered.get(0), HttpStatus.OK);
			return response;
		}

	}
}
