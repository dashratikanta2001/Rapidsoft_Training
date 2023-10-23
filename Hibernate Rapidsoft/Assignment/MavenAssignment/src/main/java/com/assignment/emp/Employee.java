//Assignment Today:
//i) Write code to update, delete, get by id and get all  employee data in the existing code.

package com.assignment.emp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AsEmployee")
public class Employee {

	@Id
	private int empId;
	private String empName;
	private String designation;
	private String phoneNo;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, String designation, String phoneNo) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.designation = designation;
		this.phoneNo = phoneNo;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
