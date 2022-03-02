package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bean.User;
import com.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping(value = "userSignIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody User user ) {
		return userService.storeUser(user);
	}
	
	@PostMapping(value = "userLogIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String logIn(@RequestBody User user ) {
		return userService.login(user);
	}
	
	@GetMapping(value = "userLogOut/{email}")
	public String logout(@PathVariable("email") String email) {
		return userService.logOut(email);
	}
	
	
}
