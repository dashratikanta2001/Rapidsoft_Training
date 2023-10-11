//1. Given a list of names, count the number of occurrences of each name and display the result.
package com.assignment.numberOfOccurance;

import java.util.*;

public class Question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> li = new ArrayList<>();
		li.add("Ratikanta");
		li.add("Dash");
		li.add("Rapidsoft");
		li.add("Technologies");
		li.add("Ratikanta");
		li.add("Ratikanta");
		li.add("Technologies");

		
		HashSet<String> hs = new HashSet<>();
		for(String s:li)
		{
			if(!hs.contains(li))
			{
				int frequecy = Collections.frequency(li, s);
				hs.add(s+"->"+frequecy);
			}
		}
		System.out.println(hs);

	}

}
