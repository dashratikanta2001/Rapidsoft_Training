//3. Write a Java method that takes a list of words calculates their frequencies and stores
//them into a map frequence as key and words as value and sorts the map by descending order.

package com.assignment.wordFrequency;

import java.util.*;
import java.util.stream.Collectors;

public class Question3 {

	static HashMap<String, Integer> sortDescendingFrequency(List<String> list)
	{
		HashMap<String, Integer> freqHash = checkFrequency(list);

		System.out.println("Without Sorted: "+freqHash);
		
		return sortHashMap(freqHash);
	}	
	
	
	static HashMap<String, Integer> sortHashMap(HashMap<String, Integer> hm)
	{
		HashMap<String, Integer> temp
		= hm.entrySet()
		.stream()
		.sorted((i1, i2)
				-> i2.getValue()-i1.getValue())
		.collect(Collectors.toMap(
				Map.Entry::getKey,
				Map.Entry::getValue,
				(e1, e2) -> e1, LinkedHashMap::new));
		return temp;
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
		list.add("Rapidsoft");
		list.add("Hello");
		list.add("Rapidsoft");
		list.add("World");
		list.add("Rapidsoft");
		
		System.out.println("\nWith sorted in Descending order: "+sortDescendingFrequency(list));



	}

}
