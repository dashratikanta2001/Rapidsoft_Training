package com.fileReadWrite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CopyData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			//File Write
			FileOutputStream fos = new FileOutputStream("Source1.txt");

			String str = "JAVA PROGRAMMING LANGUAGE\nTEST FILE\nCOPY DATA FROM ONE FILE TO ANOTHER FILE";

			fos.write(str.getBytes());
			fos.close();

			//File read
			try (
			FileInputStream fis = new FileInputStream("Source1.txt");
					FileOutputStream fos2 = new FileOutputStream("Source2.txt")) {
				int x;
				while((x=fis.read())!=-1)
				{
					if(x>=65 && x<=97)
						fos2.write(x+32);
					else
						fos2.write(x);
				}
			}
			try (FileInputStream fis2 = new FileInputStream("Source2.txt")) {
				byte b[] = new byte[fis2.available()];
				fis2.read(b);
				String str2 = new String(b);
				System.out.println(str2);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
