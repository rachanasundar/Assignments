package com.service;

import java.util.List;
import java.util.Optional;

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
			return "Failed to store User Info. User details excist.";
		}
		else {
			userDao.save(user);			
		return "User Stored successfully";
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
	

	public String updateUserName(User user) {
		if (!userDao.existsById(user.getEmailId())) {
			return "User " + user.getEmailId() + " details not present";
		} else {
			User u = userDao.getById(user.getEmailId());
			u.setUsername(user.getUsername());
			userDao.saveAndFlush(u);
			return "User " + user.getEmailId() + " name updated successfully";
		}

	}
	public String updateUserPassword(User user) {
		if (!userDao.existsById(user.getEmailId())) {
			return "User " + user.getEmailId() + " details not present";
		} else {
			User u = userDao.getById(user.getEmailId());
			u.setUserPassword(user.getUserPassword());
			userDao.saveAndFlush(u);
			return "User " + user.getEmailId() + " password updated successfully";
		}

	}

	public List<User> getAllUser() {
		return userDao.findAll();
	}


	public String deleteUserInfo(String email) {
		if (!userDao.existsById(email)) {
			return "User  " + email + " details not present";
		} else {
			userDao.deleteById(email);
			return "User " + email + " deleted successfully";
		}
	}

	
	

}
