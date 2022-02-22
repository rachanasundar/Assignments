package com.booksmanagement.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import com.booksmanagement.bean.Books;
import com.booksmanagement.bean.LogIn;

@Repository
public class LogInDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//to create a new account
	public int createNewAccount(LogIn user) {
		try {
			return jdbcTemplate.update("insert into login value(?,?,?,?)",
					user.getPhoneNumber(),
					user.getEmailId(),
					user.getName(),
					user.getPassword()
					
					);
		}catch (Exception e) {
			System.out.println("createNewAccount method "+e);
			return 0;
		}
	}
	
	//to verify password 
	public String  verifyPassword(Long phNumber) {
		try {
			//to get stored password of a user from database in string format
			String password= (String)jdbcTemplate.queryForObject("select password from login where phonenumber = ?", new Object[] {phNumber}, String.class);
			return password;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("verifyPassword method "+e);
		}
		return null;
	}
	
	//to get user name 
	public String getName(long phNumber) {
		try {
			
			String name =(String)jdbcTemplate.queryForObject("select name from login where phonenumber = ?", new Object[] {phNumber}, String.class);
			return name ;
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("getName method "+e);
		}
		return null;
		}
	
	//to store read later book of user to database
	public int storeReadLaterBook(long phNumber, Books book) {
		try {
			return jdbcTemplate.update("insert into readlater value(?,?,?,?,?,?,?,?)", phNumber,
					book.getBookId(),book.getBookName(),book.getAuthor(), book.getBookGenre(), book.getBookImageUrl(),book.getBookRating(), book.getBookPublisher());
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("storeReadLaterBook method "+e);
		}
		return 0;
	}
	
	//to store liked books of user to database
	public int storeLikedBook(long phNumber,Books book) {
		try {
			return jdbcTemplate.update("insert into likedBooks value(?,?,?,?,?,?,?,?)", phNumber,
					book.getBookId(),book.getBookName(),book.getAuthor(), book.getBookGenre(), book.getBookImageUrl(),book.getBookRating(), book.getBookPublisher());
			
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("storeLikedBook method "+e);
		}
		return 0;
	}
	
	
	
//	//to get book id of stored liked book of a user 
//	public List<Map<String, Object>> getLikedBookIds(long phNumber) {
//		//List<Integer> storedBookIds= new ArrayList();
//		try {
//			String sql= "select bookid from likedBooks where phonenumber="+ phNumber;
//			return jdbcTemplate.queryForList(sql);
//		}catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("getLikedBookIds method "+e);
//		}
//		return null;
//	}
//	
//	//to get book id of stored read later book of a user 
//	public List<Map<String,Object>> getReadLaterBookIds(long phNumber) {
//		
//		try {
//			String sql= "select bookid from readlater where phonenumber="+ phNumber;
//			return jdbcTemplate.queryForList(sql);
//			
//		}catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("getReadLaterBookIds method "+e);
//		}
//		return null;
//	}

}
