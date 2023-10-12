//7. Given a list of integers, remove all prime numbers from the list and display the modified list.

package com.assignment.removingPrimeNumber;

import java.util.*;

public class Question7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> li = new ArrayList<>();
		
		li.add(1);
		li.add(2);
		li.add(3);
		li.add(4);
		li.add(5);
		li.add(6);
		li.add(7);
		li.add(8);
		
		Iterator<Integer> it = li.iterator();
		
		while(it.hasNext())
		{
			int num=it.next();
			boolean flag=false;
			for(int i=2;i<=Math.sqrt(num);i++)
			{
				if(num%i==0)
				{
					flag=true;
					break;
				}
			}
			
			if(!flag && num!=1)
			{
				it.remove();
			}
		}
		System.out.println(li);

	}

}
