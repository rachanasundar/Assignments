package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Likedbooks;
import com.bean.User;

import com.dao.UserLikedBooksDao;

@Service
public class LikedBooksService {
	@Autowired
	UserLikedBooksDao likedDao;

	public List<Likedbooks> getAllLikedBooks() {
		return likedDao.findAll();
	}
	
	public List<Likedbooks> getLikedBook(String email) {
		
		return likedDao.getLikedBook(email);
	}
	
	public String storeLikeBook(Likedbooks books) {
		if (likedDao.existsById(books.getKeys())) {
			return "Book is present in Liked List";
		}
		else {
			likedDao.save(books);
			return "Book stored to Liked List";
			
		}
	}


}
