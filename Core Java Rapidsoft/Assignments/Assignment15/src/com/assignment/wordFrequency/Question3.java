//3. Write a Java method that takes a list of words calculates their frequencies and stores 
//them into a map frequence as key and words as value and sorts the map by descending order.

package com.assignment.wordFrequency;

import java.util.*;

public class Question3 {
	
	static void sortDescendingFrequency(List<String> list)
	{
		
		System.out.println(hs);
	}
	
	static HashMap<String, Integer> checkFrequency(List<String> list)
	{
		HashMap<String, Integer> hs = new HashMap<>();
		for(String x:list)
		{
			int frequency=1;
			if(hs.containsKey(x))
			{
				frequency+=hs.get(x);
				hs.put(x, frequency);
			}
			else
			hs.put(x,1);
			
		}
		return hs;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list = new ArrayList<>();
		
		list.add("Hello");
		list.add("World");
		list.add("Rapidsoft");
		list.add("World");
		list.add("Hello");
		list.add("World");
		sortDescendingFrequency(list);
		
		

	}

}
