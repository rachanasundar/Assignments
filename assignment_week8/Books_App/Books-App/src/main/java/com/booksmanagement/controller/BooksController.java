package com.booksmanagement.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.booksmanagement.bean.Books;
import com.booksmanagement.service.BooksService;

@Controller
public class BooksController {
	
	@Autowired
	BooksService bookService;
	

	
	@GetMapping(value = "books")
	public ModelAndView getAllBooks(HttpServletRequest request, HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		List<Books> listOfBooks = bookService.getAllBooks();
		hs.setAttribute("objBooks", listOfBooks);
		mav.setViewName("displayBooks.jsp");
		return mav;
	}
	
	
	@GetMapping(value = "like")
	public ModelAndView likePage(HttpServletRequest request,HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		long phNumber = (long) hs.getAttribute("objNumber");
		List<Books> listOfLikedBooks= bookService.getLikedBooks(phNumber);
		hs.setAttribute("objLikedBookList", listOfLikedBooks);
		mav.setViewName("like.jsp");
		return mav;
	}
	
	@GetMapping(value = "readlater")
	public ModelAndView readLaterPage(HttpServletRequest request,HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		long phNumber = (long) hs.getAttribute("objNumber");
		List<Books> listOfReadLaterBooks = bookService.geReadLaterBooks(phNumber);
		hs.setAttribute("objReadLaterBooks", listOfReadLaterBooks);
		mav.setViewName("readlater.jsp");
		return mav;
	}
	
}
