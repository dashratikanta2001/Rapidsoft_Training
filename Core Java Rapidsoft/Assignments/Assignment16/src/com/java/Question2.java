//Question: Write a Java program to simulate a printing queue. Implement a function that takes a queue 
//of print jobs as input and prints them in the order they were added to the queue.
//Input: A queue of print jobs, where each job is represented by a string.
//Output: The print jobs printed in the order they were added.

package com.java;

import java.util.*;

public class Question2 {
	
	static void printQue(Queue<String> que)
	{
		for (Iterator<String> it = que.iterator(); it.hasNext();) {
			System.out.println(it.next());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<String> que = new LinkedList<String>();
		que.add("Wake-up");
		que.add("Get Ready");
		que.add("Go to Office");
		que.add("Go to home");
		que.add("Sleep");
		
		printQue(que);

	}

}
