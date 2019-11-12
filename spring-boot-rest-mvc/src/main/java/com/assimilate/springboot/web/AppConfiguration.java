package com.assimilate.springboot.web;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfiguration {

	@Bean
	public DataSource dataSource() {
		System.out.println("Creating datasource");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		// MySQL database we are using
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/assimilate_db");// change url
		dataSource.setUsername("tejpal");// change userid
		dataSource.setPassword("tejpal");// change pwd
		return dataSource;
	}

	@Bean
	public JdbcTemplate jdbcTemplate() {
		System.out.println("Creating jdbc template bean");
		JdbcTemplate jdbcTemplate = new JdbcTemplate();
		jdbcTemplate.setDataSource(dataSource());
		return jdbcTemplate;
	}

}
