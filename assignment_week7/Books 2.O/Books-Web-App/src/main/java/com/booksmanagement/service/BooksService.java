package com.booksmanagement.service;

import java.util.List;

import com.booksmanagement.bean.Books;
import com.booksmanagement.dao.BooksDao;

public class BooksService {
	BooksDao booksDao= new BooksDao();
		
	public List<Books> getAllBooks(){
		return booksDao.getAllBooks(); 
		
	}
	

}
