package com.library.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.DAO.LibrarianDao;
import com.library.beans.Librarian;

/**
 * Servlet implementation class ViewLibrarianServlet
 */
public class ViewLibrarianServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();

		LibrarianDao dao = new LibrarianDao();
		List<Librarian> librarians = dao.viewLibrarians();

		writer.write("<div style='text-align: center;'>");
		writer.write("<table style='border-collapse: collapse; width: 80%; margin: 20px;'>");

		// Table header
		writer.write("<tr style='background-color: #f0f0f0;'>" 
				+ "<th>Librarian ID</th>" 
				+ "<th>Librarian Name</th>"
				+ "<th>Librarian Email</th>" 
				+ "<th>Librarian Password</th>" 
				+ "<th>Librarian Mobile</th>" 
				+ "</tr>");

		// Table rows
		for (Librarian l : librarians) {
			writer.write("<tr style='center'>" 
					+ "<td style='border: 1px solid #dddddd; padding: 8px;'>" + l.getId() + "</td>"
					+ "<td style='border: 1px solid #dddddd; padding: 8px;'>" + l.getName() + "</td>"
					+ "<td style='border: 1px solid #dddddd; padding: 8px;'>" + l.getEmail() + "</td>"
					+ "<td style='border: 1px solid #dddddd; padding: 8px;'>" + l.getPassword() + "</td>"
					+ "<td style='border: 1px solid #dddddd; padding: 8px;'>" + l.getMobile() + "</td>" 
					+ "</tr>");
		}

		writer.write("</table>");
		writer.write("</div>");
		writer.close();
	}
}