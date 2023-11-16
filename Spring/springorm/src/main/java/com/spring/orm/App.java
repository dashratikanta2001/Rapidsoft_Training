package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.dao.StudentDao;
import com.spring.orm.entities.Student;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");

		StudentDao studentDao = context.getBean("studentDao", StudentDao.class);

		/*
		 * Student student = new Student(1212,"Ratikanta Dash","BBSR");
		 * 
		 * int r = studentDao.insert(student);
		 * 
		 * System.out.println( "Done "+r );
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		boolean go = true;
		while (go) {
			System.out.println("PRESS 1 for add new student");
			System.out.println("PRESS 2 for display all student");
			System.out.println("PRESS 3 for get details of single student");
			System.out.println("PRESS 4 for delete student");
			System.out.println("PRESS 5 for update student");
			System.out.println("PRESS 6 for exit");

			try {

				int input = Integer.parseInt(br.readLine());

				switch (input) {
				case 1:
					// Add a new Student

					Student s = new Student();

					System.out.println("Enter id:");
					s.setStudentId(Integer.parseInt(br.readLine()));

					System.out.println("Enter name:");
					s.setStudentName(br.readLine());

					System.out.println("Enter city:");
					s.setStudentCity(br.readLine());

					int result = studentDao.insert(s);

					if (result == s.getStudentId())
						System.out.println("Student data inserted successfully");
					else
						System.out.println("Student data does not inserted");

					break;
				case 2:
					// Display all student

					List<Student> allStudents = studentDao.getAllStudents();

					for (Student student : allStudents) {
						System.err.println("____________________________________________\nId: " + student.getStudentId()+" Name: " + student.getStudentName()+" City: " + student.getStudentCity());
					}

					break;
				case 3:
					// get single student data
					System.out.println("Enter Student Id");
					Student student = studentDao.getStudent(Integer.parseInt(br.readLine()));

					System.out.println("___________________________________________");
					System.out.println("Id:" + student.getStudentId());
					System.err.println("Name: " + student.getStudentName());
					System.err.println("City: " + student.getStudentCity());
					System.err.println("____________________________________________");

					break;
				case 4:
					// delete student
					System.out.println("Enter Student Id");
					studentDao.deleteStudent(Integer.parseInt(br.readLine()));
					System.out.println("Student deleted successfully!!!");
					break;
				case 5:
					// update student

					Student s1 = new Student();
					System.out.println("Enter Student Id");
					int id = Integer.parseInt(br.readLine());
					s1.setStudentId(id);

					System.out.println("Enter Name");
					s1.setStudentName(br.readLine());

					System.out.println("Enter city");
					s1.setStudentCity(br.readLine());

					if (studentDao.updateStudent(s1))

						System.out.println("Data updated successfully");
					else
						System.out.println("Data does not update");
					break;
				case 6:
					go = false;
					break;

				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Invalid input Try with another one!!!");
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
		}

		System.out.println("Thank you for using my application");
		System.out.println("See you soon");

	}
}
