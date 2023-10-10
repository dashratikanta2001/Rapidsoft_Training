package com.collection.list;
import java.util.*;

public class TreesetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> al2 = new ArrayList<>(5);
		al2.add(10);
		al2.add(30);
		al2.add(50);
		al2.add(70);
		al2.add(10);
		al2.add(40);
		
		TreeSet<Integer> ts = new TreeSet<>(al2);
		ts.add(25);
		System.out.println(ts.ceiling(50));
		
		System.out.println(ts);
		
		
		ArrayList<String> al21 = new ArrayList<>(5);
		al21.add("Hello");
		al21.add("I am");
		al21.add("Rati");
		al21.add("Kanta");
		al21.add("Dash");
		al21.add("From");
		al21.add("A");
		al21.add("a");
		
		TreeSet<String> ts1 = new TreeSet<>(al21);
		ts1.add("BBSR");
//		System.out.println(ts1.ceiling(50));
		
		System.out.println(ts1);
	}

}
