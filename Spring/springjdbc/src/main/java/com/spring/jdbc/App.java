package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Hello World!");

		/*
		 * //One Way of database connection //Spring jdbc => jdbcTemplate
		 * 
		 * ApplicationContext context = new
		 * ClassPathXmlApplicationContext("com/spring/jdbc/config.xml"); JdbcTemplate
		 * template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		 * 
		 * //insert query
		 * 
		 * String query =
		 * "insert into student(stdId,name,physics,chemistry,math) values(?,?,?,?,?)";
		 * 
		 * //fire query
		 * 
		 * int result = template.update(query,11,"Test",90,90,90);
		 * 
		 * System.out.println("No of record inserted... "+result);
		 */

		// Another method

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		// add Student

		/*
		 * Student student = new Student(); student.setId(111); student.setName("Rati");
		 * student.setPhysics(99); student.setChemistry(99); student.setMath(99); int
		 * result = studentDao.insert(student);
		 * 
		 * System.out.println("Student added " + result);
		 */

		// update student

		/*
		 * Student student = new Student();
		 * 
		 * student.setId(111); student.setName("Ratikanta Dash");
		 * student.setPhysics(90); student.setChemistry(90); student.setMath(90);
		 * 
		 * int result = studentDao.change(student); System.out.println("Data changed " +
		 * result);
		 */
		
//		delete student
				
		int result = studentDao.delete(111);
		
		System.out.println("Student deleted..."+result);
		
		
	}
}
