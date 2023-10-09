package com.randomAccessFile;

import java.io.*;

public class RandomFile {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		RandomAccessFile rf = new RandomAccessFile("Text.txt", "rw");
		
		System.out.println((char)rf.read());		System.out.println((char)rf.read());
		System.out.println((char)rf.read());
		System.out.println((char)rf.read());

		rf.write('d');
		System.out.println((char)rf.read());
		System.out.println((char)rf.read());
		
		rf.skipBytes(3);
		System.out.println((char)rf.read());

		rf.seek(3);
		System.out.println((char)rf.read());
		System.out.println(rf.getFilePointer());
		rf.seek(rf.getFilePointer()+2);
		System.out.println(rf.getFilePointer());
		
	}

}
