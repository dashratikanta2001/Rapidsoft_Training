//10 Given two lists of integers, merge them into a single list in sorted order using a collection.

package com.assignment.merge2list;

import java.util.*;

public class Question10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> li1 = new ArrayList<>();
		List<Integer> li2 = new ArrayList<>();
		
		li1.add(7);
		li1.add(5);
		li1.add(2);
		li1.add(9);
		li1.add(17);
		
		li2.add(6);
		li2.add(1);
		li2.add(8);
		li2.add(45);
		li2.add(11);
		
		li1.addAll(li2);
		Collections.sort(li1);
		
		System.out.println(li1);
		
	}

}
