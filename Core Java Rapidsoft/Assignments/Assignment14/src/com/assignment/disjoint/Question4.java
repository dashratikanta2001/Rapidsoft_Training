//4. Write a Java method to check if two sets, set1 and set2, are disjoint.
//(Two sets are disjoint if they have no elements in common.)

package com.assignment.disjoint;

import java.util.*;

public class Question4 {
	
	static String checkDisjoint(List<?> li1, List<?> li2)
	{
		li1.retainAll(li2);
		if(li1.isEmpty())
		{
			return "Two sets are disjoint";
		}
		else
			return "Two sets are not disjoint";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> li1 = new ArrayList<>();
		List<Integer> li2 = new ArrayList<>();
		
		li1.add(8);
		li1.add(1);
		li1.add(90);
		li1.add(45);
		
		li2.add(81);
		li2.add(11);
		li2.add(10);
		li2.add(55);
				
		System.out.println(checkDisjoint(li1, li2));
		
		
		List<String> li3 = new ArrayList<>();
		List<String> li4 = new ArrayList<>();
		
		li3.add("Ra");
		li3.add("ti");
		li3.add("ka");
		li3.add("1");
		
		li4.add("Ra1");
		li4.add("ti1");
		li4.add("ka1");
		li4.add("11");
		
		System.out.println(checkDisjoint(li3, li4));
		
	}

}
