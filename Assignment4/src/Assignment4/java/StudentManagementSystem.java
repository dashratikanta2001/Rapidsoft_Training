package Assignment4.java;

import java.util.Scanner;

class Person{
	public String name;
	public byte age;
	
	public void displayInfo()
	{
		System.out.println("This is in Super class");
	}
}

class Student extends Person{
	public String stdId,stdclass;
	public char stdsection;
	
	public void displayInfo()
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Student Name:");
		name = sc.nextLine();
		
		System.out.println("Enter Student Id:");
		stdId = sc.nextLine();
		
		System.out.println("Enter Student Age:");
		age = sc.nextByte();
		
		System.out.println("Enter Student Class:");
		sc.nextLine();
		stdclass = sc.nextLine();
		
		System.out.println("Enter Student Section:");
		stdsection = sc.next().charAt(0);
		
		System.out.println("==================================================================");
		
		System.out.println("Name:" +name);
		System.out.println("ID:" +stdId);
		System.out.println("Age:" +age);
		System.out.println("Class:" +stdclass);
		System.out.println("Section:" +stdsection);
		
		System.out.println("==================================================================");


	}
	
}

public class StudentManagementSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s = new Student();
		s.displayInfo();

	}

}
