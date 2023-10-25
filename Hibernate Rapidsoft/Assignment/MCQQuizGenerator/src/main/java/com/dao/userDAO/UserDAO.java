package com.dao.userDAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.userEntity.User;

public class UserDAO {

	public String addUserDAO(String name, String phNo, String email, String psw) {
		// TODO Auto-generated method stub

		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session s = f.openSession();
		Transaction tx = s.beginTransaction();
		String uId="User not entried";
		try {
			User user = new User();
			user.setName(name);
			user.setPhoneNo(phNo);
			user.setEmail(email);
			user.setPassword(psw);
			s.save(user);
			tx.commit();
			uId=""+ user.getUser_id();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("User did not added to database.....");
		} finally {
			
			s.close();
			f.close();
			
		}
		
		return uId;
	}

	public boolean loginUser(int uId, String psw) {
		// TODO Auto-generated method stub

		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session s = f.openSession();
		User user = s.get(User.class, uId);

		if(user==null)
		{
			System.out.println("User does not exist");
			return false;
		}
		else if (uId == user.getUser_id() && psw.equals(user.getPassword())) {
			return true;
		} else {
			return false;
		}

	}

}
