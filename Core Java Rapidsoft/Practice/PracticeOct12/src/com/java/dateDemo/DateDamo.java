package com.java.dateDemo;

import java.util.*;

public class DateDamo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		System.out.println(System.currentTimeMillis());
//		System.out.println(System.currentTimeMillis()/1000/60/60/24/365);
//		System.out.println(Long.MAX_VALUE);
//		Date d = new Date();
//		System.out.println();
		
		//Calender
		 
		GregorianCalendar g = new GregorianCalendar();
		
		g.setTimeZone(TimeZone.getTimeZone("America/Los_angeles"));
		
		TimeZone tz = g.getTimeZone();
		System.out.println(tz.getDisplayName());
		System.out.println(tz.getID());
		
//		System.out.println(g.get(Calendar.DATE));
//		System.out.println(g.get(Calendar.DAY_OF_WEEK));
//		System.out.println(g.get(Calendar.DAY_OF_YEAR));
		
		
		
	}

}
