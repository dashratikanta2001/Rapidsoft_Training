package com.java.insertToDatabase;

import java.sql.*;
import java.io.*;

public class InsertDinamically {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			String url="jdbc:mysql://localhost:3306/ratiTest";
			String username="root";
			String password="Admin@123";
			Connection con = DriverManager.getConnection(url,username,password);
			
			//Create a query
			
			String q="insert into table1(tName,tCity) values(?,?)";
			//get the PreparedStatement object
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter name:");
			String name = br.readLine();
			System.out.println("Enter city:");
			String city = br.readLine();
			
			//			//set the values to the query
			//			pstmt.setString(1, "Muktiknta Dash");
			//			pstmt.setString(2, "Delhi");
			//set the values to the query
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			
			
			pstmt.executeUpdate();
			
			System.out.println("Inserted...");
			
			con.close();
					
		
		
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
