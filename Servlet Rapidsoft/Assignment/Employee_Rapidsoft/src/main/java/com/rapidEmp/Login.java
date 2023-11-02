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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			HttpSession session = request.getSession();
			session.setAttribute("id", rs.getString("id"));
			
			out.println(rs.getString("id"));
			
		}
		else {
			out.print("Invalid Cridential");
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
