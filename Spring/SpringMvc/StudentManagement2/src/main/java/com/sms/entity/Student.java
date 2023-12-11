package com.sms.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "class", nullable = true)
	private int classNo;
	
	@Column(name = "dob", nullable = false)
	private Date dob;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "phone_no", nullable = false)
	private String phoneNo;
	
	@Column(name = "present_address", nullable = false)
	private String presentAddress;
	
	@Column(name = "permanent_address")
	private String permanentAddress;
	
	@Column(name = "blood_group")
	private String bloodGroup;
	
	@Column(name = "admission_date")
	private Date admissionDate;
	
	@Column(name = "father_name")
	private String fatherName;
	
	@Column(name = "mother_name")
	private String motherName;
	
	@Column(name = "father_phone_no")
	private String fatherPhoneNo;
	
	@Column(name = "mother_phone_no")
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

	public Student(int id, String name, int classNo, Date dob, String email, String phoneNo, String presentAddress,
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

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
