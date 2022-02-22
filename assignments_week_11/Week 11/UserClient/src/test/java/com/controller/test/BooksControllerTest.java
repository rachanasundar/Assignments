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
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BooksControllerTest {
	String baseUrl="http://localhost:8282/books";
	@Test
	void testGetAllBooks() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Books>> books = restTemplate.exchange(baseUrl+"/getAllBooks",HttpMethod.GET,null,new ParameterizedTypeReference<List<Books>>() {});
		List<Books>listOfBooks=books.getBody();
		Assertions.assertTrue(listOfBooks.stream().count()==5);
	}

}
