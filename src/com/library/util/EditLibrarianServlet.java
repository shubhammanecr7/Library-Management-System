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
 * Servlet implementation class EditLibrarianServlet
 */
public class EditLibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		RequestDispatcher dispatcher;

		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("pass");
		String mobile = request.getParameter("mob");

		Librarian librarian = new Librarian(id, name, email, password, mobile);

		LibrarianDao dao = new LibrarianDao();
		int i = dao.updateLibrarian(librarian);

		if (i > 0) {
			writer.write("<h3 style='color:green'>Librarian updated successfully..</h3>");
		} else {
			writer.write("<h3 style='color:red'>Something went wrong..</h3>");
		}
		//forward request response to editLibrarian.html
		dispatcher = request.getRequestDispatcher("editLibrarian.html");
		dispatcher.include(request, response);
	}
}