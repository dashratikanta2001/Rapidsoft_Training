package com.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.assessment.entity.Question;
import com.assessment.entity.User;
import com.assessment.entity.formEntity.SetQuestionOption;
import com.assessment.service.OptionService;
import com.assessment.service.QuestionService;
import com.assessment.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private QuestionService questionService;

	@Autowired
	private OptionService optionService;

	@RequestMapping("/admin-dashboard")
	public String adminHome(Model m) {
		m.addAttribute("title", "Admin: Dashboard");
		return "admin-home";
	}

	@RequestMapping("/add-question")
	public String addQuestion(Model m) {
		m.addAttribute("title", "Add Question");
		return "add-question";
	}

	@RequestMapping("/add-user")
	public String addUser(Model m) {
		m.addAttribute("title", "Add Student");
		return "add-user";
	}

	@RequestMapping(path = "/add-user", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user) {
		System.out.println(user.getName());
		System.out.println(user.getEmail());
		System.out.println(user.getRollno());
		System.out.println(user.getUser_class());

		userService.createUser(user);

		return "redirect:/admin-dashboard";
	}

	@RequestMapping(path = "/select-class", method = RequestMethod.POST)
	public String selectClass(@ModelAttribute("selectedClass") int selectedClass,
			@ModelAttribute("selectedTestNo") int selectedTestNo, RedirectAttributes attributes) {
		System.out.println("Selected Class = " + selectedClass);
		System.out.println("Selected test no = " + selectedTestNo);

		attributes.addFlashAttribute("selectedClass", selectedClass);
		attributes.addFlashAttribute("selectedTestNo", selectedTestNo);
		return "redirect:/add-question";
	}

	@RequestMapping(path = "/add-Question", method = RequestMethod.POST)
	public String addQuestion(@ModelAttribute("setQuestionOption") SetQuestionOption setQuestionOption,
			RedirectAttributes attributes) {

		int testNo = setQuestionOption.getClassNo();
		int classNo = setQuestionOption.getTestNo();

		List<String> questionList = setQuestionOption.getQuestion();
		List<String> optionList = setQuestionOption.getOption();
		List<Integer> answerList = setQuestionOption.getAnswer();

		for (int i = 0; i < questionList.size(); i++) {
			String question = questionList.get(i);
			System.out.println("Question: " + question);

			Integer questionId = questionService.addQuestion(testNo, classNo, question);

			int correctAnswer = answerList.get(i);

			for (int j = 0; j < 4; j++) {
				String option = optionList.get(i * 4 + j);
				System.out.print("Option " + (j + 1) + ": " + option);
				boolean isAnswer = false;
				if (j + 1 == correctAnswer) {
					isAnswer = true;
				}
				optionService.addOption(questionId, option, isAnswer);

			}

		}

		attributes.addFlashAttribute("msg", "Question set successfully");

		return "redirect:/admin-dashboard";
	}
}
