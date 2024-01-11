package com.library.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.DAO.BookDao;
import com.library.beans.IssueBook;

/**
 * Servlet implementation class IssueBookServlet
 */
public class IssueBookServlet extends HttpServlet {
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

		String bid = request.getParameter("bid");
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String smobile = request.getParameter("smobile");

		IssueBook book = new IssueBook(bid, sid, sname, smobile);

		BookDao dao = new BookDao();
		int i = dao.issueBook(book);

		if (i > 0) {
			writer.write("<h3 style='color:green'>Book issued Successfully...</h3>");
			dispatcher = request.getRequestDispatcher("issueBook.html");
			dispatcher.include(request, response);
		} else {
			writer.write("<h3 style='color:red'>Book issue Unsuccessfull...</h3>");
			dispatcher = request.getRequestDispatcher("issueBook.html");
			dispatcher.include(request, response);
		}

	}

}
