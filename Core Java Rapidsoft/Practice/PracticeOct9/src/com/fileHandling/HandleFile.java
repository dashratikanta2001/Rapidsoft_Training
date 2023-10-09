package com.fileHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class HandleFile {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

//		File f = new File("/home/rapidsoft/Documents/practice/PracticeOct9");
//		System.out.println(f.isDirectory());
//		String list[] =f.list();
//		File list2[] = f.listFiles();
//		for(File x:list2)
//		{
//			System.out.println(x.getParentFile());
//		}
		
		File f = new File("Text.txt");
//		f.setReadOnly();
//		f.setWritable(true);
//		f.setReadable(true);
		System.out.println(f.lastModified());
//		FileOutputStream fos = new FileOutputStream("Text.txt");
	}

}
