package com.collection.map;

import java.util.Map.*;
import java.util.*;

public class TreeMapDemo {

	@SuppressWarnings("serial")
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeMap<Integer, String> tm = new TreeMap<Integer,String>() {{
		put(0,"A");	
		put(1,"B");	
		put(2,"C");	
		put(3,"D");	
		}};
		
		tm.put(4, "E");
		tm.put(5, "F");
		
		Entry<Integer,String> e = tm.firstEntry();
		System.out.println(e.getKey()+" "+e.getValue());
		
//		System.out.println(tm.ceilingEntry(5).getValue());
//		System.out.println(tm.get(3));
		System.out.println(tm);
	}

}
