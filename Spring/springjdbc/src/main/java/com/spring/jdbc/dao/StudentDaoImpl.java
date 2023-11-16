package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao {

	private JdbcTemplate jdbcTemplate;

	@Override
	public int insert(Student student) {
		// TODO Auto-generated method stub

		// insert query

		String query = "insert into student(stdId,name,physics,chemistry,math) values(?,?,?,?,?)";
		
		int r = this.jdbcTemplate.update(query,student.getId() ,student.getName(),student.getPhysics(), student.getChemistry(), student.getMath());
		return r;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int change(Student student) {
		// TODO Auto-generated method stub
		//Updating data
		
		String query = "update student set name=?,physics=?,chemistry=?,math=? where stdId=?";
		
		int r = this.jdbcTemplate.update(query,student.getName(),student.getPhysics(), student.getChemistry(), student.getMath(), student.getId());
		
		
		return r;
	}

	@Override
	public int delete(int studentId) {
		// TODO Auto-generated method stub
		//deleting data
		
		String query = "delete from student where stdId=?";
		int result = this.jdbcTemplate.update(query,studentId);
		return result;
	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		//Selecting single student data
		
		String query = "select * from student where stdId=?";
		this.jdbcTemplate.queryForObject(query,rowMapper ,studentId);
		
		return null;
	}

}
