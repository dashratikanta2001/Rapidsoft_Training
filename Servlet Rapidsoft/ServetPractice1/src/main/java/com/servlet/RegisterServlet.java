package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

//		out.println("<h2>Welcome to register servlet</h2>");

		String name = req.getParameter("user_name");
		String password = req.getParameter("user_password");
		String email = req.getParameter("user_email");
		String gender = req.getParameter("user_gender");
		String course = req.getParameter("user_course");

		String cond = req.getParameter("condition");

		if (cond != null) {
			out.println("<h2>You have not acceted terms and conditions</h2>");
		 if (cond.equals("checked")) {
			out.println("<h2> Name: " + name + "</h2>");
			out.println("<h2> Password: " + password + "</h2>");
			out.println("<h2> Email: " + email + "</h2>");
			out.println("<h2> Gender: " + gender + "</h2>");
			out.println("<h2> Course: " + course + "</h2>");
			
			//
			//JDBC
			//
			
			//saved to db
			//
			RequestDispatcher rd = req.getRequestDispatcher("success");
			rd.forward(req, resp);
			
		 } else {
			out.println("<h2>You have not acceted terms and conditions</h2>");
		}
		}
		 else {
				out.println("<h2>You have not acceted terms and conditions</h2>");

			//I want to include output of index.html
			
			//Get the object of RequestDispatcher
			
			RequestDispatcher rd = req.getRequestDispatcher("index.html");
			
			//include
			
			rd.include(req, resp);
		}

	}
}
