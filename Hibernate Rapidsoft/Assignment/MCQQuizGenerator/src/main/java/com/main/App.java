package com.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.controller.ControllerMenu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        SessionFactory f = new Configuration().configure().buildSessionFactory();
        Session s  = f.openSession();
        Transaction tx = s.beginTransaction();
        
        ControllerMenu cm = new ControllerMenu();
        cm.menu();
        
        s.close();
    }
}
