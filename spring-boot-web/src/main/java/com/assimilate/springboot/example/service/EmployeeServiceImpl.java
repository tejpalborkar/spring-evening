package com.assimilate.springboot.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assimilate.springboot.example.dao.EmployeeDao;
import com.assimilate.springboot.example.model.Employee;

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

	@Override
	public Employee findEmployeeById(Integer employeeId) {
		// TODO Auto-generated method stub
		return employeeDao.findEmployeeById(employeeId);
	}

}
