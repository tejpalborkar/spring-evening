package com.assimilate.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assimilate.springmvc.controllers.Emp;
import com.assimilate.springmvc.controllers.EmpDao;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmpDao employeeDao;

	@Override
	public Emp createEmployee(Emp employee) {
		employeeDao.save(employee);
		return employee;
	}

	public Integer updateEmployee(Emp employee) {
		return employeeDao.update(employee);
	}

	public List<Emp> getAll() {
		return employeeDao.getEmployees();
	}

	public List<Emp> findEmployeeByName(String employeeName) {
		// return employeeDao.findEmployeeByName(employeeName);
		return null;
	}

	@Override
	public int deleteEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
