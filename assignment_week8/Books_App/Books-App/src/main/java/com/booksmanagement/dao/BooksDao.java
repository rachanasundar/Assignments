package com.booksmanagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.booksmanagement.bean.Books;

@Repository
public class BooksDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	//to get all books from database
	public List<Books> getAllBooks(){
		try {
			return jdbcTemplate.query("select * from books ", new BooksRowMapper())	;		
		}catch (Exception e) {
			System.out.println("Method getAllBooks: "+e);
		}
		return null;
	}
	
	//to get liked books of a user from database
	public List<Books> getLikedBooks(long phNumber) {
		String sql="select bookid, bookname, author, bookgenre, bookImageUrl, bookrating, bookPublisher "
				+ "from likedbooks where phonenumber="+phNumber;
		return jdbcTemplate.query(sql,new BooksRowMapper());
		
	}
	
	//to get read later books of a user from database 
	public List<Books> getReadLaterBooks(long phNumber) {
		String sql="select bookid, bookname, author, bookgenre, bookImageUrl, bookrating, bookPublisher "
				+ "from readlater where phonenumber="+phNumber;
		return jdbcTemplate.query(sql,new BooksRowMapper());
		
	}
	
}
