//8. Given a list of strings, find the longest word using a collection.

package com.assignment.longestWord;

import java.util.*;

public class Question8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		List<String> hs = new ArrayList<>();
		
		hs.add("I");
		hs.add("am");
		hs.add("Rati");
		hs.add("ThisIsTheLongestWord");
		hs.add("Kanta");
		hs.add("Dash");
		String longWord = Collections.max(hs,(st1,st2)->st1.length()-st2.length());
		System.out.println(longWord);

	}

}
