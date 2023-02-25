package com.booksmanagement.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbResource {
	static Connection con;
	public DbResource() {
		super();
	}
	
	 //to return the connection
	public static Connection getDbConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookstorecreateDatabaseIfNotExit=true && useSSL=false", "root", "root");
			return con;
		} catch (Exception e) {
		}
		return null;
	}
	
	//to close connection
	public static void closeConnection() {
		try {
			con.close();
		} catch (Exception e) {}
	}

	

}
