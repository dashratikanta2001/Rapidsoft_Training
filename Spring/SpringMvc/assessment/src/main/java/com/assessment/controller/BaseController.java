package com.assessment.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assessment.entity.Question;
import com.assessment.entity.User;
import com.assessment.service.QuestionService;
import com.assessment.service.UserService;


@Controller
public class BaseController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private QuestionService questionService;
	
	@RequestMapping("/")
	public String index()
	{
		return "index";
	}
	
	@RequestMapping("/home")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/startAssessment")
	public String login()
	{
		return "login-form";
	}
	
	@RequestMapping(path = "/startAssessment", method = RequestMethod.POST)
	public String userAvailable(@ModelAttribute("email") String email, Model m)
	{
		User userDetails = userService.getUserDetails(email);
		if (userDetails!=null) {
			List<Question> question = questionService.showQuestion(userDetails.getUser_class(), 1);
			m.addAttribute("question", question);
			
			List<Integer> test = new ArrayList<>();
			test.add(1);
			test.add(2);
			test.add(3);
			m.addAttribute("test",test);
			return "question";			
		}
		else {
			m.addAttribute("msg","User not available");
			return "index";
		}
	}
	
	@RequestMapping("/start-assessment")
	public String startAssessment(Model m)
	{
		List<User> allUser = userService.allUser();
		m.addAttribute("user",allUser);
		System.out.println(allUser);
		return "question";
	}
	
	@RequestMapping("/user")
	public String addUser(@ModelAttribute("user") User user)
	{
		System.out.println(user);
		this.userService.createUser(user);
		return "question";
	}
	
	
}
