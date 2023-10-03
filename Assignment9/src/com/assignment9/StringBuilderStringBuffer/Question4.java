// Write a program using index of a character, performs concatenation, replacement,
//and more. It also demonstrates methods specific to StringBuilder and StringBuffer 
//such as appending, inserting, deleting, and reversing.


package com.assignment9.StringBuilderStringBuffer;

public class Question4 {
	
	static void stringCR()
	{
		String s1 = "Ratikanta";
		String s2 = "Dash";
		System.out.println("S2 = "+s2);
		System.out.println("S1 = "+s1);
		
		String s3 = s1+s2;
		
		String ss = s1.substring(2, 5);
		s1.concat(s2);
		
		System.out.println("S3 = "+s3);
		System.out.println("Sub String = "+ ss);
		System.out.println("S1 character at 4 = "+ s1.charAt(3));
		System.out.println("S1 concat with S2 = "+s1);
	}
	
	static void stringBuilder()
	{
		StringBuilder sb = new StringBuilder("I am");
		System.out.println("String: " + sb);
		sb.append(" Ratikanta");
		System.out.println("Appended String: "  +sb);
		System.out.println("Replacing String Ratikanta with Dash: " + sb.replace(6, sb.length(), " Dash"));
		System.out.println("After Removing a Character in the String: " + sb.deleteCharAt(sb.length()-1));

	}
	
	static void stringBuffer()
	{
		StringBuffer s = new StringBuffer("Ratikanta");
		System.out.println("The original StringBuffer = "+ s);
		System.out.println("The Deleted character at 3rd position is = "+ s.deleteCharAt(2));
		System.out.println("Inserting character at 3rd position is = "+ s.insert(2, 't'));
		System.out.println("The reversed String is = "+ s.reverse());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stringCR();
		System.out.println("\n");
		
		stringBuilder();
		System.out.println("\n");
		
		stringBuffer();
	}

}
