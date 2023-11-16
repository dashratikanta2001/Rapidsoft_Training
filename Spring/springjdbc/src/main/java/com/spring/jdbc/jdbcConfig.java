package com.spring.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
//for autowiring
@ComponentScan(basePackages = "com.spring.jdbc.dao")
public class jdbcConfig {

	@Bean("ds")
	public DataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();

		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/ratiTest");
		ds.setUsername("root");
		ds.setPassword("Admin@123");

		return ds;
	}

	@Bean("jdbcTemplate")
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate();

		jdbcTemplate.setDataSource(getDataSource());

		return jdbcTemplate;
	}
	//for auto wiring remove the below method
//	
//	@Bean("studentDao")
//	public StudentDao getStudentDao()
//	{
//		StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
//		
//		studentDaoImpl.setJdbcTemplate(getTemplate());
//		
//		return studentDaoImpl;
//	}

}
