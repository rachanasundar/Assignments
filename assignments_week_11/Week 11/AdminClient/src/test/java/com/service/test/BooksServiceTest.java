package com.service.test;



import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.bean.Books;
import com.dao.BooksDao;
import com.service.BooksService;
@ExtendWith(MockitoExtension.class)
@SpringBootTest
class BooksServiceTest {


	@Mock
	BooksDao booksDao;
	@InjectMocks
	BooksService booksService;
	
	@Test
	void testGetAllBooks() {
		//fail("Not yet implemented");
		List<Books> listBooks= new ArrayList<Books>();
		Books books =new  Books();
		books.setBookId(105);
		books.setBookName("What-If");
		books.setAuthor(" Randall Munroe");
		books.setBookGenre("Humor");
		books.setBookImageUrl("https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg");
		books.setBookPrice(260);
		books.setBookRating(4.5f);
		listBooks.add(books);
		Mockito.when(booksDao.findAll()).thenReturn(listBooks);
		Assertions.assertTrue(booksService.getAllBooks().stream().count()==1);
	}



	@Test
	void testStoreBook() {
//		fail("Not yet implemented");
		
		Books books =new  Books();
		books.setBookId(105);
		books.setBookName("What-If");
		books.setAuthor(" Randall Munroe");
		books.setBookGenre("Humor");
		books.setBookImageUrl("https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg");
		books.setBookPrice(260);
		books.setBookRating(4.5f);
		Mockito.when(booksDao.existsById(books.getBookId())).thenReturn(true);
//		Mockito.when(booksDao.save(books)).thenReturn(books);
		String result = booksService.storeBook(books);
		Assertions.assertEquals( "Book id must be unique",result );
		//Assertions.assertEquals( "Book " + books.getBookId() + " stored successfully",result );
		
	}

	@Test
	void testDeleteBook() {
		//fail("Not yet implemented");
		Mockito.when(booksDao.existsById(101)).thenReturn(true);
		Assertions.assertEquals("Book deleted successfully", booksService.deleteBook(101));
		
		
	}

	@Test
	void testUpdateBookName() {
//		fail("Not yet implemented");
		Books books =new  Books();
		books.setBookId(101);
		books.setBookName("My Life");
		Mockito.when(booksDao.existsById(101)).thenReturn(true);
		Mockito.when(booksDao.getById(books.getBookId())).thenReturn(books);
		Assertions.assertEquals("Book updated successfully", booksService.updateBookName(books));
		
		
	}

	@Test
	void testUpdateAuthor() {
		//fail("Not yet implemented");
		Books books =new  Books();
		books.setBookId(101);
		books.setAuthor("Rajesh");;
		Mockito.when(booksDao.existsById(101)).thenReturn(true);
		Mockito.when(booksDao.getById(books.getBookId())).thenReturn(books);
		Assertions.assertEquals("Book updated successfully", booksService.updateAuthor(books));
	}

	@Test
	void testUpdateBookGenre() {
		//fail("Not yet implemented");
		Books books =new  Books();
		books.setBookId(101);
		books.setBookGenre("Autobiography");
		Mockito.when(booksDao.existsById(101)).thenReturn(true);
		Mockito.when(booksDao.getById(books.getBookId())).thenReturn(books);
		Assertions.assertEquals("Book updated successfully", booksService.updateBookGenre(books));
	}

	@Test
	void testUpdateBookImagarUrl() {
		//fail("Not yet implemented");
		Books books =new  Books();
		books.setBookId(101);
		books.setBookImageUrl("https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg");
		Mockito.when(booksDao.existsById(101)).thenReturn(true);
		Mockito.when(booksDao.getById(books.getBookId())).thenReturn(books);
		Assertions.assertEquals("Book updated successfully", booksService.updateBookImagarUrl(books));
	}

	@Test
	void testUpdateBookPrice() {
		//fail("Not yet implemented");
		Books books =new  Books();
		books.setBookId(101);
		books.setBookPrice(250);
		Mockito.when(booksDao.existsById(101)).thenReturn(true);
		Mockito.when(booksDao.getById(books.getBookId())).thenReturn(books);
		Assertions.assertEquals("Book updated successfully", booksService.updateBookPrice(books));
	}

	@Test
	void testUpdateBookRating() {
		//fail("Not yet implemented");
		Books books =new  Books();
		books.setBookId(101);
		books.setBookRating(4.5f);
		Mockito.when(booksDao.existsById(101)).thenReturn(true);
		Mockito.when(booksDao.getById(books.getBookId())).thenReturn(books);
		Assertions.assertEquals("Book updated successfully", booksService.updateBookRating(books));
	}

}
