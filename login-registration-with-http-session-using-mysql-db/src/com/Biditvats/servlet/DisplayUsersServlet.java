package com.Biditvats.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Biditvats.dao.UserDaoImpl;
import com.Biditvats.domain.User;

@WebServlet("/DisplayUsersServlet")
public class DisplayUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DisplayUsersServlet() {
		// Do Nothing
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession httpSession = request.getSession(false);
		if (httpSession == null || httpSession.getAttribute("user") == null) {
			response.sendRedirect("login.html");
		} else {

			List<User> users = UserDaoImpl.getIntance().findAllUser();

			if (users != null) {
				out.print("<html>" 
						+ "<head>" 
						+ "<link rel=\"stylesheet\" href=\"style.css\">" 
						+ "</head>" 
						+ "<body>"
						+ "<table>" 
						+ "<tr><td colspan=\"4\"><h1>List of All Users</h1></td></tr>"
						+"<tr><th>User ID:</th><th>Name:</th><th>Email:</th><th>Mobile:</th></tr>");

				for (User user : users) {
					out.print("<tr>" 
							+ "<td>" + user.getId() + "</td>" 
							+ "<td>" + user.getFirstName() + " " + user.getLastName() + "</td>" 
							+ "<td>" + user.getEmail() + "</td>" 
							+ "<td>" + user.getMobile() + "</td></tr>");
				}

				out.print("</table>" + "</body>" + "</html>");
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
