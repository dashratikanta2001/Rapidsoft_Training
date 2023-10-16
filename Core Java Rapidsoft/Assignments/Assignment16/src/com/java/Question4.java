//Question: Write a Java program to simulate a call center. Implement a function that takes a queue of 
//customer calls and processes them in a fair manner, where each customer is served in a round-robin 
//fashion.
//Input: A queue of customer calls, where each call is represented by a string.
//Output: The processed customer calls in the order they were received.


package com.java;

import java.util.*;

public class Question4 {
	
	static void customerCall(Queue<String> que)
	{
		for (String cust : que) {
			System.out.println(cust);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue<String> que = new ArrayDeque<String>();
		que.add("Customer-1");
		que.add("Customer-2");
		que.add("Customer-7");
		que.add("Customer-5");
		que.add("Customer-3");
		que.add("Customer-6");
		
		System.out.println("Customer Queue = "+que);
		System.out.println("Processed Customer call serial: ");
		customerCall(que);

	}

}
