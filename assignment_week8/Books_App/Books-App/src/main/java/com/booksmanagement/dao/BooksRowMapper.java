package com.booksmanagement.dao;
import java.sql.ResultSet;

import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.booksmanagement.bean.Books;


public class BooksRowMapper implements RowMapper<Books>{

	@Override
	public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Books book = new Books();
		book.setBookId(rs.getInt(1));
		book.setBookName(rs.getString(2));
		book.setAuthor(rs.getString(3));
		book.setBookGenre(rs.getString(4));
		book.setBookImageUrl(rs.getString(5));
		book.setBookRating(rs.getFloat(6));
		book.setBookPublisher(rs.getString(7));
		return book;
	}

}
