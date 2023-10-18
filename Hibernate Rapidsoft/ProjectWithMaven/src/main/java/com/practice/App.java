package com.practice;

import java.io.FileInputStream;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        System.out.println( "Project Started" );
        
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        //Creating Student
        Student st = new Student();
        st.setId(104);
        st.setName("Akhila");
        st.setCity("BBSR");
        System.out.println(st);
        
        //Creating object of Address class
        Address ad = new Address();
        ad.setStreet("Street1");
        ad.setCity("BBSR");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.12);
        
        //Reading Image
        FileInputStream fis = new FileInputStream("/home/rapidsoft/Downloads/Download2.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        fis.close();
        
        Session session= factory.openSession();
        Transaction tx = session.beginTransaction();
        
        
        session.save(st);
        session.save(ad);
        
        tx.commit();
        session.close();
        System.out.println("Done.....");
        
        
        
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
    }
}
