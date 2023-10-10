package com.collection.list;

import java.util.*;

public class ArrayListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> al1 = new ArrayList<>(20);
		
		ArrayList<Integer> al2 = new ArrayList<>(5);
		al2.add(50);
		al2.add(60);
		al2.add(70);
		al2.add(80);
		
		
		al1.add(10);
		al1.add(0, 5);
		al1.addAll(1,al2);
		al1.add(5, 70);
		
//		System.out.println(al1);
//		System.out.println(al2);
//		
//		System.out.println(al1.contains(20));
//		System.out.println(al1.get(2));
//		System.out.println(al1.indexOf(70));
//		System.out.println(al1.lastIndexOf(70));
		al1.set(6, 90);
//		System.out.println(al1);
		
		al1.forEach(n->show(n));
	}

	
	static void show(int n)
	{
		if(n>60)
			System.out.println(n);
	}
}
