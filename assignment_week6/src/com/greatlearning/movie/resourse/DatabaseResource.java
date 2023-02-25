package com.greatlearning.movie.resourse;

import java.sql.Connection;
import java.sql.DriverManager;

//Singleton design pattern
public class DatabaseResource {
	private static Connection con;

	private DatabaseResource() {
		super();
		try {
			//to establish database connection 
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/MoveOnTips?createDatabaseIfNotExit=true && useSSL=false", "root", "root");
		} catch (Exception e) {
			System.out.println("Db Connection error " + e);
		}

	}
	
	//to return the singleton instance of class
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
