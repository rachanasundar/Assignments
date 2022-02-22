package com.controller;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bean.Books;
import com.bean.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	RestTemplate restTemplate;
	
	
	@PostMapping(value = "storeUser", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeUserInfo(@RequestBody User user ) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> entity = new HttpEntity<>(user,headers);
		String url = "http://user-service:8282/userCurd/storeUserInfo";
		return restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
		
	}
	
	@PutMapping(value = "updateUserName", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateUserName(@RequestBody User user ) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> entity = new HttpEntity<>(user,headers);
		String url = "http://user-service:8282/userCurd/updateUserName";
		//return  restTemplate.patchForObject(url, user, String.class);
		return restTemplate.exchange(url, HttpMethod.PUT, entity, String.class).getBody();
		
	}
	@PatchMapping(value = "updateUserPassword", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateUserPassword(@RequestBody User user ) {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> entity = new HttpEntity<>(user,headers);
		String url = "http://user-service:8282/userCurd/updateUserPassword";
//		return  restTemplate.patchForObject(url, user, String.class);
		return restTemplate.exchange(url, HttpMethod.PATCH, entity, String.class).getBody();
		
	}
	
	@GetMapping(value="getAllUser", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> getAllUser() {
		String url="http://user-service:8282/userCurd/getAllUser";
		ResponseEntity<List<User>> listOfUser = restTemplate.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<List<User>>() {});
		return listOfUser.getBody();   
	}
	
	@DeleteMapping(value = "deleteUserInfo/{email}")
	public String deleteUserInfo(@PathVariable("email") String  email)
	{
		  HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<User> entity = new HttpEntity<>(headers);
		String url="http://user-service:8282/userCurd/deleteUserInfo"+email;
		return restTemplate.exchange(url , HttpMethod.DELETE, entity, String.class).getBody();
		
	}

}
