package com.controller;

import java.util.List;
import java.util.Optional;

import org.aspectj.internal.lang.annotation.ajcDeclareAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Books;
import com.bean.User;
import com.service.UserService;

@RestController
@RequestMapping("/userCurd")
@CrossOrigin
public class UserControllerForAdmin {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping(value = "storeUserInfo",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeUserInfo(@RequestBody User user) {
		
				return userService.storeUser(user);
	}
	
	@PatchMapping(value = "updateUserName")
	public String updateUserName(@RequestBody User user) {
					return userService.updateUserName(user);
	}
	
	@PatchMapping(value = "updateUserPassword")
	public String updateUserPassword(@RequestBody User user) {
					return userService.updateUserPassword(user);
	}
	
	@GetMapping(value="getAllUser")
	public List<User> getAllUser() {
		return userService.getAllUser();
	}
	
	
	@DeleteMapping(value = "deleteUserInfo/{email}")
	public String deleteUserInfo(@PathVariable("email") String  email)
	{
		return userService.deleteUserInfo(email);
	}
	

}
