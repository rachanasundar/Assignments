package com.booksmanagement.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.booksmanagement.bean.Books;
import com.booksmanagement.bean.LogIn;
import com.booksmanagement.service.LogInService;

@Controller
public class LogInController {
	
	@Autowired
	LogInService logInService ;
	
	HttpSession hs;
	
	
	@PostMapping(value = "login")
	public ModelAndView userLogIn(HttpServletRequest request, HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		long userNumber= Long.parseLong(request.getParameter("phoneNumber"));
		String pass= request.getParameter("pass");
		String loginResult = logInService.checkPassword(userNumber, pass);
		
		//if  login is successful
		if(loginResult.contains("Successful")){
			String userName=logInService.getUserName(userNumber);
						
			hs.setAttribute("objectName", userName);
			hs.setAttribute("objNumber", userNumber);
			hs.setAttribute("objLogInResult", loginResult);
			}
		//if login fails 
		else if (loginResult.contains("Failed")){
			hs.setAttribute("objLogInResult", loginResult);
		}
		else {
			hs.setAttribute("objLogInResult", null);
		}
				mav.setViewName("index.jsp");
		
		return mav;
		}
	
	
	@PostMapping(value = "signin")
	public ModelAndView userSignIn(HttpServletRequest request,HttpSession hs) {
		
		ModelAndView mav = new ModelAndView();
		long phoneNumb= Long.parseLong(request.getParameter("phone_number"));
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password= request.getParameter("password");
		String signinResult = logInService.createAccount(new LogIn(phoneNumb, email, name, password));
		
		hs.setAttribute("objectName", name);
		hs.setAttribute("objNumber", phoneNumb);
		hs.setAttribute("objLogInResult",signinResult);
		mav.setViewName("index.jsp");
		return mav;
	}
	
	@PostMapping(value = "likebook")
	public ModelAndView storeLikeBook(HttpServletRequest request,HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		
		//to get book id of liked books
		int  bookId= Integer.parseInt(request.getParameter("likedBookId"));
		long phoneNumber=Long.parseLong(request.getParameter("userNumber"));
		Object obj = hs.getAttribute("objBooks");
		String likedBookResult=null;
		List<Books> listOfBooks = (List<Books>)obj;
		if(listOfBooks!=null) {
			Iterator<Books> ii = listOfBooks.iterator();
			
			while(ii.hasNext()) {
				Books book = ii.next();
				
				if(bookId==book.getBookId()) {
					
					//to store the liked book details in database
					likedBookResult = logInService.storeLikedBook(phoneNumber, book);
					request.setAttribute("objStoreBookResult", likedBookResult);
				}
			}
		}
		hs.setAttribute("objStoreBookResult", likedBookResult);
		mav.setViewName("index.jsp");
		return mav;
	}
	
	
	
	
	@PostMapping(value = "readbook")
	public ModelAndView storeReadLaterBook(HttpServletRequest request,HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		//to get book id of read later books
		int  bookId= Integer.parseInt(request.getParameter("readLaterBookId"));
		long phoneNumber=Long.parseLong(request.getParameter("userNumber"));
		Object obj = hs.getAttribute("objBooks");
		String readLaterBookResult=null;
		List<Books> listOfBooks = (List<Books>)obj;
		if(listOfBooks!=null) {
			Iterator<Books> ii = listOfBooks.iterator();
			
			while(ii.hasNext()) {
				Books book = ii.next();
				if(bookId==book.getBookId()) {
					//to store the book details of read later book
					readLaterBookResult = logInService.storeReadLaterBook(phoneNumber, book);
					request.setAttribute("objStoreBookResult", readLaterBookResult);
				}
			}
		}
		hs.setAttribute("objStoreBookResult", readLaterBookResult);
		mav.setViewName("index.jsp");
		return mav;
	}
	
	
	
	@GetMapping(value = "home")
	public ModelAndView homePage(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index.jsp");
		return mav;
	}
	@GetMapping(value = "loginbtn")
	public ModelAndView loginpage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login.jsp");
		return mav;
	}
	@GetMapping(value = "signinbtn")
	public ModelAndView signinpage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("signin.jsp");
		return mav;
	}
	
	@GetMapping(value = "logout")
	public ModelAndView logoutpage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("logout.jsp");
		return mav;
	}
	

}