package com.fileReadWrite;

import java.io.ByteArrayOutputStream;
import java.io.CharArrayReader;
import java.io.FileOutputStream;
import java.io.IOException;

public class Byte_Array_Output_Stream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		//ByteArrayReader
		/*
		ByteArrayOutputStream bos = new ByteArrayOutputStream(20);
		bos.write('a');
		bos.write('b');
		bos.write('c');
		bos.write('d');
		
//		byte b[] = bos.toByteArray();
//		
//		for(byte x:b)
//			System.out.println((char)x);
		
		bos.writeTo(new FileOutputStream("/home/rapidsoft/Documents/practice/PracticeOct9/Text.txt"));
		
		
		bos.close();
		*/
		
		//CharArrayReader
		
		char c[] = {'a','b','c','d','e','f'};
		CharArrayReader cr = new CharArrayReader(c);
		
		int x;
		while((x=cr.read())!=-1)
		{
			System.out.print((char)x);
		}
		cr.close();
	}

}
