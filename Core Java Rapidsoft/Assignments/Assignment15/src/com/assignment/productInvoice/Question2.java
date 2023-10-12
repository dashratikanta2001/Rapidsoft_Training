//2. Given a map of product names and their corresponding prices, write a Java method to 
//calculate the total cost of all the products in the map, print the output as like invoice.

package com.assignment.productInvoice;

import java.util.*;

public class Question2 {
	
	static void printInvoice(HashMap<String, Double> hs)
	{
		String s="   Product     |    Price"
				+ "\n______________________________";
		
		double total =0;
		System.out.print(s);
		int i=1;
		
		for (Map.Entry<String, Double> prod : hs.entrySet()) {
			total+=prod.getValue();
			System.out.printf("\n%d. %-12s:   %10.2f", i++,prod.getKey(),prod.getValue());		
		}
		System.out.println("\n               ______________");
		System.out.println("\n              TOTAL: "+total);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Double> hs = new HashMap<>();
		hs.put("Laptop",40500.00);
		hs.put("Processor", 15000.00);
		hs.put("Monitor", 12000.00);
		hs.put("CPU", 30420.50);
		hs.put("Keyboard", 500.50);
		hs.put("Mouse", 250.00);
		hs.put("Mouse Combo", 750.11);
		
		printInvoice(hs);
	}

}
