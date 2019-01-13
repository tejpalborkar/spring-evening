package com.assimilate.emp.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.assimilate.emp.app.model.Employee;

@Component
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public Employee createEmployee(Employee e) {
		String query = "insert into employee values('" + e.getId() + "','" + e.getName() + "','" + e.getSalary() + "')";
		jdbcTemplate.update(query);
		return e;
	}

	public int updateEmployee(Employee e) {
		String query = "update employee set name='" + e.getName() + "',salary='" + e.getSalary() + "' where id='"
				+ e.getId() + "' ";
		return jdbcTemplate.update(query);
	}

	public List<Employee> getAll() {

		String query = "select * from employee";
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

		String query = "select * from employee where name='" + employeeName + "'";
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
		String query = "delete from employee where id='" + id + "' ";
		return jdbcTemplate.update(query);
	}

}
