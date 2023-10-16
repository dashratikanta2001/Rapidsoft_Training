//Question: Implement a program to sort a queue of integers in ascending order without using any 
//additional data structures.
//Input: A queue of integers.
//Output: The same queue with integers sorted in ascending order.

package com.java;

import java.util.*;

public class Question5 {
	
	static Queue<Integer> sortQue(Queue<Integer> que)
	{
		int min = Integer.MAX_VALUE;
		Queue<Integer> sortQue = new ArrayDeque<Integer>();
		
		for (Integer val : que) {
			if(val<min)
			{
				min=val;
				sortQue.add(min);
			}
		}
		
		return sortQue;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> que = new ArrayDeque<Integer>();
		
		que.add(9);
		que.add(3);
		que.add(80);
		que.add(15);
		que.add(56);
		que.add(10);
		
		System.out.println("Sorted Queue = "+sortQue(que));
	}

}
