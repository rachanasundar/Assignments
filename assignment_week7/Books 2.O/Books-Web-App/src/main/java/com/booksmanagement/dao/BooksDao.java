package com.booksmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.booksmanagement.bean.Books;
import com.booksmanagement.resource.DbResource;

public class BooksDao {
	
	//to retrieve all the books from database
	public List<Books> getAllBooks(){
		List<Books> listOfBooks = new ArrayList<Books>();
		try {
			Connection con = DbResource.getDbConnection();
			PreparedStatement psmt= con.prepareStatement("select * from books");
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Books book = new Books();
				book.setBookId(rs.getInt(1));
				book.setBookName(rs.getString(2));
				book.setAuthor(rs.getString(3));
				book.setBookGenre(rs.getString(4));
				book.setBookImageUrl(rs.getString(5));
				book.setBookRating(rs.getFloat(6));
				book.setBookPublisher(rs.getString(7));
				
				listOfBooks.add(book);
			}
		}catch(Exception e){
		System.out.println("Method getAllBooks: "+e);
		}
		return listOfBooks;
	}
	
}
