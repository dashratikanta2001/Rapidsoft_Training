package com.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assessment.entity.User;
import com.assessment.service.UserService;

@Controller
public class AdminController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("/admin-dashboard")
	public String adminHome(Model m)
	{
		m.addAttribute("title","Admin: Dashboard");
		return "admin-home";
	}
	
	@RequestMapping("/add-question")
	public String addQuestion(Model m)
	{
		m.addAttribute("title", "Add Question");
		return "add-question";
	}
	
	@RequestMapping("/add-user")
	public String addUser(Model m)
	{
		m.addAttribute("title", "Add Student");
		return "add-user";
	}
	
	@RequestMapping(path = "/add-user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute ("user") User user) {
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getRollno());
		System.out.println(user.getUser_class());
		
		userService.createUser(user);
		
		return "redirect:/admin-dashboard";
	}
}
