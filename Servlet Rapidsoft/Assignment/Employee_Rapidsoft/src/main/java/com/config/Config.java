package com.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Config {
	public Config() {
		// TODO Auto-generated constructor stub
		
	}
	
	public static Connection databaseCon() {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			 Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/ratiTest","root","Admin@123");
			 return con;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
