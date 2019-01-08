package com.assimilate.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveEmployee(Employee e) {
		String query = "insert into employee values('" + e.getId() + "','" + e.getName() + "','" + e.getSalary() + "')";
		return jdbcTemplate.update(query);
	}

	public int updateEmployee(Employee e) {
		String query = "update employee set name='" + e.getName() + "',salary='" + e.getSalary() + "' where id='"
				+ e.getId() + "' ";
		return jdbcTemplate.update(query);
	}

	public int deleteEmployee(Employee e) {
		String query = "delete from employee where id='" + e.getId() + "' ";
		return jdbcTemplate.update(query);
	}

	public List<Employee> getEmployeesById(int id) {
		String query = "select * from employee where id=" + id + " ";
		return jdbcTemplate.query(query, new org.springframework.jdbc.core.RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getFloat("salary"));
				return emp;
			}

		});

	}

	public List<Employee> getEmployeesByName(String name) {
		String query = "select * from employee where name='" + name + "'";
		return jdbcTemplate.query(query, new org.springframework.jdbc.core.RowMapper<Employee>() {
			@Override
			public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setSalary(rs.getFloat("salary"));
				return emp;
			}

		});
	}

}
