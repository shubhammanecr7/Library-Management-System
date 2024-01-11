package com.library.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminLoginServlet
 */
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter(); // for sending text responses
		response.setContentType("text/html");
		RequestDispatcher dispatcher; // for forwarding request

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");

		if (uname.equals("shubham") && pass.equals("mane")) {
			//if login success goto adminhome.html
			writer.write("<h3 style='color:green; background-color:white;'>Login Successful...</h3>");
			dispatcher = request.getRequestDispatcher("adminhome.html");
			dispatcher.forward(request, response);
		} else {
			//if invalid details entered go back to adminlogin.html
			writer.write("<h3 style='color:green; background-color:white;'>Invalid login details...</h3>");
			dispatcher = request.getRequestDispatcher("adminlogin.html");
			dispatcher.include(request, response);
		}
		writer.close();
	}
}