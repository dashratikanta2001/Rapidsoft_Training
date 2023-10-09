package com.fileReadWrite;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceInputStreamPractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream fin1 = new FileInputStream("Source1.txt");
		FileInputStream fin2 = new FileInputStream("Source1.txt");
		FileOutputStream fos = new FileOutputStream("Destination.txt");
		
		SequenceInputStream sin = new SequenceInputStream(fin1,fin2);

		int b;
		while((b=sin.read())!=-1)
		{
			fos.write(b);
		}
		
		try (FileInputStream fin3 = new FileInputStream("Destination.txt")) {
			byte b2[] = new byte[fin3.available()];
			fin3.read(b2);
			String str2 = new String(b2);
			System.out.println(str2);
		}
		
		sin.close();
		fos.close();
		fin1.close();
		fin2.close();
	}

}
