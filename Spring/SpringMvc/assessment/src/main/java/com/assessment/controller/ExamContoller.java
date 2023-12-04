package com.assessment.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assessment.entity.Option;
import com.assessment.entity.Question;
import com.assessment.entity.User;
import com.assessment.entity.UserInput;
import com.assessment.entity.formEntity.UserInputAnswer;
import com.assessment.entity.formEntity.UserMarks;
import com.assessment.service.OptionService;
import com.assessment.service.QuestionService;
import com.assessment.service.TestService;
import com.assessment.service.UserInputService;
import com.assessment.service.UserService;

@Controller
public class ExamContoller {

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private OptionService optionService;

	@Autowired
	private TestService testService;

	@Autowired
	private UserInputService userInputService;

	@RequestMapping(path = "/startAssessment", method = RequestMethod.POST)
	public String userAvailable(@ModelAttribute("email") String email, @ModelAttribute("testNo") int testNo, Model m,
			RedirectAttributes attributes) {
		m.addAttribute("title","Start assesment");
		Map<Question, List<Option>> queOp = new LinkedHashMap<>();
		User userDetails = userService.getUserDetails(email);
		if (userDetails != null) {

			if (!testService.isTestGiven(userDetails.getId(), testNo)) {
				List<Question> questionList = questionService.showQuestion(userDetails.getUser_class(), testNo);

				if (!questionList.isEmpty()) {

					for (Question question2 : questionList) {
						List<Option> options = optionService.showOptions(question2);
						queOp.put(question2, options);
					}

					m.addAttribute("question", queOp);
					m.addAttribute("test", testNo);
					m.addAttribute("user_class", userDetails.getUser_class());
					m.addAttribute("userId", userDetails.getId());
					return "start-assesment";
				} else {
					attributes.addFlashAttribute("msg", "Question is not set for test " + testNo);
					return "redirect:/";
				}
			} else {
				attributes.addFlashAttribute("msg", "Test already given");
				return "redirect:/";
			}

		} else {
			attributes.addFlashAttribute("msg", "Email id does not Exist");
			return "redirect:/";
		}
	}

	@RequestMapping(path = "/submitExam", method = RequestMethod.POST)
	public String examSubmit(@ModelAttribute("examForm") UserInputAnswer userInputAnswer,
			@ModelAttribute("testNO") int testNo, @ModelAttribute("userId") int userId, RedirectAttributes attributes, Model m) {

		m.addAttribute("title","Submit Exam");
		
		Map<Integer, Integer> selectedOptions = userInputAnswer.getSelectedOptions();
		List<UserInput> userinputList = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : selectedOptions.entrySet()) {
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println("qno. " + key + " -> OpNo. " + val);

			userinputList.add(new UserInput(testNo, new User(userId), new Question(key), new Option(val)));

		}

		if (userInputService.saveAnswers(userinputList)) {
			testService.setTestDetails(testNo, userId);
		} else {
			attributes.addFlashAttribute("msg", "Test not submitted. Some error occurs");
			return "redirect:/home";
		}

		return "redirect:/home";
	}

	@RequestMapping(path = "/student-result", method = RequestMethod.POST)
	public String showResultById(@ModelAttribute("email") String email, RedirectAttributes attributes, Model m) {
		
		m.addAttribute("title","Result: Student");
		User user = userService.getUserDetails(email);
		if (user != null) {
			
			UserMarks calculateResult = calculateResult(user, attributes,m);
			m.addAttribute("marks", calculateResult);
			
			return "result";
			
//			List<UserMarks.TestDetails> markdetails = new ArrayList<>();
//			List<UserInput> userInput = userInputService.getUserInputById(user.getId());
//			
//			if(!userInput.isEmpty())
//			{
//				HashSet<Integer> testGiven = new HashSet<>();
//				
//				for (UserInput userInput2 : userInput) {
//					testGiven.add(userInput2.getTest_id());
//				}
//				
//				
//				for (Integer testNo : testGiven) {
//					int mark = 0;
//					List<Question> questionList = questionService.showQuestion(user.getUser_class(), testNo);
//					int totalMark = questionList.size();
//					
//					if (!userInput.isEmpty()) {
//						for (UserInput userAnswer : userInput) {
//							
//							for (Question question : questionList) {
//								
//								int questionId = question.getQuestion_id();
//								
//								Option ans = optionService.showAnswer(questionId);
//								
//								if (userAnswer.getOption().getOption_id() == ans.getOption_id()) {
//									mark++;
//								}
//							}
//						}
//						
//						String grade = "";
//						
//						if (mark / totalMark >= 0.5) {
//							grade = "Pass";
//						} else {
//							grade = "Fail";
//						}
//						
//						markdetails.add(new UserMarks.TestDetails(testNo, totalMark, mark, grade));
//					}
//				}
//				
//				UserMarks userMarkDetails = new UserMarks(user.getName(), user.getEmail(), user.getUser_class(), markdetails);
//				
//				m.addAttribute("marks", userMarkDetails);
//				
//			}
//			else {
//				m.addAttribute("msg", "No test details found");
//			}
//			
//
//			return "result";
		} else {
			attributes.addFlashAttribute("msg", "Email id does not Exist");
			return "redirect:/";
		}
	}
	
	@RequestMapping(path = "/student-result-by-class", method = RequestMethod.POST)
	public String showResultByClass(@ModelAttribute("stdClass") int userClass ,Model m, RedirectAttributes attributes) {
		m.addAttribute("title","Result: Student");
		// TODO Auto-generated method stub
//		List<User> userDetailsByClass = userService.getUserDetailsByClass(stdClass);
//		
//		System.out.println(userDetailsByClass);
		
		List<User> userDetailsByClass = userService.getUserDetailsByClass(userClass);
		List<UserMarks> userMarks = new ArrayList<>();
		System.out.println(userDetailsByClass.get(0).getId());
		
		for (User user : userDetailsByClass) {
			userMarks.add(calculateResult(user, attributes, m));
		}
		
		m.addAttribute("userList", userMarks);
		return "result-by-class";

	}
	
	private UserMarks calculateResult(User user, RedirectAttributes attributes, Model m) {
		// TODO Auto-generated method stub
		List<UserMarks.TestDetails> markdetails = new ArrayList<>();
		List<UserInput> userInput = userInputService.getUserInputById(user.getId());
		
		if(!userInput.isEmpty())
		{
			HashSet<Integer> testGiven = new HashSet<>();
			
			for (UserInput userInput2 : userInput) {
				testGiven.add(userInput2.getTest_id());
			}
			
			
			for (Integer testNo : testGiven) {
				int mark = 0;
				List<Question> questionList = questionService.showQuestion(user.getUser_class(), testNo);
				int totalMark = questionList.size();
				
				if (!userInput.isEmpty()) {
					for (UserInput userAnswer : userInput) {
						
						for (Question question : questionList) {
							
							int questionId = question.getQuestion_id();
							
							Option ans = optionService.showAnswer(questionId);
							
							if (userAnswer.getOption().getOption_id() == ans.getOption_id()) {
								mark++;
							}
						}
					}
					
					String grade = "";
					
					if (mark / totalMark >= 0.5) {
						grade = "Pass";
					} else {
						grade = "Fail";
					}
					
					markdetails.add(new UserMarks.TestDetails(testNo, totalMark, mark, grade));
				}
			}
			
			
		}
		else {
			m.addAttribute("msg", "No test details found");
		}
		
		UserMarks userMarkDetails = new UserMarks(user.getName(), user.getEmail(), user.getUser_class(),user.getRollno() ,markdetails);
		
		
		return userMarkDetails;

		

	}
	
}
