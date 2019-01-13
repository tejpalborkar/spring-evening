package com.assimilate.emp.app.service;

import java.util.List;

import com.assimilate.emp.app.model.Employee;

public interface EmployeeService {

	Employee createEmployee(Employee employee);

	Integer updateEmployee(Employee employee);

	List<Employee> getAll();

	List<Employee> findEmployeeByName(String employeeName);

	int deleteEmployeeById(Integer id);

}
