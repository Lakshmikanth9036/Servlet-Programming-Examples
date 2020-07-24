package com.Biditvats.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

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
@WebServlet("/UploadFileInDbServlet")
public class UploadFileInDbServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/j2ee";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	private static Connection con = null;

	public UploadFileInDbServlet() {
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("indb.html").forward(request, response);
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
		
		InputStream in = part.getInputStream();
		String imageName = part.getSubmittedFileName();

		try{
			String sql = "INSERT INTO image_master(image_name,image_data) VALUES(?,?)";
			PreparedStatement pStatement = con.prepareStatement(sql);
			pStatement.setString(1, imageName);
			pStatement.setBlob(2, in);
			
			pStatement.executeUpdate();
		}catch (Exception ex) {
			out.print("<h1>"+ex.getMessage()+"</h1>");
		}
		
		out.print("<h1>File has been uploaded successfully!</h1>");

	}

}

/*
 * CREATE TABLE image_master(
		image_id INT UNIQUE NOT NULL AUTO_INCREMENT,
		image_name VARCHAR(50),
		image_data BLOB,
		PRIMARY KEY(image_id)
);

SET GLOBAL max_allowed_packet = 1934432354;
*/




