package com.blog.dto;

import java.util.List; 

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;



public class UserDto {
	
	@Autowired
	private ModelMapper modelMapper;
	
	private int id;

	@NotEmpty
	@Size(min = 4, message = "Username must be min of 4 characters")
	private String name;

	@Email(message = "Email address is not valid")

	private String email;

	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be min of 3 chars and maximum of 10 chars")
	private String password;

	@NotEmpty
	private String about;
	
//	private List<RoleDto> roles;

//	
//	public List<RoleDto> getRoles() {
//		return roles;
//	}
//	public void setRoles(List<RoleDto> roles) {
//		this.roles = roles;
//	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public UserDto(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
