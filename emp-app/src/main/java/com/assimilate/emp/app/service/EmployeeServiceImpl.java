package com.assimilate.emp.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assimilate.emp.app.dao.EmployeeDao;
import com.assimilate.emp.app.model.Employee;

@Component
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public Employee createEmployee(Employee employee) {

		return employeeDao.createEmployee(employee);
	}

	public Integer updateEmployee(Employee employee) {
		return employeeDao.updateEmployee(employee);
	}

	public List<Employee> getAll() {
		return employeeDao.getAll();
	}

	public List<Employee> findEmployeeByName(String employeeName) {
		return employeeDao.findEmployeeByName(employeeName);
	}

	public int deleteEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return employeeDao.deleteEmployeeById(id);
	}

}
