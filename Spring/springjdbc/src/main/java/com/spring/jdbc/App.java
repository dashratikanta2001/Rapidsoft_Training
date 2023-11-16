package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entities.Student;

public class App {
	
	/*
	 * //XML Bean file setup open static ApplicationContext context = new
	 * ClassPathXmlApplicationContext("com/spring/jdbc/config.xml"); static
	 * StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
	 * //XML Bean file setup close
	 */	
	
	
	//Without XML file Bean setup
	static ApplicationContext context = new AnnotationConfigApplicationContext(jdbcConfig.class);
	static StudentDao studentDao = context.getBean("studentDao", StudentDao.class);
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		System.out.println("Hello World!");

//		// old method
//		addStudentOldMethod();
//
//		// new method
//		addStudent();
//
//		// update
//		updateStudent();

//		// delete
//		deleteStudent();
//
//		// selectByid
//		selectStudentById();

		// select all
		selectAllStudent();

	}

	private static void addStudentOldMethod() {
		// TODO Auto-generated method stub

		// One Way of database connection //Spring jdbc => jdbcTemplate

		ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");
		JdbcTemplate template = context.getBean("jdbcTemplate", JdbcTemplate.class);

		// insert query

		String query = "insert into student(stdId,name,physics,chemistry,math) values(?,?,?,?,?)";

		// fire query

		int result = template.update(query, 1111, "Test", 90, 90, 90);

		System.out.println("No of record inserted... " + result);

	}

	private static void addStudent() {
		// TODO Auto-generated method stub

		// Another method
		// add Student

		Student student = new Student();
		student.setId(111);
		student.setName("Rati");
		student.setPhysics(99);
		student.setChemistry(99);
		student.setMath(99);
		int result = studentDao.insert(student);

		System.out.println("Student added " + result);

	}

	private static void updateStudent() {
		// TODO Auto-generated method stub

		// update student

		Student student = new Student();

		student.setId(111);
		student.setName("Ratikanta Dash");
		student.setPhysics(90);
		student.setChemistry(90);
		student.setMath(90);

		int result = studentDao.change(student);
		System.out.println("Data changed " + result);

	}

	private static void deleteStudent() {
		// TODO Auto-generated method stub

//		delete student

		int result = studentDao.delete(111);

		System.out.println("Student deleted..." + result);

	}

	private static void selectStudentById() {
		// TODO Auto-generated method stub

		// Select single data

		Student student = studentDao.getStudent(11);
		System.out.println(student);

	}

	private static void selectAllStudent() {
		// TODO Auto-generated method stub

		// selecting all students

		List<Student> students = studentDao.getAllStudent();

		for (Student astudent : students) {
			System.out.println(astudent);
		}

	}

}
