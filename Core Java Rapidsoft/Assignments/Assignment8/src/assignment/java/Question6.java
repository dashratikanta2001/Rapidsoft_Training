//Write a program implementing  multiple static blocks with a use-case scenario.

package assignment.java;

class Calc{
	static int a;
	static int b=5;
	static int c;
	static {
		a=10;
	}
	
	static {
		c=20;
	}
	
	static void display()
	{
		System.out.println("a = "+a+" b = "+b+" c = "+c);
	}
	
}

public class Question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc.display();

	}

}
