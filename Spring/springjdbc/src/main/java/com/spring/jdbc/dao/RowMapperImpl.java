package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.entities.Student;

public class RowMapperImpl implements RowMapper<Student>{

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Student student = new Student();
		
		student.setId(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setPhysics(rs.getInt(3));
		student.setChemistry(rs.getInt(4));
		student.setMath(rs.getInt(5));
		
		
		return student;
	}

}
