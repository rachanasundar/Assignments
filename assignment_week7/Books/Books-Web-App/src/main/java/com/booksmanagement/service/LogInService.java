package com.booksmanagement.service;

import java.util.List;

import com.booksmanagement.bean.LogIn;
import com.booksmanagement.dao.LogInDao;

public class LogInService {
	
	LogInDao user= new LogInDao();
	
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
		if (user.verifyPassword(phNumber, pass)==true) {
			return "Log In Successful";
		}else {
			return "Log In Failed. Try Again";
			}
	}
	
	//to get the name of the logged in user
	public String getUserName(long phNumber) {
		return user.getName(phNumber);
	}
	
//to Store the book id and user id in the read later session 
	public String storeReadLaterBook(long phNumber, int bookId) {
		
		//to check if book exists in the list
		if(user.getReadLaterBookIds(phNumber)!=null && user.getReadLaterBookIds(phNumber).contains(bookId)) {
			return "The Book "+ bookId+" Already Exists In Read Later List";
		}
		else if(user.storeReadLaterBook(phNumber, bookId)>0) {
			return " The Book "+ bookId+ " Added To Read Later List";
			
		}else {
			return "Failed To Add The Book "+ bookId+" To Read Later List";
		}
	}

	//to Store the book id and user id in the liked session 
	public String storeLikedBook(long phNumber, int bookId) {
		
		if(user.getLikedBookIds(phNumber)!=null &&user.getLikedBookIds(phNumber).contains(bookId)) {
			return "The Book "+bookId+" Already Exists In Liked List";
		}
		else if(user.storeLikedBook(phNumber, bookId)>0) {
			return "The Book "+bookId+" Added To Liked List";
			
		}else {
			return "Failed To Add The Book"+bookId+" To Liked List";
		}
	}
	
	//to retrieve all the book ids of a particular from the liked session 
	public List<Integer> getlikedbooks(long phNumb){
		return user.getLikedBookIds(phNumb);
		
	}
	//to retrieve all the book ids of a particular from the read later session 
	public List<Integer> getReadLaterBook(long phNumb){
		return user.getReadLaterBookIds(phNumb);
	}

}

