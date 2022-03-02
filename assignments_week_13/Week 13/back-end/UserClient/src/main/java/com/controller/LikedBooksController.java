package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Likedbooks;
import com.service.LikedBooksService;

@RestController
@RequestMapping("/likedBooks")
@CrossOrigin
public class LikedBooksController {

	@Autowired
	LikedBooksService likedService;

	@GetMapping(value = "getAllLikedBooks", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Likedbooks> getAllBooks() {
		return likedService.getAllLikedBooks();
	}

	@PostMapping(value = "storeLikeBook", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeLikeBook(@RequestBody Likedbooks books) {
		return likedService.storeLikeBook(books);
	}

	@GetMapping(value = "getLikedBook/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Likedbooks> getLikedBook(@PathVariable("email") String email) {
		return likedService.getLikedBook(email);
	}

}
