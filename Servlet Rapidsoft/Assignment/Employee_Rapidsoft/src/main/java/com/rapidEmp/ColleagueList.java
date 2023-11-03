package com.rapidEmp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Format;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.config.Config;

/**
 * Servlet implementation class ColleagueList
 */
@WebServlet("/Colleague-list")
public class ColleagueList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ColleagueList() {
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
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		try {
			
			String query = "SELECT * FROM rapidians ORDER BY empcode";
			PreparedStatement pstmt = Config.databaseCon().prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				out.println(htmlHead());
				do {
					out.print("<tr>");
					out.print("<td>"+rs.getString("fname")+" "+rs.getString("lname")+"</td>");
					out.print("<td>"+rs.getString("empcode")+"</td>");
					out.print("<td>"+rs.getString("phoneno")+"</td>");
					rs.getDate("dob");
					LocalDate dob = LocalDate.parse(rs.getString("dob"),formatter);
					int age = currentDate.getYear() - dob.getYear();
					out.print("<td>"+age+"</td>");
					LocalDate doj = LocalDate.parse(rs.getString("join_date"),formatter);
					Period period = Period.between(doj, currentDate);
					out.print("<td>"+period.getYears()+" years "+period.getMonths()+" months"+"</td>");
					out.print("</tr>");
				} while (rs.next());
				out.println(htmlEnd());
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private String htmlHead() {
		// TODO Auto-generated method stub

		return "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<head>\n"
				+ "<meta charset=\"UTF-8\">\n"
				+ "<title>Employee Details</title>\n"	
				+ "\n"
				+ "\n"
				+ "<!-- Compiled and minified CSS -->\n"
				+ "<link rel=\"stylesheet\"\n"
				+ "	href=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css\">\n"
				+ "\n"
				+ "<!-- Compiled and minified JavaScript -->\n"
				+ "<script\n"
				+ "	src=\"https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js\"></script>\n"
				+ "<link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\"\n"
				+ "	rel=\"stylesheet\">\n"
				+ "\n"
				+ "</head>\n"
				+ "<body style=\"background: #4db6ac; font-size: 20px;\">\n"
				+ "\n"
				+ "	<div class=\"container\">\n"
				+ "\n"
				+ "		<div class=\"row\" style=\"margin-top: auto; margin-bottom: auto;\">\n"
				+ "			<div class=\"col m8 offset-m2\">\n"
				+ "\n"
				+ "				<div class=\"card\">\n"
				+ "					<div class=\"card-content indigo lighten-1 center white-text\">\n"
				+ "						<h2 class=\"red-text\">Colleague details</h2>\n"
				+ "						<table class=\"responsive-table\">\n"
				+ "							<thead>\n"
				+ "								<tr>\n"
				+ "									<th>Name</th>\n"
				+ "									<th>Employee Code</th>\n"
				+ "									<th>Phone No</th>\n"
				+ "									<th>Age</th>\n"
				+ "									<th>Experience in this company</th>\n"
				+ "								</tr>\n"
				+ "							</thead>\n"
				+ "\n"
				+ "							<tbody>\n"
				+ "								<tr>";
	}
	
	private String htmlEnd() {
		// TODO Auto-generated method stub

		return "							</tbody>\n"
				+ "						</table>\n"
				+ "						\n"
				+ "							<a href=\"login.jsp\"><button type=\"submit\"\n"
				+ "								class=\"waves-effect waves-light btn-large red\"\n"
				+ "								style=\"margin-top: 5em;\">Logout</button>\n"
				+ "						</a>\n"
				+ "\n"
				+ "					</div>\n"
				+ "				</div>\n"
				+ "			</div>\n"
				+ "		</div>\n"
				+ "	</div>\n"
				+ "<footer class=\"page-footer\" style=\"bottom:0; position: fixed; width: 100%; font-size: 15px;\">\n"
				+ "		<div class=\"footer-copyright\">\n"
				+ "			<div class=\"container center\">\n"
				+ "				Copyright © Rapidsoft Technology \n"
				+ "			</div>\n"
				+ "		</div>\n"
				+ "	</footer>"
				+ "\n"
				+ "</body>\n"
				+ "</html>";
	}

}
