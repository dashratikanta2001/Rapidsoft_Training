//3. Write a Java method that takes a set of strings and returns a new set containing the 
//unique characters present in all the strings of the input set.

package com.assignment.uniqueCharacter;

import java.util.*;

public class Question3 {
	
	
	static HashSet<Character> uniqueChar(List<String> li)
	{
		HashSet<Character> hs = new HashSet<>();
		
		String s = li.toString();
		
		char [] charArray = s.toCharArray();
		
		for(char c:charArray)
		{
			if(c>='a'& c<='z' || c>='A'&& c<='Z')
				hs.add(c);
		}
		return hs;
	}

//	static HashSet<String> uniqueChar(List<String> li)
//	{
//		HashSet<String> hs = new HashSet<>();
//
//		for (String s : li) {
//			for(int i=0;i<s.length();i++)
//			{
//				hs.add(""+s.charAt(i));
//			}
//		}
//		return hs;
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> li = new ArrayList<>();
		li.add("string1");
		li.add("Ratikanta");
		li.add("Dash");
		li.add("Rapidsoft");

		//		uniqueChar(li);
		System.out.println("All Unique Characters are: "+uniqueChar(li));

	}

}
