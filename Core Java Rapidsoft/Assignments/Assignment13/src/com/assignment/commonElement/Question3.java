//3. Given two lists of integers, find the common elements between them and display the result.

package com.assignment.commonElement;

import java.util.*;

public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> li1 = new ArrayList<>();
		List<Integer> li2 = new ArrayList<>();
		
		li1.add(10);
		li1.add(20);
		li1.add(30);
		li1.add(40);
		li1.add(50);
		li1.add(60);
		
		li2.add(10);
		li2.add(30);
		li2.add(50);
		li2.add(70);
		li2.add(90);
		li2.add(100);
		
		li1.retainAll(li2);
		System.out.println(li1);
		
	}

}
