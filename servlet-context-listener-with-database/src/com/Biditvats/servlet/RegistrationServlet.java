package com.Biditvats.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Biditvats.db.Database;



/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        //Do Nothing
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("fullName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		
		try{
			String sql = "INSERT INTO user_master1(full_name,email,mobile) VALUES(?,?,?)";
			Connection connection = Database.getConnection();
			PreparedStatement pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, name);
			pStatement.setString(2, email);
			pStatement.setString(3, mobile);
			
			if(pStatement.executeUpdate() > 0)
				out.print("<h1>User has been registered successfully!</h1>");
			else
				out.print("<h1>Some problem has been occurred!</h1>");

		}catch (Exception ex) {
			out.println("Exception: "+ex.getMessage());
		}
	}

}