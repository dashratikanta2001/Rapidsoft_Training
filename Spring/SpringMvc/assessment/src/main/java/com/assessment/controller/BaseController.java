package com.assessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.assessment.service.UserService;


@Controller
public class BaseController {
	
	
	@Autowired
	private UserService userService;
//
//	@Autowired
//	private QuestionService questionService;
//
//	@Autowired
//	private OptionService optionService;
//
//	@Autowired
//	private TestService testService;
//	
//	@Autowired
//	private UserInputService userInputService;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping(path = "/student-result", method = RequestMethod.GET)
	public String showResultByClass(Model m) {
		// TODO Auto-generated method stub
		m.addAttribute("classList",userService.getClassList());
		m.addAttribute("title","Result: Student");
		
		return "result-by-class";

	}
	
	

//	@RequestMapping("/startAssessment")
//	public String login() {
//		return "login-form";
//	}

//	@RequestMapping(path = "/startAssessment", method = RequestMethod.POST)
//	public String userAvailable(@ModelAttribute("email") String email, @ModelAttribute("testNo") int testNo, Model m , RedirectAttributes attributes) {
//		Map<Question, List<Option>> queOp = new LinkedHashMap<>();
//		User userDetails = userService.getUserDetails(email);
//		if (userDetails != null) {
//
//			if (!testService.isTestGiven(userDetails.getId(), testNo)) {
//				List<Question> questionList = questionService.showQuestion(userDetails.getUser_class(), testNo);
//
//				if (!questionList.isEmpty()) {
//
//					for (Question question2 : questionList) {
//						List<Option> options = optionService.showOptions(question2);
//						queOp.put(question2, options);
//					}
//
//					m.addAttribute("question", queOp);
//					m.addAttribute("test", testNo);
//					m.addAttribute("user_class",userDetails.getUser_class());
//					m.addAttribute("userId",userDetails.getId());
//					return "question";
//				} else {
//					attributes.addFlashAttribute("msg", "Question is not set for test " + testNo);
//					return "redirect:/";
//				}
//			} else {
//				attributes.addFlashAttribute("msg", "Test already given");
//				return "redirect:/";
//			}
//
//		} else {
//			attributes.addFlashAttribute("msg", "Email id does not Exist");
//			return "redirect:/";
//		}
//	}
//
//	@RequestMapping(path = "/submitExam", method = RequestMethod.POST)
//	public String examSubmit(@ModelAttribute("examForm") UserInputAnswer userInputAnswer, @ModelAttribute("testNO") int testNo, @ModelAttribute("userId") int userId, RedirectAttributes attributes) {
//
//		Map<Integer, Integer> selectedOptions = userInputAnswer.getSelectedOptions();
//		List<UserInput> userinputList = new ArrayList<>();
//		for (Map.Entry<Integer, Integer> entry : selectedOptions.entrySet()) {
//			Integer key = entry.getKey();
//			Integer val = entry.getValue();
//			System.out.println("qno. " + key + " -> OpNo. " + val);
//			
//			userinputList.add(new UserInput(testNo, new User(userId), new Question(key), new Option(val)));
//			
//		}
//		
//		if (userInputService.saveAnswers(userinputList)) {
//			testService.setTestDetails(testNo, userId);
//		}
//		else {
//			attributes.addFlashAttribute("msg", "Test not submitted. Some error occurs");
//			return "redirect:/home";
//		}
//		
//
//		return "redirect:/home";
//	}

}
