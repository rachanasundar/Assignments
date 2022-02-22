 package com.controller.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.bean.Books;

class BooksControllerTest {
String baseUrl ="http://localhost:8181/book";
	@Test
	void testGetAllBooks() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Books>> books = restTemplate.exchange(baseUrl+"/getAllBooks",HttpMethod.GET,null,new ParameterizedTypeReference<List<Books>>() {});
		List<Books>listOfBooks=books.getBody();
		Assertions.assertTrue(listOfBooks.stream().count()==5);
	}



	@Test
	void testStoreBooks() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		
		Books books =new  Books();
		books.setBookId(105);
		books.setBookName("What-If");
		books.setAuthor(" Randall Munroe");
		books.setBookGenre("Humor");
		books.setBookImageUrl("https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg");
		books.setBookPrice(260);
		books.setBookRating(4.5f);
		
		String result = restTemplate.postForObject(baseUrl+"/storeBooks",books, String.class);
//		Assertions.assertEquals("Book " + books.getBookId() + " stored successfully", result);
		Assertions.assertEquals("Book id must be unique", result);
		
	}

	@Test
	void testDeleteBook() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> res = restTemplate.exchange(baseUrl+"/deleteBook/106",HttpMethod.DELETE,null,String.class);
		String result=res.getBody();
		Assertions.assertEquals("Book details not present", result);
		
	}

	@Test
	@Disabled
	void testUpdateBookName() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		Books books = new Books();
		books.setBookId(105);
		books.setBookName("WHAT IF");
		String result= restTemplate.patchForObject(baseUrl+"/updateBookName",books,String.class);
		Assertions.assertEquals("Book updated successfully", result);
		
	}

	@Test
	@Disabled
	void testUpdateAuthor() {
//		fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		Books books = new Books();
		books.setBookId(104);
		books.setAuthor("Author");
		String result= restTemplate.patchForObject(baseUrl+"/updateAuthor",books,String.class);
		Assertions.assertEquals("Book updated successfully", result);
	}

	@Test
	@Disabled
	void testUpdateBookGenre() {
//		fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		Books books = new Books();
		books.setBookId(105);
		books.setBookGenre("gener");
		String result= restTemplate.patchForObject(baseUrl+"/updateBookGenre",books,String.class);
		Assertions.assertEquals("Book updated successfully", result);
	}

	@Test
	@Disabled
	void testUpdateBookImageUrl() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		Books books = new Books();
		books.setBookId(105);
		books.setBookGenre("gener");
		String result= restTemplate.patchForObject(baseUrl+"/updateBookGenre",books,String.class);
		Assertions.assertEquals("Book updated successfully", result);
	}

	@Test
	@Disabled
	void testUupdateBookPrice() {
//		fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		Books books = new Books();
		books.setBookId(105);
		books.setBookPrice(240);
		String result= restTemplate.patchForObject(baseUrl+"/updateBookPrice",books,String.class);
		Assertions.assertEquals("Book updated successfully", result);
	}

	@Test
	@Disabled
	void testUpdateBookRating() {
//		fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		Books books = new Books();
		books.setBookId(105);
		books.setBookRating(4.6f);;
		String result= restTemplate.patchForObject(baseUrl+"/updateBookRating",books,String.class);
		Assertions.assertEquals("Book updated successfully", result);
	}

}
