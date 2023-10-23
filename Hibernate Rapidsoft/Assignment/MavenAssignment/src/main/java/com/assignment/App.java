package com.assignment;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.assignment.emp.Employee;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		SessionFactory f = new Configuration().configure().buildSessionFactory();
		Session session = f.openSession();

		// Add Employee Details

		System.out.println("________________________________________________________________________");
		System.out.println("Add Employee Details");
		Transaction tx = session.beginTransaction();
		for (int i = 1; i <= 10; i++) {
			Employee e1 = new Employee();
			e1.setEmpId(i);
			e1.setEmpName("Employee" + i);
			if (i % 3 == 0) {
				e1.setDesignation("Backend Developer");
				e1.setPhoneNo("123" + (i * 2) + "456");
			} else if (i % 3 == 1) {
				e1.setDesignation("FrontEnd Developer");
				e1.setPhoneNo("1234" + (i + 2));
			} else {
				e1.setDesignation("UI/UX Developer");
				e1.setPhoneNo("123456" + i);
			}
			session.save(e1);
		}

		tx.commit();	
		System.out.println("Employee data added Successfully");
		System.out.println("________________________________________________________________________");

////    	Update Query
		System.out.println("________________________________________________________________________");
		System.out.println("Update Employee");
		Transaction tx1= session.beginTransaction();
		Query upQ = session.createQuery("update Employee set phoneNo=:p where empName=:n");
		upQ.setParameter("p", "908070");
		upQ.setParameter("n", "Employee2");
		int ru = upQ.executeUpdate();
		tx1.commit();
		System.out.println(ru + " Updated");
		System.out.println("________________________________________________________________________");

		// Delete Query
		System.out.println("________________________________________________________________________");
		System.out.println("Delete Employee");
		Transaction tx2 = session.beginTransaction();
		Query delQ = session.createQuery("delete from Employee where empId=:eid");
		delQ.setParameter("eid", 3);
		int rd = delQ.executeUpdate();
		tx2.commit();
		System.out.println(rd + " Deleted");
		System.out.println("________________________________________________________________________");

//		//get Employee by id:
		System.out.println("________________________________________________________________________");
		System.out.println("Display Employee by id:");
		Query<Employee> idQ = session.createQuery("from Employee where empId=:eid");
		idQ.setParameter("eid", 1);
		Employee e = idQ.uniqueResult();
		System.out.println("Id= " + e.getEmpId() + "\nName= " + e.getEmpName() + "\nDesignation = " + e.getDesignation()
				+ "\nPhone Number = " + e.getPhoneNo());
		System.out.println("________________________________________________________________________");

		// get All Employee Details
		System.out.println("________________________________________________________________________");
		System.out.println("Display All Employee details:");
		Query<Employee> allQ = session.createQuery("from Employee");
		List<Employee> allEmpList = allQ.getResultList();

		for (Employee emp : allEmpList) {
			System.out.println(emp.getEmpId() + " : " + emp.getEmpName() + " : " + emp.getDesignation() + " : "
					+ emp.getPhoneNo());
		}
		System.out.println("________________________________________________________________________");

//		tx.commit();
		session.close();
		f.close();
	}
}
