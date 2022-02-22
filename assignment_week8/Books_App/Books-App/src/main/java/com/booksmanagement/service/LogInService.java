package com.booksmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booksmanagement.bean.Books;
import com.booksmanagement.bean.LogIn;
import com.booksmanagement.dao.LogInDao;

@Service
public class LogInService {
	
	@Autowired
	LogInDao user;
	
	//to conform the account creation 
		public String createAccount(LogIn info) {
			if( user.createNewAccount(info)>0){
				return "Sign in Successfully ";
			}
			else {
			return "Failed to Create Account. Try again ";
			}
		}
		
		//to verify the entered password
		public String checkPassword(long phNumber, String pass) {
			String storedPass = user.verifyPassword(phNumber);
			//if the user details are not stored in database
			if (storedPass==null) {
				return "Log In Failed. User Id unavailable. Please Sign in ";
				}
			//if entered passwords is same as that of the stored password in database
			else if (storedPass.equals(pass)) {
				return "Log In Successful";
			}
			//if entered password is not as same as the stored password in database
			else {
				return "Log In Failed. Invaild Password. Try Again";	
			}
		}
		
		//to get the name of the logged in user
		public String getUserName(long phNumber) {
			return user.getName(phNumber);
		}
		
	//to Store the book id and user id in the read later session 
		public String storeReadLaterBook(long phNumber, Books book) {
			
			
			if(user.storeReadLaterBook(phNumber, book)>0) {
				return " The Book "+ book.getBookId()+ " Added To Read Later List";
				
			}else {
				return "Failed To Add The Book "+ book.getBookId()+" To Read Later List";
			}
		}

		//to Store the book id and user id in the liked session 
		public String storeLikedBook(long phNumber, Books book) {
//			List likebook =user.getLikedBookIds(phNumber);
//			
//			String likeBook= user.getReadLaterBookIds(phNumber);
//			//to check if book exists in the list
//			if((!likeBook.isEmpty())&&likeBook.contains(bookId)){
//				
//				return "The Book "+book.getBookId()+" Already Exists In Liked List";
//			}
//			else
				if(user.storeLikedBook(phNumber, book)>0) {
				return "The Book "+book.getBookId()+"  Added To Liked List";
				
			}else {  
				return "Failed To Add The Book "+book.getBookId()+" To Liked List";
			}
		}
		



}
