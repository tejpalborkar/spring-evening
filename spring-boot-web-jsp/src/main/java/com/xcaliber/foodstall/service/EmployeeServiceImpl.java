package com.xcaliber.foodstall.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.xcaliber.foodstall.model.Emp;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<Emp> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createEmployee(Emp employee) {
		// TODO Auto-generated method stub
		
	}

}
