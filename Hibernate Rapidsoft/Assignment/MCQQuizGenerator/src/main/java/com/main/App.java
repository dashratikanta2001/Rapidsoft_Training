package com.main;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.controller.ControllerMenu;

/**
 * Hello world!
 *
 */
public class App 
{
	public static SessionFactory factory = new Configuration().configure().buildSessionFactory();
    public static void main( String[] args )
    {
        System.out.println( "Welcome to Quiz Generator" );
        Session s  = factory.openSession();
        
        ControllerMenu cm = new ControllerMenu();
        	
        cm.menu();
        
        s.close();
        factory.close();
    }
}

//STEP-1
//The menu will come where the user will enter the menu number to perform the respective action.
//
//STEP-2  Add User
//New user will provide their name, phoneNo, emailId,and password to register.
//After successfull registration it will show the userId of that user.
//
//STEP-3 Start Quiz
//The user will enter their respective userId to start the quiz.
//if the userId is not present it provide that user is not available.
//
//STEP-3.1
//The question and respective options are displayed.
//User has to enter the respective option serial number to save the answer.
//if the user will provide outside of the option number then it will ask to provide the correct option number.
//
//and so on....
//
//STEP-4 Show mark by Id
//The user will enter their id to show their individual mark.
//If the user is not given the Quiz then it shows their obtained mark as 0.
//
//if the userId is not present it provide that user is not available.
//
//STEP-5 Show All Marks
//It will displayed all users obtained mark and total mark.
//
//STEP-6 Add Question
//
//First it will ask to enter their userId and password to authenticate.
//Then it will show another menu to perform the Operation like: Set Question, Set Option and Set Answer.
//the user has to enter the respective SL no.
//
//STEP-6.1 Set Question
//User has to enter the question
//after that it shows the question id.
//
//STEP-6.2 Set Option
//It will ask to enter the question id
//if the ID is present then it allows to enter the option
//After that it ask to enter another option 
//If press Y then it ask to enter another option else it shows the menu
//
//STEP-6.3 Set Answer
//It ask to enter the question id
//if the ans is set for that id then it shows that answer already set
//else it shows the avalable options for that question
//here user have to enter the serial number of the option to set as answer.
//


