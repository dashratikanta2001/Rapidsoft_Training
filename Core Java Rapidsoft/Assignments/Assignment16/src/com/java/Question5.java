//Question: Implement a program to sort a queue of integers in ascending order without using any 
//additional data structures.
//Input: A queue of integers.
//Output: The same queue with integers sorted in ascending order.

package com.java;

import java.util.*;

public class Question5 {
	
	static void sortQue(PriorityQueue<Integer> que)
	{
		for(Integer num:que)
		{
			System.out.print(num+", ");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PriorityQueue<Integer> que = new PriorityQueue<>();
		
		que.add(9);
		que.add(3);
		que.add(80);
		que.add(15);
		que.add(56);
		que.add(10);
		
		sortQue(que);
	}

}
