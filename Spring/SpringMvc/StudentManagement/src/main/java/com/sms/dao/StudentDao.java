package com.sms.dao;

import java.util.List;

import com.sms.entity.Student;

public interface StudentDao {

	public int save(Student student);

	public void update(int id);

	public Student getById(int id);
	
	public Student getByEmail(String email);

	public List<Student> getByClass(int classNo);

	public List<Student> getAll();
}
