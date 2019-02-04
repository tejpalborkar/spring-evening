package com.assimilate.springboot.example.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.assimilate.springboot.example.model.Employee;

@Repository
public class EmployeeDaoHibernateImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Employee createEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		session.save(employee);
		session.beginTransaction().commit();

		closeSession(session);
		return employee;
	}

	private void closeSession(Session session) {
		session.close();

	}

	@Override
	public int updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Employee employeeFromDb = findEmployeeById(employee.getId());

		employeeFromDb.setDesignation(employee.getDesignation());
		employeeFromDb.setName(employee.getName());
		employeeFromDb.setSalary(employee.getSalary());
		session.update(employee);
		session.beginTransaction().commit();
		closeSession(session);
		return 0;
	}

	@Override
	public List<Employee> getAll() {
		Session session = sessionFactory.openSession();
		List<Employee> employees = session.createCriteria(Employee.class).list();
		closeSession(session);
		return employees;
	}

	@Override
	public List<Employee> findEmployeeByName(String employeeName) {

		return null;
	}

	@Override
	public int deleteEmployeeById(Integer id) {
		Session session = sessionFactory.openSession();
		Employee employeeFromDb = session.get(Employee.class, id);
		session.delete(employeeFromDb);
		session.beginTransaction().commit();
		closeSession(session);
		return 0;
	}

	@Override
	public Employee findEmployeeById(Integer employeeId) {
		Session session = sessionFactory.openSession();
		Employee employee = session.get(Employee.class, employeeId);

		closeSession(session);
		return employee;

	}

}
