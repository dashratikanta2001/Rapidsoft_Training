package com.collection.map;

import java.util.*;

public class HashTableDemo {

	@SuppressWarnings({"rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hashtable<Integer,String> ht = new Hashtable<>();
		
		ht.put(1, "A");
		ht.put(2, "B");
		ht.put(3, "C");
		ht.put(4, "D");
		ht.put(5, "E");
		
		String s = (String) ht.get(3);
		
////		Enumeration e = ht.elements();
//		Enumeration e = ht.keys();
//		
//		while(e.hasMoreElements())
//		{
//			System.out.println(e.nextElement());
//		}
		
//		ht.compute(2, (k,v)->v+"Z");
		ht.computeIfAbsent(7, (k)->"Z"+k);
		
		System.out.println(ht);
	}


}