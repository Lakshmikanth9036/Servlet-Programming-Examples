package com.Biditvats.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadSingleFileServlet
 */
@MultipartConfig
@WebServlet("/UploadSingleFileServlet")
public class UploadSingleFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UploadSingleFileServlet() {
		// Do Nothing
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("single.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Part part = request.getPart("profileImage");
		
		String imagePath = request.getServletContext().getRealPath("");
		String imageName = part.getSubmittedFileName();
		String path = "/home/kabilermind-02/Desktop/ppo/" + imageName;
		part.write(path);

		out.print("<h1>File has been uploaded successfully!</h1>");
		out.print("<img src=\""+path+"\">");
	}

}
