package assignment.java;

import java.io.*;
import java.util.Scanner;

class Emp implements Serializable{
private static final long serialVersionUID = 1L;
	String EmpName;
	String EmpNo;
	int salary;
	
	
	public Emp (String e,String n,int s)
	{
		EmpName=e;
		EmpNo=n;
		salary=s;
	}
}

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Emp Name");
		String EmpName= sc.nextLine();
		
		System.out.println("Enter Emp No");
		String EmpNo = sc.nextLine();
		
		System.out.println("Enter Emp Salary");
		int salary = sc.nextInt();


		Emp e = new Emp(EmpName,EmpNo,salary);
		
		try {
			FileOutputStream fout = new FileOutputStream("rati.txt");
			ObjectOutputStream out = new ObjectOutputStream(fout);
			out.writeObject(e);
			out.flush();
			System.out.println("Serialization completed........");
			out.close();
			
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
