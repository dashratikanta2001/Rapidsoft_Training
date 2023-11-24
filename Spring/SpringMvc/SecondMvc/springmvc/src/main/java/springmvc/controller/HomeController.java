package springmvc.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/first")
public class HomeController {

	//This is only model controller
	
//	@RequestMapping("/home")
	@RequestMapping(path="/home", method = RequestMethod.GET)
	public String home(Model model)
	{
		
		System.out.println("This is home url");
		model.addAttribute("name","Ratikanta Dash");
		model.addAttribute("id",20);
		
		List<String> friends = new ArrayList();
		friends.add("f1");
		friends.add("f2");
		friends.add("f3");
		friends.add("f4");
		friends.add("f5");
		
		model.addAttribute("friends",friends);
		
		return "index";
	}
	
	@RequestMapping("/about")
	public String about()
	{
		System.out.println("About page ");
		return "about";
	}
	
	
	//This is model and view controller
	
	@RequestMapping("/help")
	public ModelAndView help()
	{
		
		System.out.println("This is help controller");
		
		//creating modelAndView object
		ModelAndView modelAndView = new ModelAndView();
		
		//Setting the data
		modelAndView.addObject("name","Ratikanta Dash");
		modelAndView.addObject("rollno",12345);
		LocalDateTime now = LocalDateTime.now();
		modelAndView.addObject("time",now);
		//marks
		List<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(90);
		list.add(60);
		
		modelAndView.addObject("marks",list);
		
		//setting the view name
		modelAndView.setViewName("help");
		
		return modelAndView;
	}
	
}

