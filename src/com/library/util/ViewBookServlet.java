package com.library.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.DAO.BookDao;
import com.library.beans.Books;

/**
 * Servlet implementation class ViewBookServlet
 */
public class ViewBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		BookDao dao = new BookDao();
		List<Books> books = dao.viewBooks();

		writer.write("<div align='center'>");
		writer.write("<table>");

		writer.write("<tr>"
				+ "<td>Book-ID</td>"
				+ "<td>Name</td>"
				+ "<td>Author</td>"
				+ "<td>Publisher</td>"
				+ "<td>Quantity</td>"
				+ "<td>Issued</td>"
				+ "</tr>");

		for (Books b : books) {
			writer.write("<tr>" 
					+ "<td>" + b.getBid() + "</td>" 
					+ "<td>" + b.getName() + "</td>" 
					+ "<td>" + b.getAuthor() + "</td>" 
					+ "<td>" + b.getPublisher() + "</td>" 
					+ "<td>" + b.getQuantity() + "</td>"
					+ "<td>" + b.getIssued() + "</td>" 
					+ "</tr>");
		}
		writer.write("</table>");
		writer.write("</div>");
		writer.close();
	}
}