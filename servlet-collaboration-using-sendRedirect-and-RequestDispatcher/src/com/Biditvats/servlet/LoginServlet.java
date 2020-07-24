package com.Biditvats.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username=="" || password=="") {
			out.print("<h3>All fields are required!</h3>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
			dispatcher.include(request, response);
		}
		
		else {
			if("admin".equals(password)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/HomeServlet");
				dispatcher.forward(request, response);
			}
			
			else {
				out.print("<h3>username and password didn't match.</h3>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.html");
				dispatcher.include(request, response);
			}
		}
	}

}
