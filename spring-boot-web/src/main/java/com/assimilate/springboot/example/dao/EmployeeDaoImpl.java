package com.assimilate.springboot.example.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.assimilate.springboot.example.model.Employee;

//@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Employee createEmployee(Employee e) {
		String query = "insert into emp99 (name, salary) values('" + e.getName() + "','" + e.getSalary() + "')";
		jdbcTemplate.update(query);
		return e;
	}

	public int updateEmployee(Employee e) {
		String query = "update emp99 set name='" + e.getName() + "',salary='" + e.getSalary() + "' where id='"
				+ e.getId() + "' ";
		return jdbcTemplate.update(query);
	}

	public List<Employee> getAll() {

		String query = "select * from emp99";
		List<Employee> employees = jdbcTemplate.query(query, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getInt("salary"));
				return emp;
			}

		});
		return employees;

	}

	public List<Employee> findEmployeeByName(String employeeName) {

		String query = "select * from emp99 where name='" + employeeName + "'";
		return jdbcTemplate.query(query, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getInt("salary"));
				return emp;
			}

		});

	}

	public int deleteEmployeeById(Integer id) {
		String query = "delete from emp99 where id='" + id + "' ";
		return jdbcTemplate.update(query);
	}

	@Override
	public Employee findEmployeeById(Integer employeeId) {

		String query = "select * from emp99 where id='" + employeeId + "' ";
		List<Employee> employees = jdbcTemplate.query(query, new RowMapper<Employee>() {
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getInt("salary"));
				return emp;
			}

		});
		return employees.get(0);
	}

}
