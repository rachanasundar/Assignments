package com.controller.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.bean.User;


class UserControllerTest {
	String baseUrl ="http://localhost:8282/userCurd";

	@Test
	void testStoreUserInfo() {
//		fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		User user= new User("ramesh@gmail.com","ramesh","12345" );
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<User> entity = new HttpEntity<>(user,headers);
		String url =baseUrl+"/storeUserInfo";
		String res= restTemplate.exchange(url, HttpMethod.POST, entity, String.class).getBody();
//		Assertions.assertEquals("User Stored successfully", res);
		Assertions.assertEquals("Failed to store User Info. User details excist.", res);
		
	}


	@Test
	void testGetAllUser() {
//		fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		String url=baseUrl+"/getAllUser";
		ResponseEntity<List<User>> listOfUser = restTemplate.exchange(url,HttpMethod.GET,null,new ParameterizedTypeReference<List<User>>() {});
		List<User>usersList= listOfUser.getBody(); 
		Assertions.assertTrue(usersList.stream().anyMatch(u->u.getUsername().equals("ramesh")));
	}

	@Test
	void testDeleteUserInfo() {
//		fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		String email="rach@gmail.com";
		HttpHeaders headers = new HttpHeaders();
	      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	      HttpEntity<User> entity = new HttpEntity<>(headers);
	    
		String url=baseUrl+"/deleteUserInfo/"+email;
		String res= restTemplate.exchange(url , HttpMethod.DELETE, entity, String.class).getBody();
		Assertions.assertEquals("User  " + email + " details not present", res);
	}

}
