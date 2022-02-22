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

import com.bean.CompositeKey;
import com.bean.ReadLaterBooks;
import com.dao.ReadLaterBooksDao;
import com.service.ReadLaterBooksService;
@ExtendWith(MockitoExtension.class)
class ReadLaterBooksServiceTest {

	@Mock
	ReadLaterBooksDao booksDao;
	
	@InjectMocks
	ReadLaterBooksService booksService;
	@Test
	void testStoreReadLaterBooks() {
//		fail("Not yet implemented");
		ReadLaterBooks books =new ReadLaterBooks();
		books.setKey(new CompositeKey("raj@gmail.com",105));
		books.setBookName("What-If");
		books.setAuthor(" Randall Munroe");
		books.setBookGenre("Humor");
		books.setBookImageUrl("https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg");
		books.setBookPrice(260);
		books.setBookRating(4.5f);
		Mockito.when(booksDao.existsById(books.getKey())).thenReturn(false);
		Mockito.when(booksDao.save(books)).thenReturn(books);
			String result = booksService.storeReadLaterBooks(books);
		
		Assertions.assertEquals("The Book Added To Read Later List", result);
//		Assertions.assertEquals("Book Already Exists In Read Later List", result);
	}

	@Test
	void testGetReadLaterBooks() {
//		fail("Not yet implemented");
		
		List<ReadLaterBooks> listBooks= new ArrayList<>();
		ReadLaterBooks books =new ReadLaterBooks();
		String email ="raj@gmail.com";
		CompositeKey key = new CompositeKey(email,105);
		books.setKey(key);
		books.setBookName("What-If");
		books.setAuthor(" Randall Munroe");
		books.setBookGenre("Humor");
		books.setBookImageUrl("https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg");
		books.setBookPrice(260);
		books.setBookRating(4.5f);
		listBooks.add(books);
		Mockito.when(booksDao.getReadLaterBooks(email)).thenReturn(listBooks);
		Assertions.assertTrue(booksService.getReadLaterBooks(books.getKey().getEmailId()).stream().count()==1);
		
	}

}
