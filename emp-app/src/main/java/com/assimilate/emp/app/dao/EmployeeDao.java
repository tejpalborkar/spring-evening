package com.assimilate.emp.app.dao;

import java.util.List;

import com.assimilate.emp.app.model.Employee;

public interface EmployeeDao {
	Employee createEmployee(Employee employee);

	int updateEmployee(Employee employee);

	List<Employee> getAll();

	List<Employee> findEmployeeByName(String employeeName);

	int deleteEmployeeById(Integer id);

}
