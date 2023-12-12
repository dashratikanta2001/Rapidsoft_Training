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
			Student validator = studentDao.getStudentByEmail(studentDto.getEmail());
			try {
				if (validator == null) {
					Student student = StudentDto.toStudent(studentDto);
					saveStudent = studentDao.saveStudent(student);
					if (saveStudent > 0) {
						return new Response<>(true, HttpStatus.OK.value(), "Student added successfully", student);
//						return new Response<>("Student registered successfully", student, HttpStatus.OK.value());
					} else {
//						return new Response<>("Something went wrong on server. Please Try again later", null,HttpStatus.BAD_REQUEST.value());
						throw new ServiceException("Something went wrong on server. Please Try again later");
					}
				}
				else {
					throw new ServiceException("Email id already exist");
				}
			} catch (Exception e) {
				// TODO: handle exception
				throw new ServiceException(e.getMessage());
			}
//			if (validator == null) {
//				Student student = StudentDto.toStudent(studentDto);
//				saveStudent = studentDao.saveStudent(student);
//				if (saveStudent > 0) {
//					return new Response<>(true, HttpStatus.OK.value(), "Student added successfully", student);
////					return new Response<>("Student registered successfully", student, HttpStatus.OK.value());
//				} else {
////					return new Response<>("Something went wrong on server. Please Try again later", null,HttpStatus.BAD_REQUEST.value());
//
//				}
//			} else {
////				return new Response<>("Email id already exist", null, HttpStatus.BAD_REQUEST.value());
//			}

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
		
		try {
			
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
//					return new Response<>("Student details updated successfully", student, HttpStatus.OK.value());
					return new Response<>(true, HttpStatus.OK.value(), "Student details updated successfully", student);
				} else {
//					return new Response<>("Student details not updated", student, HttpStatus.BAD_REQUEST.value());
					throw new ServiceException("Student details not updated");
				}
			}
			else {
				throw new DataNotFoundException("Student not found for id: "+id);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiceException(e.getMessage());
		}
		
		
//		if (student !=null) {
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
//		}
//		
//		return new Response<>("Student not found for id: "+id, student, HttpStatus.BAD_REQUEST.value());
	}
	


	@Override
	public Response<?> getStudentById(int id)  {
		// TODO Auto-generated method stub
		Student student = studentDao.getStudentById(id);
		try {
			if (student != null) {
				return new Response<>(true,HttpStatus.OK.value(), "Student details", student);
			}
			else {
				throw new DataNotFoundException("No student found with Id: "+id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiceException(e.getMessage());
		}

//		return new Response<>("Student not found", null, HttpStatus.BAD_REQUEST.value());
		
	}

	@Override
	public Response<?> getStudentByEmail(String email) {
		// TODO Auto-generated method stub
		Student student = studentDao.getStudentByEmail(email);
		try {
			if (student != null) {
				return new Response<>(true,HttpStatus.OK.value(), "Student details", student);
			}
			else {
				throw new DataNotFoundException("No student found with Email: "+email);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public Response<?> getStudentByClass(int classNo) {
		// TODO Auto-generated method stub
		List<Student> students = studentDao.getAllStudentByClass(classNo);
		try {
			if (!students.isEmpty()) {
				return new Response<>(true,HttpStatus.OK.value(), "Student details", students);
			}
			else {
				throw new DataNotFoundException("No student found with class: "+classNo);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public Response<?> getStudents() {
		// TODO Auto-generated method stub

		List<Student> students = studentDao.getAllStudents();
		try {
			if (!students.isEmpty()) {
				return new Response<>(true,HttpStatus.OK.value(), "Student details", students);
			}
			else {
				throw new DataNotFoundException("No Record Found");
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiceException(e.getMessage());
		}
	}

	@Override
	public Response<?> deleteStudent(int id) {
		// TODO Auto-generated method stub
		
		Student student = studentDao.getStudentById(id);
		try {
			if (student != null) {
				if(studentDao.deleteStudent(student) >0)
				{
					return new Response<>(true,HttpStatus.OK.value(), "Student deteted successfully", null);
				}
				else {
					throw new ServiceException("Student not deleted.");
				}
			}
			else {
				throw new DataNotFoundException("Student Not found for Id: "+id);
			}
		} catch (Exception e) {
			// TODO: handle exception
			throw new ServiceException(e.getMessage());
		}
		
//		if (student != null) {
//			if(studentDao.deleteStudent(student) >0)
//			{
//				return new Response<>("Student deleted successfully", null, HttpStatus.OK.value());
//			}
//			else {
//				return new Response<>("Student not deleted", null, HttpStatus.BAD_REQUEST.value());
//			}
//		}
//		
//		return new Response<>("Student Not found for Id: "+id, null, HttpStatus.BAD_REQUEST.value());
	}



}
