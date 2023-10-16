package com.java.insertToDatabase;

import java.sql.*;

public class InsertJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			//creating connection
			String url="jdbc:mysql://localhost:3306/ratiTest";
			String username="root";
			String password="Admin@123";
			Connection con = DriverManager.getConnection(url,username,password);
			
			//Create a Query
			
			String q = "create table table1(tId int(20) primary key auto_increment,"
					+ "tName varchar(200) not null,"
					+ "tCity varchar(400))";
			
			//create Statement
			
			Statement stmt = con.createStatement();
			
			stmt.executeUpdate(q);
			
			System.out.println("Table created in Database....");
			
			con.close();
			 
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
