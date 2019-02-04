package com.assimilate.springdatajpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assimilate.springdatajpa.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByName(String employeeName);
	
	List<Employee> findBySalary(Integer salary);
	
	List<Employee> findByDesignation(String designation);

}
