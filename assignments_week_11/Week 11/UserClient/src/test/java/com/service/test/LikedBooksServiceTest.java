package com.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bean.Books;
import com.bean.CompositeKey;
import com.bean.LikedBooks;

import com.dao.LikedBooksDao;

import com.service.LikedBooksService;
@ExtendWith(MockitoExtension.class)
class LikedBooksServiceTest {

	@Mock
	LikedBooksDao booksDao;
	
	@InjectMocks
	LikedBooksService booksService;
	@Test
	void testStoreLikedBooks() {
		//fail("Not yet implemented");
		LikedBooks likedBooks = new LikedBooks();
		CompositeKey key = new CompositeKey("raj@gmail.com",105);
		likedBooks.setKey(key);
		likedBooks.setBookName("What-If");
		likedBooks.setAuthor(" Randall Munroe");
		likedBooks.setBookGenre("Humor");
		likedBooks.setBookImageUrl("https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg");
		likedBooks.setBookPrice(260);
		likedBooks.setBookRating(4.5f);
		Mockito.when(booksDao.existsById(likedBooks.getKey())).thenReturn(false);
	Mockito.when(booksDao.save(likedBooks)).thenReturn(likedBooks);
		String result = booksService.storeLikedBooks(likedBooks);
		Assertions.assertEquals("The Book Added To Liked List", result);
//	Assertions.assertEquals("Book Already Exists In Liked List", result);
		
	}

	@Test
	void testGetLikedBooks() {
		//fail("Not yet implemented");
		List<LikedBooks> listBooks= new ArrayList<>();
		LikedBooks likedBooks = new LikedBooks();
		String email ="raj@gmail.com";
		CompositeKey key = new CompositeKey(email,105);
		likedBooks.setKey(key);
		likedBooks.setBookName("What-If");
		likedBooks.setAuthor(" Randall Munroe");
		likedBooks.setBookGenre("Humor");
		likedBooks.setBookImageUrl("https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg");
		likedBooks.setBookPrice(260);
		likedBooks.setBookRating(4.5f);
		listBooks.add(likedBooks);
		Mockito.when(booksDao.getLikedBooks(email)).thenReturn(listBooks);
		Assertions.assertTrue(booksService.getLikedBooks(likedBooks.getKey().getEmailId()).stream().count()==1);
		
	}

}
