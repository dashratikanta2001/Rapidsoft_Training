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
