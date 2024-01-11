package com.library.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.DAO.BookDao;
import com.library.beans.Books;

/**
 * Servlet implementation class AddBookServlet
 */
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter(); // for sending text responses
		response.setContentType("text/html");
		RequestDispatcher dispatcher; // for forwarding requests.

		String bid = request.getParameter("bid");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String quantityStirng = request.getParameter("quantity");
		// changing string value to int for further use in book object
		int quantity = Integer.parseInt(quantityStirng);

		Books book = new Books(bid, name, author, publisher, quantity);
		BookDao dao = new BookDao();
		int i = dao.addBook(book);

		if (i > 0) {
			writer.write("<h3 style='color:green'>Book added successfully...</h3><br>");
		}

		//Forward the request to "addBook.html" after processing.
		dispatcher = request.getRequestDispatcher("addBook.html");
		dispatcher.include(request, response);
	}
}