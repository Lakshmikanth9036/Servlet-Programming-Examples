package com.Biditvats.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WelcomeServlet() {
		System.out.println("WelcomeServlet Object is Created!");
	}

	@Override
	public void init(ServletConfig config) {
		System.out.println("WelcomeServlet is Initialized!");
	}

	@Override
	public void destroy() {
		System.out.println("WelcomeServlet is Destroyed!");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		System.out.println("WelcomeServlet Service is called!");

		out.print("<h1>Welcome To Servlet Technology</h1>");
		out.println("<p>Now Check your Console again and than Stop your Server. Than chek again</p>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
