package com.Biditvats.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Biditvats.domain.User;


@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
    public HomeServlet() {
        // Do Nothing
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession httpSession = request.getSession(false);
		if(httpSession == null || httpSession.getAttribute("user") == null) {
			response.sendRedirect("login.html");
		} else {
			User user = (User) httpSession.getAttribute("user");
			
			out.println("<html>"
					+"<head>"
					+"<link rel=\"stylesheet\" href=\"style.css\">"
					+"</head>"
					+"<body>"
					+"<table>"
					+"<tr><td colspan=\"2\"><h1>Welcome to User Profile</h1></td></tr>"
					+"<tr><td>Welcome:</td><td>"+user.getFirstName()+" "+user.getLastName()+"</td></tr>"
					+"<tr><td>Email:</td><td>"+user.getEmail()+"</td></tr>"
					+"<tr><td>Mobile:</td><td>"+user.getMobile()+"</td></tr>"
					+"<tr><td><a href=\"LogoutServlet\">Logout</a></td></tr>"
					+"</table>"
					+"</body>"
					+"</html>");
		}
	}

}
