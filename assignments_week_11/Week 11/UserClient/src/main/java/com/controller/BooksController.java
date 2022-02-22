package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bean.Books;



@RestController
@RequestMapping("/books")
public class BooksController {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value = "getAllBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Books> getAllBooks() {
		String url="http://admin-service:8181/book/getAllBooks";
	ResponseEntity<List<Books>> listOfBooks = restTemplate.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<List<Books>>() {});
	return listOfBooks.getBody();
	}

}
