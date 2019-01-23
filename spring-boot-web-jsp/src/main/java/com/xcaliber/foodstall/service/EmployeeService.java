package com.xcaliber.foodstall.service;

import java.util.List;

import com.xcaliber.foodstall.model.Emp;

public interface EmployeeService {

	List<Emp> getAll();

	void createEmployee(Emp employee);

}
