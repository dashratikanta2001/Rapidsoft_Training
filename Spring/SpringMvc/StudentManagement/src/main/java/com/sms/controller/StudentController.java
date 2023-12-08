package com.sms.controller;

import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.dto.StudentDto;
import com.sms.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/create")
	public ResponseEntity<?> addNewStudent(@RequestBody StudentDto studentDto) {
		String msg;
		try {
			studentService.save(studentDto);
			msg = "Student created successfully";
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (ConstraintViolationException e) {
			// TODO: handle exception
			msg = "Email id already exist";
			return new ResponseEntity<String>(msg, HttpStatus.CONFLICT);

		} catch (Exception e) {
			// TODO: handle exception
			msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") int id) {
		String msg;
		StudentDto studentDto = studentService.getStudentById(id);
		try {
			if (studentDto != null) {
				return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);
			} else {
				msg = "No student details found";

				return new ResponseEntity<String>(msg, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception

			msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/class/{classNo}")
	public ResponseEntity<?> getStudentByClass(@PathVariable("classNo") int classNo) {
		String msg;

		List<StudentDto> studentByClass = studentService.getStudentByClass(classNo);

		try {
			if (studentByClass != null && !studentByClass.isEmpty()) {
				return new ResponseEntity<List<StudentDto>>(studentByClass, HttpStatus.FOUND);
			} else {
				msg = "No Student Found";
				return new ResponseEntity<String>("No Student Found", HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			// TODO: handle exception
			msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") int id ,@RequestBody StudentDto studentDto) {
		String msg;
		try {
			studentService.update(id,studentDto);
			msg = "Student details updated successfully.";
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			msg = e.getMessage();
			return new ResponseEntity<String>(msg, HttpStatus.BAD_REQUEST);
		}

	}

}
