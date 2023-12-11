package com.sms.service;

import java.util.List;

import com.sms.dto.StudentDto;
import com.sms.response.Response;

public interface StudentService{
	
	
	Response<?> saveStudent(StudentDto studentDto);
	Response<?> updateStudent(int id, StudentDto studentDto);
	
//	List<StudentDto> getallStudent(Student student);
	Response<?> deleteStudent(int id);
	
	Response<?> getStudentById(int id);
	
	Response<?> getStudentByEmail(String email);
	
	Response<?> getStudentByClass(int classNo);
	
	Response<?> getStudents();
	
	
}

/*
 * import java.util.ArrayList; import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.sms.dao.StudentDao; import com.sms.dto.StudentDto; import
 * com.sms.entity.Student;
 * 
 * @Service public class StudentService {
 * 
 * @Autowired private StudentDao studentDao;
 * 
 * public void save(StudentDto studentDto) {
 * 
 * if (studentDao.getByEmail(studentDto.getEmail()) ==null) { Student student =
 * StudentDto.toStudent(studentDto); this.studentDao.save(student); } else {
 * System.out.println("Email Id already exist."); }
 * 
 * 
 * }
 * 
 * public StudentDto getStudentById(int id) { StudentDto studentDto =
 * StudentDto.toStudentDto(studentDao.getById(id)); return studentDto;
 * 
 * }
 * 
 * public List<StudentDto> getStudentByClass(int classNo) { List<Student>
 * studentByClass = studentDao.getByClass(classNo); List<StudentDto> studentList
 * = new ArrayList<>();
 * 
 * for (Student student : studentByClass) {
 * studentList.add(StudentDto.toStudentDto(student)); }
 * 
 * return studentList;
 * 
 * }
 * 
 * public void update(int id ,StudentDto studentDto) { // TODO Auto-generated
 * method stub
 * 
 * studentDao.update(id, studentDto); } }
 */
