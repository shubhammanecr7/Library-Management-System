package com.library.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.DAO.BookDao;

/**
 * Servlet implementation class ReturnBookServlet
 */
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		//fetch book is and student id
		String bid = request.getParameter("bid");
		String sid = request.getParameter("sid");
		BookDao dao = new BookDao();
		int i = dao.returnBook(bid, sid);

		if (i > 0) {
			writer.write("<h3 style='color:green'>Book returned...</h3>");
		} else {
			writer.write("<h3 style='color:red'>Unable to return...</h3>");
		}
		
		writer.close();
	}
}