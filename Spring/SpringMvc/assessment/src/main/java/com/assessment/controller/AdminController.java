package com.assessment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	@RequestMapping("/admindashboard")
	public String adminDashboard()
	{
		return "admindashboard";
	}
}
