package com.assimilate.springmvc.business;

import com.assimilate.springmvc.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public Employee login(String userName, String password) {

		if (userName.equals("tejpal") && password.equals("1234")) {
			Employee e = new Employee();
			e.setFirstName("Tejpal");
			e.setLastName("Borkar");
			return e;
		}

		return null;
	}

}
