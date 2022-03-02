package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Likedbooks;
import com.bean.Readlater;
import com.bean.User;
import com.dao.ReadLaterDao;
import com.dao.UserLikedBooksDao;

@Service
public class ReadBooksService {
	@Autowired
	ReadLaterDao readLaterDao;

	public  List<Readlater> getAllLikedBooks() {
		return readLaterDao.findAll();
	}
	
	public List<Readlater> getLikedBook(String email) {
		return readLaterDao.getLikedBook(email);
	}
	
	public String storeLikeBook(Readlater books) {
		if (readLaterDao.existsById(books.getKeys())) {
			return "Book is present in Read Later List";
		}
		else {
			readLaterDao.save(books);
			return "Book stored to Read Later List";
			
		}
	}
	
}
