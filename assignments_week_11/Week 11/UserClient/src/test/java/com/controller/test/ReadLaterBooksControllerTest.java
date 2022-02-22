package com.controller.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.bean.CompositeKey;
import com.bean.LikedBooks;
import com.bean.ReadLaterBooks;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ReadLaterBooksControllerTest {
	String baseUrl="http://localhost:8282/readLaterBooks";
	@Test
	void testStoreReadLaterBook() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		
		ReadLaterBooks books =new ReadLaterBooks();
		books.setKey(new CompositeKey("raj@gmail.com",105));
		books.setBookName("What-If");
		books.setAuthor(" Randall Munroe");
		books.setBookGenre("Humor");
		books.setBookImageUrl("https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg");
		books.setBookPrice(260);
		books.setBookRating(4.5f);
		
String reslut = restTemplate.postForObject(baseUrl+"/storeReadLaterBook", books, String.class);
		
		//Assertions.assertEquals("The Book Added To Read Later List", reslut);
		Assertions.assertEquals("Book Already Exists In Read Later List", reslut);
	}

	@Test
	void testGetReadLaterBook() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<ReadLaterBooks>> books=  restTemplate.exchange(baseUrl+"/getReadLaterBook/raj@gmail.com",HttpMethod.GET,null,new ParameterizedTypeReference<List<ReadLaterBooks>>() {});
		List<ReadLaterBooks> listOfBooks= books.getBody();
		Assertions.assertTrue(listOfBooks.stream().allMatch(b->b.getBookGenre().equals("Humor")));
	}

}
