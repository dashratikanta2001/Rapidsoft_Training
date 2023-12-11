package com.sms.serviceImpl;

import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sms.dao.StudentDao;
import com.sms.dto.StudentDto;
import com.sms.entity.Student;
import com.sms.exception.DataNotFoundException;
import com.sms.response.Response;
import com.sms.response.Response2;
import com.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Override
	public Response<?> saveStudent(StudentDto studentDto) {
		// TODO Auto-generated method stub

		// Save the student details....
		Integer saveStudent;
//		if (studentDto.getId() == null) {
			Student validator = studentDao.getStudentByEmail(studentDto.getEmail());
			if (validator == null) {
				Student student = StudentDto.toStudent(studentDto);
				saveStudent = studentDao.saveStudent(student);
				if (saveStudent > 0) {
					return new Response<>("Student registered successfully", student, HttpStatus.OK.value());
				} else {
					return new Response<>("Something went wrong on server. Please Try again later", null,
							HttpStatus.BAD_REQUEST.value());

				}
			} else {
				return new Response<>("Email id already exist", null, HttpStatus.BAD_REQUEST.value());
			}

//		}

		// Update the student details ...........

//		else {
//			Student student = studentDao.getStudentById(studentDto.getId());
//
//			student.setClassNo(studentDto.getClassNo());
//			student.setDob(studentDto.getDob());
//			student.setPhoneNo(studentDto.getPhoneNo());
//			student.setPresentAddress(studentDto.getPresentAddress());
//			student.setPermanentAddress(studentDto.getPermanentAddress());
//			student.setBloodGroup(studentDto.getBloodGroup());
//			student.setFatherName(studentDto.getFatherName());
//			student.setMotherName(studentDto.getMotherName());
//			student.setFatherPhoneNo(studentDto.getFatherPhoneNo());
//			student.setMotherPhoneNo(studentDto.getMotherPhoneNo());
//
//			Integer updateStudent = studentDao.updateStudent(student);
//			if (updateStudent > 0) {
//				return new Response<>("Student details updated successfully", student, HttpStatus.OK.value());
//			} else {
//				return new Response<>("Student details not updated", student, HttpStatus.BAD_REQUEST.value());
//
//			}
//
//		}
	}
	
	
	@Override
	public Response<?> updateStudent(int id, StudentDto studentDto) {
		// TODO Auto-generated method stub
		
		Student student = studentDao.getStudentById(id);
		if (student !=null) {
			student.setClassNo(studentDto.getClassNo());
			student.setDob(studentDto.getDob());
			student.setPhoneNo(studentDto.getPhoneNo());
			student.setPresentAddress(studentDto.getPresentAddress());
			student.setPermanentAddress(studentDto.getPermanentAddress());
			student.setBloodGroup(studentDto.getBloodGroup());
			student.setFatherName(studentDto.getFatherName());
			student.setMotherName(studentDto.getMotherName());
			student.setFatherPhoneNo(studentDto.getFatherPhoneNo());
			student.setMotherPhoneNo(studentDto.getMotherPhoneNo());

			Integer updateStudent = studentDao.updateStudent(student);
			if (updateStudent > 0) {
				return new Response<>("Student details updated successfully", student, HttpStatus.OK.value());
			} else {
				return new Response<>("Student details not updated", student, HttpStatus.BAD_REQUEST.value());

			}
		}
		
		return new Response<>("Student not found for id: "+id, student, HttpStatus.BAD_REQUEST.value());
	}
	


	@Override
	public Response2<?> getStudentById(int id)  {
		// TODO Auto-generated method stub

		Student student = studentDao.getStudentById(id);
//		if (student != null) {
//			return new Response<>("Student details", student, HttpStatus.OK.value());
//		}
//		return new Response<>("Student not found", null, HttpStatus.BAD_REQUEST.value());
		
		try {
			if(student !=null)
			{
				return new Response2<>("success","Student Found", student);
			}
			else {
				throw new DataNotFoundException("Student not found");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiceException("An error occure"+e);
		}
	}

	@Override
	public Response<?> getStudentByEmail(String email) {
		// TODO Auto-generated method stub
		Student student = studentDao.getStudentByEmail(email);
		if (student != null) {
			return new Response<>("Student details", student, HttpStatus.OK.value());
		}
		return new Response<>("Student not found", null, HttpStatus.BAD_REQUEST.value());
	}

	@Override
	public Response<?> getStudentByClass(int classNo) {
		// TODO Auto-generated method stub
		List<Student> students = studentDao.getAllStudentByClass(classNo);
		if (!students.isEmpty()) {
			return new Response<>("Student details", students, HttpStatus.OK.value());
		}
		return new Response<>("No records found", null, HttpStatus.BAD_REQUEST.value());
	}

	@Override
	public Response<?> getStudents() {
		// TODO Auto-generated method stub

		List<Student> students = studentDao.getAllStudents();
		if (!students.isEmpty()) {
			return new Response<>("Student details", students, HttpStatus.OK.value());
		}
		return new Response<>("No records found", null, HttpStatus.BAD_REQUEST.value());
	}

	@Override
	public Response<?> deleteStudent(int id) {
		// TODO Auto-generated method stub
		
		Student student = studentDao.getStudentById(id);
		if (student != null) {
			if(studentDao.deleteStudent(student) >0)
			{
				return new Response<>("Student deleted successfully", null, HttpStatus.OK.value());
			}
			else {
				return new Response<>("Student not deleted", null, HttpStatus.BAD_REQUEST.value());
			}
		}
		
		return new Response<>("Student Not found for Id: "+id, null, HttpStatus.BAD_REQUEST.value());
	}



}
