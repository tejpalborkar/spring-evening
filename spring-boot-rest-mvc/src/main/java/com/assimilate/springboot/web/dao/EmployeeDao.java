package com.assimilate.springboot.web.dao;

import java.util.List;

import com.assimilate.springboot.web.models.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();

	int save(Employee employee);

	Employee findById(int id);

	void delete(int id);

	void updateEmployee(Employee employee);

}
