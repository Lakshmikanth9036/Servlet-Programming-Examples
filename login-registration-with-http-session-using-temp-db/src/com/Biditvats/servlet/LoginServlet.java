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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		if(email == "" || password == "") {
			out.println("<h2 style=\"color: red;\">*All Fields are required!</h2>");
			request.getRequestDispatcher("login.html").include(request, response);
		} else {
			UserDao userDao = UserDaoImpl.getIntance();
			User user = userDao.getUserByemail(email);
			if(user != null){
				if(password.equals(user.getPassword())) {
					HttpSession httpSession = request.getSession();
					httpSession.setAttribute("user", user);
					response.sendRedirect("HomeServlet");
				}else {
					out.println("<h2 style=\"color: red;\">Email and Password didn't match!</h2>");
					request.getRequestDispatcher("login.html").include(request, response);
				}
			}else {
				out.println("<h2 style=\"color: red;\">User does not Exist!</h2>");
				request.getRequestDispatcher("login.html").include(request, response);
			}
		}
	}

}
