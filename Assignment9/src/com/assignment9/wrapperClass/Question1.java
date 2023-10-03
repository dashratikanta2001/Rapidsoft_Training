// Write a program that creates an array of wrapper class objects (Integer, Double, etc.),
//assigns values to them, and calculates the sum of the array elements.

package com.assignment9.wrapperClass;

public class Question1 {
	
	static Integer intarr(Integer [] a)
	{
		Integer sum=0;
		for(Integer i:a)
		{
			sum+=i;
		}
		return sum;
	}
	static Double doublearr(Double [] a)
	{
		Double sum=0.0;
		for(Double i:a)
		{
			sum+=i;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer [] arr1 = {1,2,3,4,5,6,7,8,9};
		Double [] arr2 = {10.1,11.1,12.1,13.1,14.1,15.1,16.1,17.1,18.1,19.1};
		
		System.out.println("The sum of all given integer = "+ intarr(arr1));
		
		System.out.println("The sum of all given integer = "+ doublearr(arr2));

	}

}
