package assignment.java;

import java.util.Scanner;

public class Question1 implements Cloneable{
	Scanner sc = new Scanner(System.in);
	
	String name;
	int roll;
	int age;
	char sec;
	
	Question1()
	{
		System.out.println("Enter Name");
		name= sc.nextLine();
		
		System.out.println("Enter Rolln no");
		roll = sc.nextInt();
		
		System.out.println("Enter Age");
		age= sc.nextInt();
		
		System.out.println("Enter Sec");
		sec = sc.next().charAt(0);
		
	}
	
	public void display()
	{
		System.out.println("Name :"+name);
		System.out.println("Roll no: "+roll);
		System.out.println("Age: "+age);
		System.out.println("Sec: "+sec);
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub

		Question1 q = new Question1();
		Question1 q2 = (Question1) q.clone();
		
		System.out.println("\nThis is Original reference");
		q.display();
		
		System.out.println("\nThis is Cloned reference");
		q2.display();
		
	}

}
