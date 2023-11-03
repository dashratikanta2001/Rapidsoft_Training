package com.rapidEmp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.config.Config;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html");
LocalDate currentDate = LocalDate.now();
DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		
		PrintWriter out = response.getWriter();
		try {
			Thread.sleep(1000);
		
		String fname = request.getParameter("user_fname");
		String lname = request.getParameter("user_lname");
		String email = request.getParameter("user_email");
		String dob = request.getParameter("user_dob");
		String phno = request.getParameter("user_phno");
		String empcode = request.getParameter("user_empcode");
		String password = request.getParameter("user_password");
		String gender = request.getParameter("user_gender");
		
		
		String query = "insert into rapidians (fname, lname, email, dob, phoneno, empcode, password, gender,join_date) values(?,?,?,?,?,?,?,?,?)";
		
		PreparedStatement pstmt = Config.databaseCon().prepareStatement(query);
		
		pstmt.setString(1, fname);
		pstmt.setString(2, lname);	
		pstmt.setString(3, email);	
		pstmt.setString(4, dob);
		pstmt.setString(5, phno);
		pstmt.setString(6, empcode);
		pstmt.setString(7, password);
		pstmt.setString(8, gender);
		pstmt.setString(9, currentDate.format(formatter));
		
		pstmt.executeUpdate();
		out.println("success");
		out.println(fname);
		
//		System.out.println("Query updated Successfully");
		
		} catch (SQLIntegrityConstraintViolationException e) {
			// TODO: handle exception
			out.println("Employee code or Phone number already Exist");
//			System.out.println("Duplicate Entry");
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println("error");
		}
	}

}
