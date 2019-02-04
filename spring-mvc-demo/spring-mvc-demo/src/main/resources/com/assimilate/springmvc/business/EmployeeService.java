package com.assimilate.springmvc.business;

import com.assimilate.springmvc.model.Employee;

public interface EmployeeService {

	public Employee login(String userName, String password);
}
