//9. Given a list of integers, remove all duplicate elements and display the modified list.

package com.assignment.removeDuplicate;

import java.util.*;

public class Question9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<Integer> hs = new HashSet<>();
		
		hs.add(2);
		hs.add(3);
		hs.add(12);
		hs.add(2);
		hs.add(31);
		hs.add(2);
		
		System.out.println(hs);
	}

}
