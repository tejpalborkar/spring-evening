package com.assimilate.springboot.example.dao;

import java.util.List;

import com.assimilate.springboot.example.model.Employee;

public interface EmployeeDao {
	Employee createEmployee(Employee employee);

	int updateEmployee(Employee employee);

	List<Employee> getAll();

	List<Employee> findEmployeeByName(String employeeName);

	int deleteEmployeeById(Integer id);

	Employee findEmployeeById(Integer employeeId);

}
