package com.Biditvats.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public WelcomeServlet() {
        System.out.println("servlet object is created");
    }
    
    public void init(ServletConfig config) {
    	System.out.println("Welcomeservlet is initialized");
    }
    
    public void destroy() {
    	System.out.println("Servlet object is destroyed");
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<h1>Welcome to Servlet life Cycle</h1>");
		out.print("<p>Check your Eclipse Console</p>");
		
		System.out.println("Calling Service Method");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
