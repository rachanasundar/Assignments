package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bean.Books;
import com.service.BooksService;



@RestController
@RequestMapping("/books")
@CrossOrigin
public class BooksController {
	@Autowired
	BooksService booksService;


	@GetMapping(value = "getAllBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Books> getAllBooks() {
		return booksService.getAllBooks();
	}

}
