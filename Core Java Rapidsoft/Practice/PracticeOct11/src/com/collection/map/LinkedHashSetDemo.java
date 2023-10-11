package com.collection.map;

import java.util.*;

public class LinkedHashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		HashSet<String> lhs = new HashSet<>(10);
		LinkedHashSet<String> lhs = new LinkedHashSet<>(10);
		
		lhs.add("A");
		lhs.add("F");
		lhs.add("D");
		lhs.add("B");
		lhs.add("E");
		lhs.add("C");
		lhs.add("B");

		
//		lhs.forEach(System.out::println);
		
		Iterator<String> itr = lhs.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
		
	}

}
