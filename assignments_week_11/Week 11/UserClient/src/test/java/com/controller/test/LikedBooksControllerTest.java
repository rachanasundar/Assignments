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

import com.bean.Books;
import com.bean.CompositeKey;
import com.bean.LikedBooks;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LikedBooksControllerTest {
	String baseUrl="http://localhost:8282/likedBooks";
	@Test
	void testStoreLikeBook() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		
		LikedBooks likedBooks = new LikedBooks();
		likedBooks.setKey(new CompositeKey("raj@gmail.com",105));
		likedBooks.setBookName("What-If");
		likedBooks.setAuthor(" Randall Munroe");
		likedBooks.setBookGenre("Humor");
		likedBooks.setBookImageUrl("https://d3525k1ryd2155.cloudfront.net/h/847/615/1384615847.0.x.jpg");
		likedBooks.setBookPrice(260);
		likedBooks.setBookRating(4.5f);
		
		String reslut = restTemplate.postForObject(baseUrl+"/storeLikeBook", likedBooks, String.class);
		
		//Assertions.assertEquals("The Book Added To Liked List", reslut);
		Assertions.assertEquals("Book Already Exists In Liked List", reslut);
		
		
	}

	@Test
	void testGetLikedBook() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<LikedBooks>> books=  restTemplate.exchange(baseUrl+"/getLikedBook/raj@gmail.com",HttpMethod.GET,null,new ParameterizedTypeReference<List<LikedBooks>>() {});
		List<LikedBooks> listOfBooks= books.getBody();
		Assertions.assertTrue(listOfBooks.stream().allMatch(b->b.getBookName().equals("What-If")));
	}

}
