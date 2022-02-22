package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.ReadLaterBooks;
import com.dao.ReadLaterBooksDao;

@Service
public class ReadLaterBooksService {
	@Autowired
	ReadLaterBooksDao readLaterBooksDao;

	public String storeReadLaterBooks(ReadLaterBooks books) {
	if(readLaterBooksDao.existsById(books.getKey())) {
		return "Book Already Exists In Read Later List";
	}
	else {
		readLaterBooksDao.save(books);
		return "The Book Added To Read Later List";
	}
		
	}
	public List<ReadLaterBooks> getReadLaterBooks(String email) {
		return readLaterBooksDao.getReadLaterBooks(email);
		
	}
}
