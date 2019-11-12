package com.assimilate.springboot.web.services;

import java.util.List;

import com.assimilate.springboot.web.models.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public int createEmployee(Employee employee);

	public Employee getEmployeeById(int id);

	public void delete(int id);

	public void updateEmployee(Employee employee);
}
