package com.java.dateDemo.jodaDateTime;

import java.util.*;
import java.time.*;
import java.time.temporal.*;

public class JodaTimeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		Date d = new Date();
//		d.setHours(21);
//		System.out.println(d);
//		
		LocalDate d = LocalDate.now();
		System.out.println(d);
		
		LocalDate dt = LocalDate.now(ZoneId.of("Asia/Kolkata"));
		System.out.println(dt);
		
		LocalDate d2 = LocalDate.of(2020, Month.APRIL, 10);
		System.out.println(d2);
		
		LocalDate d3 = LocalDate.ofEpochDay(1);
		System.out.println(d3);
		
		LocalDate d4 = LocalDate.parse("2020-01-03");
		System.out.println(d4);
		
		LocalTime t = LocalTime.now();
		System.out.println(t);
		System.out.println(t.minusHours(9));
		System.out.println(t);
		
	}

}
