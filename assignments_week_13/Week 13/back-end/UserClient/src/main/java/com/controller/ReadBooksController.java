package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bean.Readlater;

import com.service.ReadBooksService;

@RestController
@RequestMapping("/readbooks")
@CrossOrigin
public class ReadBooksController {

	@Autowired
ReadBooksService readBooksService;

	@GetMapping(value = "getAllLikedBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Readlater> getAllBooks() {
		return readBooksService.getAllLikedBooks();
	}

	@PostMapping(value = "storeReadBook", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeLikeBook(@RequestBody Readlater books) {
		return readBooksService.storeLikeBook(books);
	}

	@GetMapping(value = "getReadBook/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Readlater> getLikedBook(@PathVariable("email") String email) {
		return readBooksService.getLikedBook(email);
	}

}
