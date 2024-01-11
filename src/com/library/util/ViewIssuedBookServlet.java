package com.library.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.library.DAO.BookDao;
import com.library.beans.IssueBook;

/**
 * Servlet implementation class ViewIssuedBookServlet
 */
public class ViewIssuedBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		BookDao dao = new BookDao();
		
		List<IssueBook> books = dao.viewIssuedBooks();
		
		writer.write("<div align='center'>");
		writer.write("<table>");
		writer.write("<tr>"
				+ "<td>Book-Id</td>"
				+ "<td>Student-Id</td>"
				+ "<td>Student Name</td>"
				+ "<td>Student Mobile</td>"
				+ "<td>Book Issue date</td>"
				+ "<td>Book Return status</td>"
				+ "</tr>");
		
		for (IssueBook b : books)
		{
			writer.write("<tr>"
					+ "<td>"+b.getBid()+"</td>"
					+ "<td>"+b.getStudentid()+"</td>"
					+ "<td>"+b.getStudentname()+"</td>"
					+ "<td>"+b.getStudentmobile()+"</td>"
					+ "<td>"+b.getIssueddate()+"</td>"
					+ "<td>"+b.getReturnstatus()+"</td>"
					+ "</tr>");
		}
		writer.write("</table>");
		writer.write("</div>");
		writer.close();
	}
}