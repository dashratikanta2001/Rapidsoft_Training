package com.sms.controller;

import javax.validation.Valid; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.sms.dto.StudentDto;
import com.sms.response.Response;
import com.sms.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	

	@PostMapping("/add")
	public ResponseEntity<?> addStudent(@Valid @RequestBody StudentDto studentDto) {

		Response<?> saveStudent = studentService.saveStudent(studentDto);

//		if (saveStudent.getStatus() == HttpStatus.OK.value()) {
//			return new ResponseEntity<>(saveStudent, HttpStatus.OK);
//		}

		return new ResponseEntity<>(saveStudent, HttpStatus.CREATED);

	}
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateStudent(@RequestBody StudentDto studentDto, @PathVariable int id) {
		
		Response<?> Student = studentService.updateStudent(id, studentDto);
		
//		if (Student.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(Student, HttpStatus.OK);
//		}
		
//		return new ResponseEntity<>(Student, HttpStatus.BAD_REQUEST);
		
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable Integer id)
	{
		try {
//		Response<?> student = studentService.getStudentById(id);
			Response<?> student = studentService.getStudentById(id);
//		if (student.getStatus() ==HttpStatus.OK.value()) {
//			return new ResponseEntity<>(student, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(student, HttpStatus.BAD_REQUEST);
			
			return new ResponseEntity<>(student, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new MethodArgumentTypeMismatchException(null, null, null, null, e.getCause());
		}
		
	}
	
	@GetMapping("/email/{email}")
	public ResponseEntity<?> getStudentByEmail( @PathVariable String email)
	{
		Response<?> student = studentService.getStudentByEmail(email);
//		if (student.getStatus() ==HttpStatus.OK.value()) {
//			System.out.println("Student found = "+student.getMessage());
			return new ResponseEntity<>(student, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(student, HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/class/{classNo}")
	public ResponseEntity<?> getStudentByEmail(@PathVariable Integer classNo)
	{
		Response<?> student = studentService.getStudentByClass(classNo);
//		if (student.getStatus() ==HttpStatus.OK.value()) {
//			System.out.println("Student found = "+student.getMessage());
			return new ResponseEntity<>(student, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(student, HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteStudent(@PathVariable Integer id)
	{
		Response<?> student = studentService.deleteStudent(id);
//		if (student.getStatus() ==HttpStatus.OK.value()) {
//			System.out.println("Student found = "+student.getMessage());
			return new ResponseEntity<>(student, HttpStatus.OK);
//		}
//		return new ResponseEntity<>(student, HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<?> getAllStudents() {
		Response<?> students = studentService.getStudents();

//		if (students.getStatus() == HttpStatus.OK.value()) {
			return new ResponseEntity<>(students, HttpStatus.OK);
//		}

//		return new ResponseEntity<>(students, HttpStatus.BAD_REQUEST);

	}

}
