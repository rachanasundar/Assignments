package com.booksmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksmanagement.bean.Books;
import com.booksmanagement.dao.BooksDao;

@Service
public class BooksService {

	@Autowired
	BooksDao bookDao;
	
	
	public List<Books> getAllBooks(){
		return bookDao.getAllBooks(); 
	}
	
	public List<Books> getLikedBooks(long phNumber){
		return bookDao.getLikedBooks(phNumber); 
	}
	
	public List<Books> geReadLaterBooks(long phNumber){
		return bookDao.getReadLaterBooks(phNumber); 
	}
}
