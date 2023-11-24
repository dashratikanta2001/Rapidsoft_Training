package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import springmvc.model.User;
import springmvc.service.UserService;

@Controller
public class ContactController {

	// Without Spring mvc
	/*
	 * @RequestMapping("/contact") public String showForm() {
	 * 
	 * return "contact"; }
	 * 
	 * @RequestMapping(path = "/processform", method = RequestMethod.POST) public
	 * String handleForm(
	 * 
	 * @RequestParam(name ="userEmail", required = true) String email,
	 * 
	 * @RequestParam("userName") String name,
	 * 
	 * @RequestParam("userPassword") String password, Model model) {
	 * 
	 * // System.out.println("User email = "+email); //
	 * System.out.println("User name= "+name); //
	 * System.out.println("User Password = "+password);
	 * 
	 * User user = new User();
	 * 
	 * user.setEmail(email); user.setUserName(name); user.setuserPassword(password);
	 * 
	 * System.out.println(user);
	 * 
	 * //process
	 * 
	 * 
	 * // model.addAttribute("email",email); // model.addAttribute("name",name); //
	 * model.addAttribute("password",password);
	 * 
	 * model.addAttribute(user);
	 * 
	 * return "success"; }
	 */

	// with spring mvc
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping("/")
	public String home() {
		
		
		System.out.println("bhcgsghd");
		return "home";
	}
	

	@RequestMapping("/contact")
	public String showForm(Model m) {
		System.out.println("Creatimg form");
		return "contact";
	}

	@RequestMapping(path = "/processform", method = RequestMethod.POST)
	public String handleForm(@ModelAttribute User user, Model model) {
		System.out.println("showing form");
		
		int createUser = this.userService.createUser(user);
		
		model.addAttribute("msg","User created with id "+createUser);

		return "success";
	}

	@ModelAttribute
	public void commonDataForModel(Model model) {
		System.out.println("Adding common data to form");
		model.addAttribute("Header", "Learn code with Ratikanta");
		model.addAttribute("Desc", "Home for programmer");

	}

}
