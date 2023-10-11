//2. Given a list of integers, find the second smallest element using a collection.

package com.assignment.secondSmallestElement;

import java.util.*;

public class Question2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> hs = new ArrayList<>();
		hs.add(10);
		hs.add(20);
		hs.add(1);
		hs.add(89);
		hs.add(56);
		hs.add(100);
		hs.add(99);
		Collections.sort(hs);
		
		System.out.println(hs.get(1));

	}

}
