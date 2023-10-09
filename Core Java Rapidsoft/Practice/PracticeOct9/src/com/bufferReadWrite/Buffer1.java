package com.bufferReadWrite;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class Buffer1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
//		FileInputStream fin = new FileInputStream("Text.txt");
//		BufferedInputStream bin = new BufferedInputStream(fin);
		
		// it works perfectly
		FileReader fin = new FileReader("Text.txt");
		BufferedReader bin = new BufferedReader(fin);
		
//		System.out.println("File: "+fin.markSupported());
		System.out.print((char)bin.read());
		System.out.print((char)bin.read());
		System.out.print((char)bin.read());
		bin.mark(2);
		System.out.print((char)bin.read());
		System.out.print((char)bin.read());			System.out.print((char)bin.read());
		System.out.print((char)bin.read());			System.out.print((char)bin.read());
		
		bin.reset();
		System.out.print((char)bin.read());
		System.out.print((char)bin.read());
		
		
//		System.out.println("Buffer: "+ bin.markSupported());
		
		
		System.out.println("String: "+bin.readLine());
	}

}
