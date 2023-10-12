//5. Given two sets of integers, write a Java method to find the intersection of the two sets 
//(i.e., the elements present in both sets).

package com.assignment.insertion;

import java.util.*;

public class Question5 {
	
	static HashSet<Integer> insertion(HashSet<Integer> hs1, HashSet<Integer> hs2)
	{
		hs1.retainAll(hs2);
		return hs1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<Integer> hs1 = new HashSet<>();
		HashSet<Integer> hs2 = new HashSet<>();
		
		hs1.add(8);
		hs1.add(8);
		hs1.add(1);
		hs1.add(90);
		hs1.add(45);
		
		hs2.add(8);
		hs2.add(11);
		hs2.add(90);
		hs2.add(55);
				
		System.out.println("Element Present in both sets are: "+insertion(hs1, hs2));
	}

}
