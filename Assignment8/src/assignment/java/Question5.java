//Write a single program to showcase all the access modifiers implementation.

package assignment.java;

import assignment.java.mypackage.Demo1;

class SuperClass{
	private int a=10;
	protected int b=20;
	public int c=30;
	SuperClass()
	{
		privateDisplay();
	}
	
	private void privateDisplay()
	{
		System.out.println("This is in private method");
		System.out.println("a = "+a+" b = "+b+" c = "+c);
	}
	
	protected void protectedDisplay()
	{
		System.out.println("This is in protected method");
		System.out.println("a = "+a+" b = "+b+" c = "+c);
	}
	
	public void publicDisplay()
	{
		System.out.println("This is in public method");
		System.out.println("a = "+a+" b = "+b+" c = "+c);
	}
}

class SubClass extends SuperClass{
	void display()
	{
//		System.out.println("a = "+a);  
		//The value of 'a' will give error as it is declared as private in the superclass
		System.out.println("b = "+b);
		System.out.println("c = "+c);
	}
}

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SubClass sc = new SubClass();
		sc.display();
		
		SuperClass s = new SuperClass();
		s.protectedDisplay();
		s.publicDisplay();
		
		Demo1 d = new Demo1();
		
		d.display();

	}

}
