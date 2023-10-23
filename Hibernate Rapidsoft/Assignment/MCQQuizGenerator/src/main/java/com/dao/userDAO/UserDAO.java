package com.dao.userDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.userEntity.User;

public class UserDAO {

	public void addUserDAO(String name, String phNo, String email, String psw) {
		// TODO Auto-generated method stub

		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		try {
			User user = new User();
			user.setName(name);
			user.setPhoneNo(phNo);
			user.setEmail(email);
			user.setPassword(psw);
			s.save(user);

			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("User did not added to database.....");
		} finally {
			s.close();
			f.close();

		}

	}

}
