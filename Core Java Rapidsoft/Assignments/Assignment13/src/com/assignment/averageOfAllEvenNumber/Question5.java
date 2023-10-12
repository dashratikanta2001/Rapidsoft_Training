//5. Given a list of integers, find the average of all even numbers using a collection.

package com.assignment.averageOfAllEvenNumber;

import java.util.*;

public class Question5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		List<Integer> li = new ArrayList<>();
		
		System.out.println("Enter number of entry");
		int size = sc.nextInt();
		int i=0,sum=0,avg=0,count=0;
		System.out.println("Enter numbers");
		while(i<size)
		{
			li.add(sc.nextInt());
			i++;
		}
		
		for(int x:li)
		{
			if(x%2==0)
			{
				sum+=x;
				count++;
			}
		}
		
//		Iterator<Integer> it = li.iterator();
//		
//		while(it.hasNext())
//		{
//			int num=it.next();
//			if(num%2==0)
//			{
//				sum+=num;
//				count++;
//			}
//		}
		avg = sum/count;
		System.out.println("Average of all even number = "+avg);

	}

}
