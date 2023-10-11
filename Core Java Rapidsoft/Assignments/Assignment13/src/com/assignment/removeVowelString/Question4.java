//4. Given a list of strings, remove all elements that start with a vowel and display the 
//modified list.

package com.assignment.removeVowelString;

import java.util.*;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> li = new ArrayList<>();
		List<Character> li2 = new ArrayList<>();
		li2.add('A');
		li2.add('E');
		li2.add('I');
		li2.add('O');
		li2.add('U');
		
		li.add("Apple");
		li.add("Apple");
		li.add("Apple");
		li.add("Ball");
		li.add("Cat");
		li.add("Elephant");
		li.add("India");
		li.add("Rapidsoft");
		
//		for(String s:li)
//		{
//			if(li2.contains(li.char			))
//		}
		
		
//		li.removeAll(li2);
//		for(String x:li)
			
//		{
//			li.removeif(x->li2.contains(x.charAt(0)));

//		}
			
			
//		li.removeIf(n-> (li2.contains(n.charAt(0))) );
		
//		System.out.println(li2.contains(x.charAt(0)));
		li.size();

			for(int i=0;i<li.size();i++)
			{
				String s=li.get(i);
				if(li2.contains(s.charAt(0)))
				{
					System.out.println(li2.contains(s));
					System.out.println(li.get(i)+" "+i);
					li.remove(i);
				}
			}
			
			System.out.println(li);
	}

}
