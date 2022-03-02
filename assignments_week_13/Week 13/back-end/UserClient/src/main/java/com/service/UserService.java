package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User;
import com.dao.UserDao;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public String storeUser(User user) {
		if(userDao.existsById(user.getEmailId())) {
			return "Failed to Sign In. User details excist. Please Log In";
		}
		else {
			userDao.save(user);			
		return "Sign In Successfull";
		}
	}
	
	public String login(User user) {
		if(!userDao.existsById(user.getEmailId())) {
			return "User details not presnt. Please Sign In ";
		}else {
			User u = userDao.getById(user.getEmailId());
			if(u.getUserPassword().equals(user.getUserPassword())) {
				return "Log In Successfull";
			}
			else {
				return "Log In Failed. Wrong Password";
			}
		}
	}
	
	public String logOut(String email) {
		if(userDao.existsById(email)) {
		return"Log Out Successfully";
		}
		else {
			return "Unvaild User Id"; 
		}
	}
	

	

	
	

}
