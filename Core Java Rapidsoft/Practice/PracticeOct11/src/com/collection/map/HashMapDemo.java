package com.collection.map;

import java.util.*;

public class HashMapDemo {
 
	@SuppressWarnings("serial")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<Integer, String> tm = new HashMap<Integer,String>() {{
			put(0,"A");	
			put(1,"B");	
			put(2,"C");	
			put(3,"D");	
			}};
			
			tm.put(4, "E");
			tm.put(5, "F");
//			tm.clear();
			
//			System.out.println(tm.ceilingEntry(5).getValue());
//			System.out.println(tm.get(3));
			System.out.println(tm);
	}

}
