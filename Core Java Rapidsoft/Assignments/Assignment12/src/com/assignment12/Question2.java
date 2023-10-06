//2)Given a list of strings, use lambda expressions to concatenate all the strings and 
//return the final result.(provide the string value in run time using scanner class)

package com.assignment12;

import java.util.Scanner;

@FunctionalInterface
interface StringConat{
	public String concat(String[] str);
}

class ConcatString{
	static String result="";
	static String display(String[] str)
	{
		for(String x:str)
			result+=x+" ";
		return result;
	}
}

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of the string array:");
		int size = sc.nextInt();
		
		String strArr[] = new String[size+1];
		
		System.out.println("Enter Strings: ");
		
		for(int i=0;i<=size;i++)
		{
			strArr[i] = sc.nextLine();
		}
		
		StringConat st = ConcatString::display;
		
		System.out.println(st.concat(strArr));
		
		/*
		StringConat st2 = (s)->{
			String ans="";
			for(String x:s)
			{
				ans+=x;
			}
			return ans;
		};
		
		System.out.println(st2.concat(strArr));
		
		*/
	}

}
