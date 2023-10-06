//5)Create a StringValidator class with an instance method isPalindrome() that checks if a given 
//string is a palindrome. Use a method reference  to refer to the instance method. 
//Check if each word in the array is a palindrome.

package com.assignment12;

import java.util.Scanner;

@FunctionalInterface
interface CheckPallindrome{
	void isPallindrome(String [] str);
}

class StringValidator{
	
	private static boolean reverse(String st)
	{
		String rev ="";
		for(int i=0;i<st.length();i++)
		{
			rev+=st.charAt(st.length()-1-i);
		}
		return st.equalsIgnoreCase(rev);
	}
	
	static void pallindrome(String [] str)
	{
		for(String s:str)
		{
			if(reverse(s))
				System.out.println("The String \" "+s+" \" is Pallindrome");
			else
				System.out.println("The String \" "+s+" \" is not Pallindrome");
		}
	}
}

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of the array");
		int size = sc.nextInt();
		
		String [] strarr = new String[size];
		for(int i=0;i<size;i++)
		{
			strarr[i] = sc.next();
		}
		
		CheckPallindrome c = StringValidator::pallindrome;
		c.isPallindrome(strarr);
				
	}

}
