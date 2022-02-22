package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bean.ReadLaterBooks;
import com.service.ReadLaterBooksService;

@RestController
@RequestMapping("/readLaterBooks")
public class ReadLaterBooksController {
	
	@Autowired
	ReadLaterBooksService readLaterBooksService;

	@PostMapping(value = "storeReadLaterBook", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeReadLaterBook(@RequestBody ReadLaterBooks books) {
		return readLaterBooksService.storeReadLaterBooks(books);
	}
	
	@GetMapping(value = "getReadLaterBook/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ReadLaterBooks> getReadLaterBook(@PathVariable("email") String email) {
		return readLaterBooksService.getReadLaterBooks(email);
	}
}
