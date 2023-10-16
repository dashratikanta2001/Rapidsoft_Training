package com.jdbc.practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateJDBC {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			
			Connection con = ConnectionProvider.getConnection();
			
			String q = "update table1 set tName=?, tCity=? where tId=?";
			
			BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println("Enter new Name:");
			String name = br.readLine();
			
			System.out.println("Enter new city:");
			String city = br.readLine();
			
			System.out.println("Enter the student id:");
			int id = Integer.parseInt(br.readLine());
			
			PreparedStatement pstmt = con.prepareStatement(q);
			
			pstmt.setString(1, name);
			pstmt.setString(2, city);
			pstmt.setInt(3, id);
			
			pstmt.executeUpdate();	
			
			System.out.println("Done.....");
			
			con.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
