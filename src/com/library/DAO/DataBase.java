package com.library.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

	// method to return the database connection
	public static Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/libraryproject", "root", "root");
		} catch (Exception e) {
			System.out.println(e);
		}
		return connection;
	}
}
