// 1) all the checked and unchecked exceptions use with attach screenshots for each.

package com.assignment10;

import java.io.*;

public class Question1 {
	
	static void checkedException()
	{
		System.out.println("Checked Exception\n");

		//ClassNotFoundException
		try {
			Class.forName("Class not found exception");
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		
		//IOException
		try {
	        FileReader fileReader = new FileReader("Test.txt");
	    
	        System.out.println(fileReader.read());
	    
	        fileReader.close();
	    }
	    catch (IOException e) {
	        System.out.println(e);
	    }
		
		//FileNotFoundException
		try {
			File newFile = new File("Demo.txt");
			FileReader fr = new FileReader(newFile);
		} catch (FileNotFoundException e) {
			System.out.println(e);
		}
	}
	
	static void unCheckedException()
	{
		System.out.println("\nUnChecked Exception\n");
		
		//ArithmeticException
		try {
			int value1 = 10;
			int value2 = 0;
			
			int result = value1/value2;
			System.out.println(result);
			
		} catch(ArithmeticException e) {
//			e.printStackTrace();
			System.out.println(e);
			
		}
		
		//ArrayIndexOutOfBoundsException
		int arr[] = {10,20,30,40};
		try {
			System.out.println(arr[10]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
		
		//NullPointerException
		try {
			Question1 q1 = null;
			System.out.println(q1.value);
		} catch(NullPointerException e) {
			System.out.println(e);
		}
		
		//NumberFormatException
		try {
			String str = "Ratikanta";
			Integer intValue = Integer.parseInt(str);
			System.out.println(intValue);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}

	}
	
	int value=100;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		checkedException();
		unCheckedException();

	}

}
