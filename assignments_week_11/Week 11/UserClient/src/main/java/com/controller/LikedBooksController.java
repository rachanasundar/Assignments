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

import com.bean.LikedBooks;
import com.service.LikedBooksService;

@RestController
@RequestMapping("/likedBooks")
public class LikedBooksController {
	
	@Autowired
	LikedBooksService likedBooksService;
	
	@PostMapping(value = "storeLikeBook", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeLikeBook(@RequestBody LikedBooks books) {
		return likedBooksService.storeLikedBooks(books);
	}
	
	@GetMapping(value = "getLikedBook/{email}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<LikedBooks> getLikedBook(@PathVariable("email") String email) {
		return likedBooksService.getLikedBooks(email);
	}

}
