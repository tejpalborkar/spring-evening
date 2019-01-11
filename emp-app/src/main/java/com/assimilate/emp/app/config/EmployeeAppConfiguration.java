package com.assimilate.emp.app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.assimilate.emp.app.model.Employee;

@Configuration
@ComponentScan(basePackages = "com.assimilate.emp.app")
public class EmployeeAppConfiguration {

	@Bean
	public Employee employeeBean() {
		Employee employe = new Employee();
		employe.setName("Tejal Borkr");
		employe.setMobile("909293864");
		return employe;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/assimilate_db");// change url
		dataSource.setUsername("root");// change userid
		dataSource.setPassword("root");// change pwd
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate(DataSource dataSource) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.setResultsMapCaseInsensitive(true);
		return jdbcTemplate;
	}

}
