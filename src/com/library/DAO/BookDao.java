package com.library.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.library.beans.Books;
import com.library.beans.IssueBook;

public class BookDao {
	// method to add new book
	public int addBook(Books b) {
		String sql = "insert into books values(?,?,?,?,?,?)";
		int i = 0;
		try {
			Connection con = DataBase.getConnection();
			PreparedStatement ptmt = con.prepareStatement(sql);
			ptmt.setString(1, b.getBid());
			ptmt.setString(2, b.getName());
			ptmt.setString(3, b.getAuthor());
			ptmt.setString(4, b.getPublisher());
			ptmt.setInt(5, b.getQuantity());
			ptmt.setInt(6, 0); // initially we make issued count as 0
			i = ptmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println("Error in addBook method");
			e.printStackTrace();
		}
		return i;
	}

	// method to view all books
	public List<Books> viewBooks() {
		List<Books> list = new ArrayList<Books>();
		String sql = "select * from books";
		try {
			Connection connection = DataBase.getConnection();
			PreparedStatement ptmt = connection.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				Books books = new Books();
				books.setBid(rs.getString("bid"));
				books.setName(rs.getString("name"));
				books.setAuthor(rs.getString("author"));
				books.setPublisher(rs.getString("publisher"));
				books.setQuantity(rs.getInt("quantity"));
				books.setIssued(rs.getInt("issued"));
				list.add(books);
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("Error in viewBooks method");
			e.printStackTrace();
		}
		return list;
	}

	// method to delete or remove book
	public int deleteBook(String bid) {
		int i = 0;
		String sql = "delete from books where bid=?";
		try {
			Connection connection = DataBase.getConnection();
			PreparedStatement ptmt = connection.prepareStatement(sql);

			ptmt.setString(1, bid);
			i = ptmt.executeUpdate();
			connection.close();

		} catch (Exception e) {
			System.out.println("Error in deleteBook method");
			e.printStackTrace();
		}
		return i;
	}

	// method to get the issue count of a book
	public int getIssuedBooks(String bid) {
		String sql = "select * from books where bid=?";
		int i = 0;
		try {
			Connection connection = DataBase.getConnection();
			PreparedStatement ptmt = connection.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {
				i = rs.getInt("issued");
			}
			connection.close();

		} catch (Exception e) {
			System.out.println("Error in getIssuedBooks method");
			e.printStackTrace();
		}
		return i;
	}

	// method to check if book is available to issue or not
	public boolean checkIssued(String bid) {
		boolean status = false;
		String sql = "select * from books where bid=? and quantity>issued";
		try {
			Connection connection = DataBase.getConnection();
			PreparedStatement ptmt = connection.prepareStatement(sql);

			ptmt.setString(1, bid);
			ResultSet rs = ptmt.executeQuery();
			if (rs.next()) {
				status = true;
			}
			connection.close();
		} catch (Exception e) {
			System.out.println("Error in checkIssued method");
			e.printStackTrace();
		}
		return status;
	}

	// method to issue new book
	public int issueBook(IssueBook issueBook) {
		boolean status = checkIssued(issueBook.getBid());
		System.out.println("book availability : " + status);
		if (status == true) {
			int i = 0;
			String sql = "insert into issuebook values(?,?,?,?,?,?)";
			try {
				Connection connection = DataBase.getConnection();
				PreparedStatement ptmt = connection.prepareStatement(sql);
				ptmt.setString(1, issueBook.getBid());
				ptmt.setString(2, issueBook.getStudentid());
				ptmt.setString(3, issueBook.getStudentname());
				ptmt.setString(4, issueBook.getStudentmobile());
				Date issuedate = new Date(System.currentTimeMillis());
				ptmt.setDate(5, (java.sql.Date) issuedate);
				ptmt.setString(6, "no"); // return status of the book taken
				// here when student gives back the book status will be "yes".
				i = ptmt.executeUpdate();
				if (i > 0) {
					String sql2 = "update books set issued=? where bid=?";
					PreparedStatement ptmt2 = connection.prepareStatement(sql2);
					ptmt2.setInt(1, getIssuedBooks(issueBook.getBid()) + 1);
					ptmt2.setString(2, issueBook.getBid());
				}
				connection.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return i;
		} else {
			return 0;
		}
	}

	// method to take back the book from student
	public int returnBook(String bid, String studentid) {
		int i = 0;
		String sql = "update issuebook set returnstatus='yes' where bid=? and studentid=?";
		try {
			Connection connection = DataBase.getConnection();
			PreparedStatement ptmt = connection.prepareStatement(sql);
			ptmt.setString(1, bid);
			ptmt.setString(2, studentid);
			i = ptmt.executeUpdate();
			if (i > 0) {
				PreparedStatement ptmt2 = connection.prepareStatement("update books set issued=? where bid=?");
				ptmt2.setInt(1, getIssuedBooks(bid) - 1);
				ptmt2.setString(2, bid);
				i = ptmt2.executeUpdate();
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	//method to view the list of all issued books
	public List<IssueBook> viewIssuedBooks() {
		List<IssueBook> list = new ArrayList<IssueBook>();
		String sql = "select * from issuebook";
		try {
			Connection connection = DataBase.getConnection();
			PreparedStatement ptmt = connection.prepareStatement(sql);
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				IssueBook issueBook = new IssueBook();
				issueBook.setBid(rs.getString(1));
				issueBook.setStudentid(rs.getString(2));
				issueBook.setStudentname(rs.getString(3));
				issueBook.setStudentmobile(rs.getString(4));
				issueBook.setIssueddate(rs.getDate(5));
				issueBook.setReturnstatus(rs.getString(6));
				list.add(issueBook);
			}
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}