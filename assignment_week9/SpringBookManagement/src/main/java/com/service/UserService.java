package com.service;

import java.util.List;
import java.util.Optional;

import org.dom4j.util.UserDataDocumentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Books;
import com.bean.User;
import com.dao.UserDao;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public String storeUserInfo(User user) {

		if (userDao.existsById(user.getEmailId())) {
			return "User id must be unique";
		} else {
			userDao.save(user);
			return "User " + user.getEmailId() + " stored successfully";
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

	public Optional<User> getUserById(String email) {
		return userDao.findById(email);
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
