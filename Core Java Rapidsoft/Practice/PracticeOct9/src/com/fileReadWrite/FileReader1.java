package com.fileReadWrite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class FileReader1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		try {
			try (FileOutputStream fos = new FileOutputStream("Text.txt")) {

				String str = "Learn Java Programming";

				byte b[] = str.getBytes();

				//for(byte x: b)
				//fos.write(x);

				fos.write(b);

				//			fos.write(str.getBytes());
				fos.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		*/
		
//		try (FileInputStream fin = new FileInputStream("Text.txt");) {
//			
//			
////			byte b[] = new byte[fin.available()];
////			fin.read(b);
////			String str = new String(b);
////			System.out.println(str);
//			
//			int x;
//			while((x=fin.read())!=-1)
//			{
//				System.out.print((char)x);
//			}
//			
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e);
//		}
		
		
try (FileReader fin = new FileReader("Text.txt");) {
			
			
//			byte b[] = new byte[fin.available()];
//			fin.read(b);
//			String str = new String(b);
//			System.out.println(str);
			
			int x;
			while((x=fin.read())!=-1)
			{
				System.out.print((char)x);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		
	}

}
