package com.greatlearning.movie.resourse;

import java.sql.Connection;
import java.sql.DriverManager;

//Singleton design pattern
public class DatabaseResource {
	private static Connection con;

	private DatabaseResource() {
		super();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment6_rachana", "root", "Sukuna@99");
		} catch (Exception e) {
			System.out.println("Db Connection error " + e);
		}

	}
	
	//to return the instance of class
	private static final DatabaseResource database = new DatabaseResource();
	 
	 public static DatabaseResource getInstance() {
	 return database ;
	 }

	 //to return the connection
	public static Connection getDbConnection() {
		try {
			return con;
		} catch (Exception e) {
		}
		return null;
	}

	 


}
