package com.collection.list;

import java.util.*;

public class LinkedListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> al1 = new LinkedList<>();
		
		ArrayList<Integer> al2 = new ArrayList<>(5);
		al2.add(50);
		al2.add(60);
		al2.add(70);
		al2.add(80);
		
		
		al1.add(10);
		al1.add(0, 5);
		al1.addAll(1,al2);
		al1.add(5, 70);
		
		al1.addFirst(1); 
		al1.addLast(200);
		
		al1.descendingIterator().forEachRemaining(n->show(n));
	}

	
	static void show(int n)
	{
//		if(n>60)
			System.out.println(n);
	}
}
