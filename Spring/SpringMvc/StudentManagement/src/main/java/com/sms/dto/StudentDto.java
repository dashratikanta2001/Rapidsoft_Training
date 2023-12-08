package com.sms.dto;

import java.util.Date;

import org.modelmapper.ModelMapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.sms.entity.Student;

@JsonInclude
public class StudentDto {

	private int id;

	private String name;

	private int classNo;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date dob;

	private String email;

	private String phoneNo;

	private String presentAddress;

	private String permanentAddress;

	private String bloodGroup;

	private Date admissionDate;

	private String fatherName;

	private String motherName;

	private String fatherPhoneNo;

	private String motherPhoneNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getClassNo() {
		return classNo;
	}

	public void setClassNo(int classNo) {
		this.classNo = classNo;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getFatherPhoneNo() {
		return fatherPhoneNo;
	}

	public void setFatherPhoneNo(String fatherPhoneNo) {
		this.fatherPhoneNo = fatherPhoneNo;
	}

	public String getMotherPhoneNo() {
		return motherPhoneNo;
	}

	public void setMotherPhoneNo(String motherPhoneNo) {
		this.motherPhoneNo = motherPhoneNo;
	}

	public StudentDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDto(int id, String name, int classNo, Date dob, String email, String phoneNo, String presentAddress,
			String permanentAddress, String bloodGroup, Date admissionDate, String fatherName, String motherName,
			String fatherPhoneNo, String motherPhoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.classNo = classNo;
		this.dob = dob;
		this.email = email;
		this.phoneNo = phoneNo;
		this.presentAddress = presentAddress;
		this.permanentAddress = permanentAddress;
		this.bloodGroup = bloodGroup;
		this.admissionDate = admissionDate;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.fatherPhoneNo = fatherPhoneNo;
		this.motherPhoneNo = motherPhoneNo;
	}
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public static StudentDto toStudentDto(Student student)
	{
//		StudentDto studentDto = new StudentDto();
//		studentDto.setId(student.getId());
//		studentDto.setName(student.getName());
//		studentDto.setClassNo(student.getClassNo());
//		studentDto.setDob(student.getDob());
//		studentDto.setEmail(student.getEmail());
//		studentDto.setPhoneNo(student.getPhoneNo());
//		studentDto.setPresentAddress(student.getPermanentAddress());
//		studentDto.setPermanentAddress(student.getPermanentAddress());
//		studentDto.setBloodGroup(student.getBloodGroup());	
//		studentDto.setAdmissionDate(student.getAdmissionDate());
//		studentDto.setFatherName(student.getFatherName());
//		studentDto.setMotherName(student.getMotherName());
//		studentDto.setFatherPhoneNo(student.getFatherPhoneNo());
//		studentDto.setMotherPhoneNo(student.getMotherPhoneNo());
//		
//		return studentDto;
		
		if (student!=null) {
			return modelMapper.map(student, StudentDto.class);			
		}
		else {
			return null;
		}
		
		
		
	}
	
	public static Student toStudent(StudentDto studentDto)
	{
//		Student student = new Student();
//		
//		student.setId(studentDto.getId());
//		student.setName(studentDto.getName());
//		student.setClassNo(studentDto.getClassNo());
//		student.setDob(studentDto.getDob());
//		student.setEmail(studentDto.getEmail());
//		student.setPhoneNo(studentDto.getPhoneNo());
//		student.setPresentAddress(studentDto.getPermanentAddress());
//		student.setPermanentAddress(studentDto.getPermanentAddress());
//		student.setBloodGroup(studentDto.getBloodGroup());
//		student.setAdmissionDate(studentDto.getAdmissionDate());
//		student.setFatherName(studentDto.getFatherName());
//		student.setMotherName(studentDto.getMotherName());
//		student.setFatherPhoneNo(studentDto.getFatherPhoneNo());
//		student.setMotherPhoneNo(studentDto.getMotherPhoneNo());
//		
//		return student;
		
		return modelMapper.map(studentDto, Student.class);
	}
	
}
