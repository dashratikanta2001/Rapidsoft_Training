//6. Given a list of words, arrange them in ascending order of their lengths using a collection.

package com.assignment.arrangeWordinAscInLength;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Question6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> li = new ArrayList<>();
		li.add("Rati");
		li.add("Kanta");
		li.add("Hello");
		li.add("bye");
		li.add("Rapidsoft");
		li.add("Rt");
		li.add("Dash");
		
		Collections.sort(li,(st1,st2)->st1.length()-st2.length());
		System.out.println(li);

	}

}
