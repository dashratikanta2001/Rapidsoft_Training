package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

	@RequestMapping("/home")
	public String home() {
		System.out.println("This is home controller");
		return "home";
	}

	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query, RedirectAttributes attributes) {
		String url = "https://www.google.com/search?q=" + query;
		RedirectView redirectView = new RedirectView();
		if (!query.isEmpty()) {
			redirectView.setUrl(url);
			return redirectView;
		}
		else {
			redirectView.setUrl("home");
			attributes.addFlashAttribute("msg","Please enter something to search...");
			return redirectView;
		}
	}
}
