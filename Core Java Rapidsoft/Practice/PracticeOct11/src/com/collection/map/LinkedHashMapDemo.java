package com.collection.map;

import java.util.*;

public class LinkedHashMapDemo {
	

	@SuppressWarnings({ "unchecked", "serial", "rawtypes" })
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedHashMap<Integer, String> lhm = new LinkedHashMap(5,.5f,true) {
			protected boolean removeEldestEntry(Map.Entry e)
			{
				return size()>5;
			}
		};
		
		lhm.put(1, "A");
		lhm.put(2, "B");
		lhm.put(3, "C");
		lhm.put(4, "D");
		lhm.put(5, "E");
		String s=lhm.get(2);
		s=lhm.get(5);
		s=lhm.get(1);
		lhm.put(6, "F");
//		lhm.put(9, "I");
//		lhm.put(8, "H");
		System.out.println(s);
		lhm.forEach((k,v)-> System.out.println(k+" "+v));

	}

}
