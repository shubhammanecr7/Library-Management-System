package com.library.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.DAO.LibrarianDao;

/**
 * Servlet implementation class ResetPasswordServlet
 */
public class ResetPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		LibrarianDao dao = new LibrarianDao();
		int i = dao.updatePassword(uname, pass);

		if (i > 0) {
			writer.write("<h3 style='color:green'>Password changed..</h3>");
		} else {
			writer.write("<h3 style='color:red'>Invalid user!</h3>");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("resetPassword.html");
		dispatcher.include(request, response);
	}
}