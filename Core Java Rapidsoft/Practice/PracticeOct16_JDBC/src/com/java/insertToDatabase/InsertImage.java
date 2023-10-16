package com.java.insertToDatabase;

import java.sql.*;
import java.io.*;

public class InsertImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			String url="jdbc:mysql://localhost:3306/ratiTest";
			String username="root";
			String password="Admin@123";
			Connection con = DriverManager.getConnection(url,username,password);
			
			String q = "insert into images(pic) values(?)";
			
			PreparedStatement pstmt = con.prepareStatement(q);
//			pstmt.setString(1, "value");
			FileInputStream fis = new FileInputStream("/home/rapidsoft/Downloads/download1.jpeg");
			pstmt.setBinaryStream(1, fis,fis.available());
			
			pstmt.executeUpdate();
			
			System.out.println("Done......");
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
//			e.printStackTrace();
			System.out.println("Error !!");
		}

	}

}
