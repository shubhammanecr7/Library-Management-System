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
 * Servlet implementation class LibrarianLoginServlet
 */
public class LibrarianLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		RequestDispatcher dispatcher;

		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		LibrarianDao dao = new LibrarianDao();
		if (dao.validateLogin(uname, pass)) {
			writer.write("<h3 style='color:green; background-color:white;'>Login Successful...</h3>");
			dispatcher = request.getRequestDispatcher("librarianhome.html");
			dispatcher.include(request, response);
		} else {
			writer.write("<h3 style='color:red; background-color:white;'>Username or password wrong!</h3>");
			dispatcher = request.getRequestDispatcher("librarianlogin.html");
			dispatcher.include(request, response);
		}
	}
}