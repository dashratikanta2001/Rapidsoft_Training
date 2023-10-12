//2. Write a Java method that takes two sets, set1 and set2, as parameters and returns a new set 
//that contains the elements present in set1 but not in set2.

package com.assignment.removeElement;

import java.util.*;

public class Question2 {

	static List<?> removeElement(List<?> li1, List<?> li2)
	{		
		Iterator<?> it = li1.iterator();

		while(it.hasNext())
		{
			if(li2.contains(it.next()))
				it.remove();
		}

		return li1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> li1 = new ArrayList<>();
		li1.add(10);
		li1.add(20);
		li1.add(30);

		List<Integer> li2 = new ArrayList<>();
		li2.add(20);
		li2.add(80);
		System.out.println(removeElement(li1, li2));


		List<String> li3 = new ArrayList<>();
		li3.add("I");
		li3.add("Am");
		li3.add("Rati");

		List<String> li4 = new ArrayList<>();
		li4.add("Rati");
		li4.add("Kanta");
		li4.add("Dash");

		System.out.println(removeElement(li3, li4));

	}

}
