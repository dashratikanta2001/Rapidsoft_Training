//Question: Implement a program to find the largest element in a queue of integers without removing
//any elements from the queue.
//Input: A queue of integers.
//Output: The largest element in the queue.

package com.java;

import java.util.*;

public class Question3 {
	
	static int findLargest(Queue<Integer> que)
	{
		int max = Integer.MIN_VALUE;
		
		for (Integer val : que) {
			if(val>max)
			{
				max=val;
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> que = new ArrayDeque<>();
		que.add(10);
		que.add(20);
		que.add(78);
		que.add(99);
		que.add(1);
		
		System.out.println("Largest Element of the Queue = "+ findLargest(que));
		
	}

}
