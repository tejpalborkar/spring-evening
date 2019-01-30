package com.assimilate.springboot.example.service;

import java.util.List;

import com.assimilate.springboot.example.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Integer updateEmployee(Employee employee);

	List<Employee> getAll();

	List<Employee> findEmployeeByName(String employeeName);

	int deleteEmployeeById(Integer id);

	Employee findEmployeeById(Integer employeeId);

}
