//Question: Implement a program to reverse the order of elements in a queue.
//Input: A queue of integers.
//Output: The same queue with elements reversed.

package com.java;

import java.util.*;

public class Question1 {
	
	static Queue<Integer> reverseQue(Queue<Integer> que)
	{
		Stack<Integer> st = new Stack<>();
		while(!que.isEmpty())
		{
			st.add(que.remove());
		}
		while(!st.isEmpty())
		{
			que.add(st.pop());
		}
		return que;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue<Integer> que = new LinkedList<>();
		que.offer(10);
		que.offer(20);
		que.offer(30);
		que.offer(40);
		que.offer(50);
		que.offer(60);
		que.offer(70);
		que.offer(80);
		que.offer(90);
		System.out.println("Original Queue: "+ que);
		System.out.println("Reversed Queue: "+reverseQue(que));
		
		
	}

}
