package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.LikedBooks;
import com.dao.LikedBooksDao;

@Service

public class LikedBooksService {
	@Autowired
	LikedBooksDao likedBooksDao;
	
	public String  storeLikedBooks(LikedBooks likedBooks) {
		if(likedBooksDao.existsById(likedBooks.getKey())) {
			return "Book Already Exists In Liked List";
		}
		else {
			likedBooksDao.save(likedBooks);
			return "The Book Added To Liked List";
		}
		
	}
	public List<LikedBooks> getLikedBooks(String email) {
	
		return likedBooksDao.getLikedBooks(email);
		
	}
}
