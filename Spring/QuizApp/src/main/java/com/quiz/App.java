package com.quiz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.quiz.controller.ControllerMenu;

/**
 * Hello world!
 *
 */
public class App {
	public static ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
	public static void main(String[] args) {

		System.out.println("Welcome to the Online Exam Portal");

		ControllerMenu controllerMenu = new ControllerMenu();

		controllerMenu.menu();

		System.out.println("Thank you for using our application !!!!");
	}
}
