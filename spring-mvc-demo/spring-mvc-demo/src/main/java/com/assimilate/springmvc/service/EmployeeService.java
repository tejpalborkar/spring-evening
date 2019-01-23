package com.assimilate.springmvc.service;

import java.util.List;

import com.assimilate.springmvc.controllers.Emp;

public interface EmployeeService {

	Emp createEmployee(Emp employee);

	Integer updateEmployee(Emp employee);

	List<Emp> getAll();

	List<Emp> findEmployeeByName(String employeeName);

	int deleteEmployeeById(Integer id);

}
