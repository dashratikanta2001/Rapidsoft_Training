//1. Given a set of integers, write a Java method to find the maximum and minimum values in the set.

package com.assignment.maxMinInSet;
import java.util.*;

public class Question1 {
	
	static int maximum(List<Integer> li)
	{
		int max=Integer.MIN_VALUE;
		
		for(int i:li)
		{
			if(max<i)
				max=i;
		}
		
		return max;
	}
	
	static int minimum(List<Integer> li)
	{
		int max=Integer.MAX_VALUE;
		
		for(int i:li)
		{
			if(max>i)
				max=i;
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> li = new ArrayList<>();
		
		li.add(5);
		li.add(1);
		li.add(90);
		li.add(20);
		System.out.println("Maximum = "+maximum(li));
		System.out.println("Minimum = "+minimum(li));

	}

}
