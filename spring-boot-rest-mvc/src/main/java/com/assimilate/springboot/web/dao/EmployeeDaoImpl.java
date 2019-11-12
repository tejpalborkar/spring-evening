package com.assimilate.springboot.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.assimilate.springboot.web.models.Employee;

//@Component
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Employee> getAllEmployees() {
		System.out.println("Executing getAllEmployees in Dao");

		String query = "select * from employees";

		List<Employee> employees = jdbcTemplate.query(query, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setFirstName(rs.getString("first_name"));
				emp.setId(rs.getInt("id"));
				emp.setLastName(rs.getString("last_name"));
				emp.setYearlyIncome(rs.getInt("yearly_income"));
				return emp;
			}

		});

		return employees;
	}

	@Override
	public int save(Employee employee) {
		String sqlQuery = "insert into employees(first_name, last_name, yearly_income) " + "values (?, ?, ?)";

		int i = jdbcTemplate.update(sqlQuery, employee.getFirstName(), employee.getLastName(),
				employee.getYearlyIncome());
		return i;
	}

	@Override
	public Employee findById(int id) {

		System.out.println("Executing getAllEmployees in Dao");

		String query = "select * from employees where id ='" + id + "'";

		List<Employee> employees = jdbcTemplate.query(query, new RowMapper<Employee>() {

			@Override
			public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
				Employee emp = new Employee();
				emp.setFirstName(rs.getString("first_name"));
				emp.setId(rs.getInt("id"));
				emp.setLastName(rs.getString("last_name"));
				emp.setYearlyIncome(rs.getInt("yearly_income"));
				return emp;
			}

		});

		if (employees.isEmpty()) {
			return null;
		} else
			return employees.get(0);
	}

	@Override
	public void delete(int id) {
		String sqlQuery = "delete from employees where id = ?";
		   jdbcTemplate.update(sqlQuery, id) ;
		   System.out.println("Deleted");
		
	}

	@Override
	public void updateEmployee(Employee employee) {
		String sqlQuery = "update employees set first_name=?, last_name =?, yearly_income=? where id=?";

		int i = jdbcTemplate.update(sqlQuery, employee.getFirstName(), employee.getLastName(),
				employee.getYearlyIncome(),employee.getId());
		System.out.println();
	}
}
