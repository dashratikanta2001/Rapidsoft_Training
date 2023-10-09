package com.fileReadWrite;
import java.io.*;

public class Byte_Array_Input_Stream {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		byte b[] = {'a','b','c','d','e','f','g','h','i','j'};
		
		ByteArrayInputStream bis = new ByteArrayInputStream(b);
		
//		int x;
//		while((x = bin.read())!=-1)
//		{
//			System.out.print((char)x);
//		}
		
//		String str = new String(bis.readAllBytes());
//		System.out.println(str);
		
		bis.close();
	}

}
