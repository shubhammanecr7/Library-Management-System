package com.library.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.DAO.LibrarianDao;
import com.library.beans.Librarian;

/**
 * Servlet implementation class AddLibrarianServlet
 */
public class AddLibrarianServlet extends HttpServlet {
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

		String name = request.getParameter("name");
		String id1 = request.getParameter("id");
		String email = request.getParameter("email");
		String mobile = request.getParameter("mobile");
		String password = request.getParameter("pass");

		int id = Integer.parseInt(id1);
		Librarian librarian = new Librarian(id, name, email, password, mobile);

		LibrarianDao dao = new LibrarianDao();
		int i = dao.addLibrarian(librarian);

		if (i > 0) {
			writer.write("<h3 style='color:green'>New librarian added successfully..</h3>");
		} else {
			writer.write("<h3 style='color:red'>Error adding new librarian!</h3>");
		}

		//forward the response to addLibrarian.html
		dispatcher = request.getRequestDispatcher("addLibrarian.html");
		dispatcher.include(request, response);
	}

}
