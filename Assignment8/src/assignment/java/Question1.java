//write a program to show in how many ways we can initialise the Final variable and use them in a method .

package assignment.java;

import java.util.Scanner;

public class Question1 {
	
	static final int SIZE=10;
	final int VALUE;
	final int MINIMUM;
	static final int MAXIMUM;
	
	{
	VALUE=10;
	}
	
	public  Question1()
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of minimum");
		MINIMUM=sc.nextInt();
	}
	
	public void Value()
	{
		System.out.println("Size= "+SIZE+" Value= "+VALUE+" Maximum = "+MAXIMUM+" Minimum = "+ MINIMUM);

	}
	
	static {
		
		MAXIMUM=10;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Question1 q = new Question1();
		System.out.println(q.MINIMUM);
		System.out.println(q.VALUE);
		q.Value();

	}

}
