package com.lambdaPractice;

interface MyLambda4
{
	public void display(String str);
}

interface MyLambda5
{
	public int display(String str1, String str2);
}

public class MethodReferences {
	
	public MethodReferences() {
		// TODO Auto-generated constructor stub
	}
	
	MethodReferences(String str)
	{
		System.out.println(str.toUpperCase());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyLambda4 m = System.out::println;
		
		m.display("Method Reference");
		
		MyLambda4 m2 = MethodReferences::reverse;
		
		m2.display("Hello");
		
		MethodReferences mr = new MethodReferences();
		MyLambda4 m3 = mr::reverse2;
		m3.display("Hello World");
		
		MyLambda4 m4 = MethodReferences::new;
		
		m4.display("Constructor");
		
		
		MyLambda5 m5 = String::compareTo;
		
		System.out.println(m5.display("Hello", "Hello"));
	}

	public static void reverse(String str)
	{
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
		System.out.println(sb);
	}
	
	public void reverse2(String str)
	{
		StringBuffer sb = new StringBuffer(str);
		sb.reverse();
		System.out.println(sb);
	}
}
