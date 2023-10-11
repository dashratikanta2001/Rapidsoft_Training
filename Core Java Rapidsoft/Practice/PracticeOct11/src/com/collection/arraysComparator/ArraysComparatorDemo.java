package com.collection.arraysComparator;
import java.util.*;

class My implements Comparator<Integer>
{
	public int compare(Integer i1, Integer i2)
	{
		if(i1<i2)
			return 1;
		if(i1>i2)
			return -1;
		return 0;
	}
}

public class ArraysComparatorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[]= {2 ,4,6,8,1,3,5,7};
		int b[]= {2,4,6,8,1,3,5,7};
		
//		System.out.println(Arrays.compare(a, b));
		
		int c[] = Arrays.copyOf(a, a.length);
//		Arrays.fill(c, 10);
//		Arrays.sort(c);
//		Arrays.parallelSort(c);
//		for(int x:c)
//			System.out.println(x); 
		
//		System.out.println(Arrays.binarySearch(c, 1));

		Integer d[]= {2 ,4,6,8,1,3,5,7};
		Arrays.sort(d,new My());
		
		for(Integer x:d)
			System.out.println(x);
		
	}

}
