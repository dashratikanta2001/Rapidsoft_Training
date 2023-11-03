package com.rapidEmp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.config.Config;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		try {

			String phno = request.getParameter("user_phno");
			String password = request.getParameter("user_password");
			String query = "select * from rapidians where phoneno=? and password=?";

			PreparedStatement pstmt = Config.databaseCon().prepareStatement(query);

			pstmt.setString(1, phno);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {

				out.print(htmlhead());
				
				out.print("<td>"+rs.getString("fname")+" "+rs.getString("lname")+"</td>");
				out.print("<td>"+rs.getString("email")+"</td>");
				out.print("<td>"+rs.getString("dob")+"</td>");
				out.print("<td>"+rs.getString("phoneno")+"</td>");
				out.print("<td>"+rs.getString("empcode")+"</td>");
				out.print("<td>"+rs.getString("gender")+"</td>");
				
				out.print(htmlend());

			} else {
				out.print("Invalid Cridential");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String htmlhead() {
		// TODO Auto-generated method stub

		return "		<div class=\"col m10 offset-m1\" style=\"font-size:20px;\">\n"
				+ "\n"
				+ "				<div class=\"card\">\n"
				+ "					<div class=\"card-content indigo lighten-1 center white-text\">\n"
				+ "					<h2 class=\"red-text\">Employee detail</h2>\n"
				+ "						<table class=\"responsive-table\">\n"
				+ "							<thead>\n"
				+ "								<tr>\n"
				+ "									<th>Name</th>\n"
				+ "									<th>Email</th>\n"
				+ "									<th>Date of Birth</th>\n"
				+ "									<th>Phone No</th>\n"
				+ "									<th>Employee Code</th>\n"
				+ "									<th>Gender</th>\n"
				+ "								</tr>\n"
				+ "							</thead>\n"
				+ "\n"
				+ "							<tbody>\n"
				+ "								<tr>";

	}

	private String htmlend() {
		// TODO Auto-generated method stub
		return "								</tr>\n"
				+ "							</tbody>\n"
				+ "						</table>\n"
				+ "						<form action=\"Colleague-list\" method=\"post\">\n"
				+ "							<button type=\"submit\"\n"
				+ "								class=\"waves-effect waves-light btn-large red\"\n"
				+ "								style=\"margin-top: 5em;\">Colleague List</button>\n"
				+ "						</form>\n"
				+ "\n"
				+ "					</div>\n"
				+ "				</div>\n"
				+ "			</div>\n";
				
	}

}
