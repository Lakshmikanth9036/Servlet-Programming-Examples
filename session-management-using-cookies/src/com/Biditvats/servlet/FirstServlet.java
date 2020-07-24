package com.Biditvats.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		
		//Creating Cookie
		Cookie cookie = new Cookie("myCookie", email);
		
		//Adding Cookie with response
		response.addCookie(cookie);
		
		out.print("<h1>Welcome: " +email+ "</h1>");
		out.println("<h3>Your cookie is created!</h3>");
		out.println("<a href=\"SecondServlet\">View all Cookies</a>");
	}

}
