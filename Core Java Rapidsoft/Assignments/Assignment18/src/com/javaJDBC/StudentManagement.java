//Question:
//i) write the code on the existing project to get all student data from data base.
//ii) prepare statement for update and delete data from database.
//iii) also take input as 5 to exit the project.

package com.javaJDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class StudentManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String message = "\nShow all student -> Enter 1"
				+ "\nInsert student  -> Enter 2"
				+ "\nUpdate student  -> Enter 3"
				+ "\nDelete student  -> Enter 4"
				+ "\nExit            -> Enter 5";
		String flag;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {

			Connection con = ConnectorJava.getConnection();

			//Creating table
			/*
			  String tableq = "create table student (stdId int(20) primary key auto_increment,"
					+ "name varchar(50) not null,"
					+ "physics int(3),"
					+ "chemistry int(3),"
					+ "math int(3))";

			Statement stmt = con.createStatement();
			stmt.executeUpdate(tableq);
			System.out.println("Table created Successfully");
			 */

			do {
				System.out.println(message);
				flag=br.readLine();
				switch (flag) {
				case "1":
					//Show data query
					String showQuery = "select * from student";
					PreparedStatement showPstmt = con.prepareStatement(showQuery);
					ResultSet set= showPstmt.executeQuery(showQuery);
					System.out.println("StudentID |  Name | Physics  | Chemistry | Math");
					System.out.println("_____________________________________________________");
					while(set.next())
					{
						System.out.print(" "+set.getInt(1)+"     ");
						System.out.print(set.getString(2)+"      ");
						System.out.print(set.getInt(3)+"      ");
						System.out.print(set.getInt(4)+"      ");
						System.out.print(set.getInt(5)+"      ");
						System.out.println();						
					}

					break;
				case "2":
					//Insert data to query;
					String insQuery = "insert into student (name,physics,chemistry,math) values(?,?,?,?)";
					PreparedStatement insPstmt = con.prepareStatement(insQuery);
					System.out.println("Enter name :");
					insPstmt.setString(1, br.readLine());
					System.out.println("Enter Mark of Physics :");
					insPstmt.setInt(2, Integer.parseInt(br.readLine())); 
					System.out.println("Enter Mark of Chemistry :");
					insPstmt.setInt(3, Integer.parseInt(br.readLine())); 
					System.out.println("Enter Mark of Math :");
					insPstmt.setInt(4, Integer.parseInt(br.readLine())); 
					insPstmt.executeUpdate();
					System.out.println("Student added successfully");

					break;
				case "3":
					//update data query
					String field="", name=null;
					int mark = 0;
					
					System.out.println("Enter student id  for perform update operation:");
					int stdId = Integer.parseInt(br.readLine());
					
					System.out.println("Update name enter 1\nUpdate Physics mark enter 2\nUpdate Chemistry mark enter 3\nUpdate Physics mark enter 4\n");
					switch (Integer.parseInt(br.readLine())) {
					case 1:
						field="name";
						System.out.println("Enter name:");
						name= br.readLine();
						break;
					case 2:
						field= "physics";
						System.out.println("Enter Physics mark:");
						mark=Integer.parseInt(br.readLine());
						break;
					case 3:
						field= "chemistry";
						System.out.println("Enter Chemistry mark:");
						mark=Integer.parseInt(br.readLine());
						break;
					case 4:
						field= "math";
						System.out.println("Enter Math mark:");
						mark=Integer.parseInt(br.readLine());
						break;

					default:
						System.out.println("Invalid Entry");
						break;
					}
					try {
						String updQuery = "update student set "+field+" =? where stdId=?";
						PreparedStatement updPstmt = con.prepareStatement(updQuery);
						updPstmt.setInt(2, stdId);
						if(name!=null)
						{
							updPstmt.setString(1, name);
						}
						else
						{
							updPstmt.setInt(1, mark);
						}
						updPstmt.executeUpdate();
						System.out.println("Updated successfully");
						
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println(e.getMessage());
					}
					break;
				case "4":
					//delete data query
					String delQuery = "delete from student where stdId=?";
					PreparedStatement delPstmt=con.prepareStatement(delQuery);
					System.out.println("Enter student id  to delete student :");
					delPstmt.setInt(1, Integer.parseInt(br.readLine()));
					delPstmt.executeUpdate();
					System.out.println("Student deleted successfully");

					break;

				case "5":
					System.out.println("Thank you ...........");
					break;
				default:
					System.out.println("Invalid Entry");
					System.out.println("Thank you ...........");
					break;
				}

			} while (flag.contains("1")||flag.contains("2")||flag.contains("3")||flag.contains("4"));


			con.close();


		} catch (Exception e) {
			// TODO: handle exception
			//			System.out.println(e);
//			e.printStackTrace();
		}
	}

}
