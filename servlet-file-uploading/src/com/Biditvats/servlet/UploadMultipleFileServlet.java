package com.Biditvats.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadMultipleFileServlet
 */
@MultipartConfig(maxFileSize=1024*1024*1, maxRequestSize=1024*1024*6)
@WebServlet("/UploadMultipleFileServlet")
public class UploadMultipleFileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadMultipleFileServlet() {
        //Do Nothing
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("multiple.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		Collection<Part> parts = request.getParts();
		String appPath = request.getServletContext().getRealPath("");
		String imagePath = appPath+"images";
		String imageName = "";
		
		for (Part part : parts) {
			imageName = part.getSubmittedFileName();
			part.write(imagePath+File.separator+imageName);
		}
		
		out.println("File has been uploaded successfully!");
		for (Part part : parts) {
			imageName = part.getSubmittedFileName();
			out.print("<img src=\"images\\"+imageName+"\">");
		}
	}
}
