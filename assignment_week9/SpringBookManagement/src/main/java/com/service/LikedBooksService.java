package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.bean.UserLikedBooks;
import com.dao.UserLikedBooksDao;

@Service
public class LikedBooksService {
	@Autowired
	UserLikedBooksDao likedDao;

	public List<UserLikedBooks> getAllLikedBooks() {
		return likedDao.findAll();
	}
	
	public List<String> getLikedBook(String email) {
		
		return likedDao.getLikedBook(email);
	}
	
	public String storeLikeBook(UserLikedBooks books) {
		if (likedDao.existsById(books.getKeys())) {
			return "Book is present in Liked List";
		}
		else {
			likedDao.save(books);
			return "Book stored to Liked List";
			
		}
	}
	
	public String deleteLikeBook(UserLikedBooks books) {
		if (!likedDao.existsById(books.getKeys())) {
			return "Book is not present in Liked List";
		}
		else {
			likedDao.delete(books);
			return "Book deleted from Liked List";
		}
	}

}
