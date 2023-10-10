package com.genericdemo;

public class GenericDemo<T> {
	
	T data[]=(T[])new Object[3];

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Object obj = new String("Hello");
//		obj = new Integer(10);
//		String str = (String) obj;

//		Object obj[] = new Object[3];
//		obj[0]="HI";
//		obj[1]="Hello";
//		obj[2]=new Integer(10);
//		
//		String str;
//		for(int i=0;i<3;i++)
//		{
//			str= (String)obj[i];
//			System.out.println(str);
//		}
		
		
		//Generic 
		
		GenericDemo<String> gd = new GenericDemo();
		gd.data[0]="Hi";
		gd.data[1]="Bye";
//		gd.data[2]= new Integer(10);
		
		String str = gd.data[0];
	}

}
