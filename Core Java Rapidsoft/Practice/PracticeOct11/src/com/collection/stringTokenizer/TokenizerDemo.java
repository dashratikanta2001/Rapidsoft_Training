package com.collection.stringTokenizer;

import java.util.*;
import java.io.*;

public class TokenizerDemo {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		//		String data ="name=Rati address=balasore country=india dept=mca";
		/*
		FileInputStream fis = new FileInputStream("MyData.txt");
		byte b[] = new byte[fis.available()];
		fis.read(b);
		String data = new String(b);
		StringTokenizer sts = new StringTokenizer(data,"=");

		String s;
		while(sts.hasMoreTokens())
		{
			s=sts.nextToken();
			System.out.println(s);
		 */

		FileInputStream fis = new FileInputStream("Data.txt");
		byte b[] = new byte[fis.available()];
		fis.read(b);

		String data = new String(b);
		
		data = data.substring(0,data.length()-1);
		
//		System.out.println(data);

		StringTokenizer sts = new StringTokenizer(data,",");

		String s;
		ArrayList<Integer> al = new ArrayList<>();
		
		while(sts.hasMoreTokens())
		{
			s=sts.nextToken();
			al.add(Integer.valueOf(s));

		}
		
		System.out.println(al);

	}

}
