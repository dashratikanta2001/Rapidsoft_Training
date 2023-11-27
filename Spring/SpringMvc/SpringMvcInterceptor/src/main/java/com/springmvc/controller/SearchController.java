package com.springmvc.controller;

//import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {
	
	
	@RequestMapping("/user/{userId}/{userName}")
	public String getUserDetail(@PathVariable("userId") int userId, @PathVariable("userName") String userName)
	{
		System.out.println(userId);
		System.out.println(userName);
//		Integer.parseInt(userName);
		return "home";
	}

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
	
//	 Handling Exception in our Spring MVC 
	
	/*
	 * @ExceptionHandler({NullPointerException.class , NumberFormatException.class})
	 * public String exceptionHandlerNull() { return "null_page"; }
	 */
	
	/*
	 * @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	 * 
	 * @ExceptionHandler(value = NullPointerException.class) public String
	 * exceptionHandlerNull(Model m) { m.addAttribute("msg",
	 * "Null pointer exception has occured"); return "null_page"; }
	 * 
	 * @ExceptionHandler(value = NumberFormatException.class) public String
	 * exceptionHandlerNumberFormat(Model m) { m.addAttribute("msg",
	 * "Number format exception has occured"); return "null_page"; }
	 * 
	 * @ExceptionHandler(value = Exception.class) public String
	 * exceptionHandlerGeneric(Model m) { m.addAttribute("msg",
	 * "Exception has occured"); return "null_page"; }
	 */
}
