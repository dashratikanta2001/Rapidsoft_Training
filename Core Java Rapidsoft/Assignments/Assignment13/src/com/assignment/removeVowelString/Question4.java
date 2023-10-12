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
		li2.add('a');
		li2.add('e');
		li2.add('i');
		li2.add('o');
		li2.add('u');

		li.add("Apple");
		li.add("apple");
		li.add("Apple");
		li.add("Ball");
		li.add("Cat");
		li.add("Elephant");
		li.add("India");
		li.add("Rapidsoft");
		System.out.println("Original List: "+ li);

			
		Iterator<String> it = li.iterator();
		
		while(it.hasNext())
		{
			
			if(li2.contains(it.next().charAt(0)))
				it.remove();
		}
		
		
		System.out.println("After removing vowel: "+li);
	}

}
