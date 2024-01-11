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
 * Servlet implementation class DeleteLibrarianServlet
 */
public class DeleteLibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();	//for sending text response
		response.setContentType("text/html");

		String id1 = request.getParameter("id");
		int id = Integer.parseInt(id1);

		LibrarianDao dao = new LibrarianDao();
		int i = dao.deleteLibrarian(id);

		if (i > 0) {
			writer.write("<h3 style='color:green'>Librarina deleted successfully!</h3>");
		} else {
			writer.write("<h3 style='color:green'>Unable to delete librarian!</h3>");
		}

		//forward request to deleteLibrarian.html
		RequestDispatcher dispatcher = request.getRequestDispatcher("deleteLibrarian.html");
		dispatcher.include(request, response);
	}

}
