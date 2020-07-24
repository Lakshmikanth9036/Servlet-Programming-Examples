package com.Biditvats.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Biditvats.dao.UserDao;
import com.Biditvats.dao.UserDaoImpl;
import com.Biditvats.domain.User;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("password");
		
		if(firstName == "" || lastName == "" || email == "" || mobile =="" || password == "") {
			out.println("<h2 style=\"color: red;\">*All Fields are required!</h2>");
			request.getRequestDispatcher("register.html").include(request, response);
		} else {
			User user = new User(firstName, lastName, email, mobile, password);
			UserDao userDao = UserDaoImpl.getIntance();
			
			if(userDao.saveUser(user)) {
				HttpSession httpSession = request.getSession();
				httpSession.setAttribute("user", user);
				response.sendRedirect("HomeServlet");
			}else {
				out.println("<h2 style=\"color: red;\">Email is already Exist!</h2>");
				request.getRequestDispatcher("register.html").include(request, response);
			}
		}
	}

}
