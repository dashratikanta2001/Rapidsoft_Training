/**@author Ratikanta
 * @version 2.3
 * @sience 2023
 
 **/

package com.javadocs;

/**
 * 
 * @author Ratikanta
 *
 *Class for Library Book
 */

public class Book {
/**
 * {@value 10 default value}
 */
	static int val =10;
	
	/**
	 * Parameterised Constructor
	 * @param s Book Name
	 */
	public Book(String s)
	{
				
	}
	
	/**
	 * Issue a Boook to a Student
	 * @param roll roll number of a Student
	 * @throws Exception if book is not available throws Exception
	 */
	public void issue(int roll) throws Exception{
		
	}
	
	/**
	 * Check if book is available
	 * @param str Book Name
	 * @return if book is avaiable return true else false
	 */
	public boolean available(String str) {
		return true;
	}
	
	/**
	 * Get Book Name
	 * @param id Book Id
	 * @return returns book name
	 */
	public String getName(int id) {
		return "";
	}
}
