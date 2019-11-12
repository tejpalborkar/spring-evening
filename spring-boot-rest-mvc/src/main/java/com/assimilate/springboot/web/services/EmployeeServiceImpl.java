package com.assimilate.springboot.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assimilate.springboot.web.dao.EmployeeDao;
import com.assimilate.springboot.web.models.Employee;

//@Component

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getEmployees() {
		System.out.println("Executing getEmployees in EmployeeService");
		return employeeDao.getAllEmployees();
	}

	@Override
	public int createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.save(employee);
	}

	@Override
	public Employee getEmployeeById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.findById(id);
	}

	@Override
	public void delete(int id) {
		 employeeDao.delete(id);
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		
		employeeDao.updateEmployee(employee);
		
	}

}
