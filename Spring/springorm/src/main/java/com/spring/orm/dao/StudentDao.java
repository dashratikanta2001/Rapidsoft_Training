package com.spring.orm.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.entities.Student;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	// save student
	@Transactional
	public int insert(Student student) {
		// Insert

		Integer i = (Integer) this.hibernateTemplate.save(student);
		return i;
	}

	// get single data
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub

		Student student = this.hibernateTemplate.get(Student.class, studentId);

		return student;
	}

//	get all student

	public List<Student> getAllStudents() {
		List<Student> student = this.hibernateTemplate.loadAll(Student.class);

		return student;
	}

	// delete student
	@Transactional
	public void deleteStudent(int studentId) {
		Student student = this.hibernateTemplate.get(Student.class, studentId);

		this.hibernateTemplate.delete(student);
	}

	// updating student data
	@Transactional
	public boolean updateStudent(Student student) {
		Student student2 = getStudent(student.getStudentId());
		if (student2 != null) {
			if (!student.getStudentName().isEmpty())
				student2.setStudentName(student.getStudentName());
			if (!student.getStudentCity().isEmpty())
				student2.setStudentCity(student.getStudentCity());

			System.out.println(
					student2.getStudentId() + " : " + student2.getStudentName() + " : " + student2.getStudentCity());

			this.hibernateTemplate.update(student2);
			return true;
		}
		return false;
	}

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

}
