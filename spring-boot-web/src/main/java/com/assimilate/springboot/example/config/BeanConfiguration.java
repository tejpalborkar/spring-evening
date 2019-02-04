package com.assimilate.springboot.example.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class BeanConfiguration extends WebMvcConfigurerAdapter {
	@Bean(name = "viewResolver")

	public InternalResourceViewResolver getViewResolver() {

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}
	
/*	
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
	}*/
	
	
	@Bean
	@Autowired
	public LocalSessionFactoryBean sessionFactory(DataSource datasource) {
		System.out.println("Building local session factory bean..");
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(datasource);
		
		//the root package where all entity classes are present
		sessionFactory.setPackagesToScan("com");

		Properties hibernateProperties = new Properties();
/*
		hibernateProperties.getProperty("spring.jpa.hibernate.ddl-auto");
		hibernateProperties.getProperty("spring.jpa.show-sql");
		hibernateProperties.getProperty("spring.jpa.properties.hibernate.dialect");
*/
//	    hibernateProperties.put("hibernate.dialect", HIBERNATE_DIALECT);
//	    hibernateProperties.put("hibernate.show_sql", true);
//	    hibernateProperties.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		
		hibernateProperties.put("spring.jpa.properties.hibernate.id.new_generator_mappings", false);
		hibernateProperties.put("show_sql", true);
		
		sessionFactory.setHibernateProperties(hibernateProperties);
		
		System.out.println("Session factory bean created..");
		return sessionFactory;
	}
	
	
/*	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}
*/
}
