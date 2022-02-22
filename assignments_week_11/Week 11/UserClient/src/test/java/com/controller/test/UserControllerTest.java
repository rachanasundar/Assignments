package com.controller.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.client.RestTemplate;

import com.bean.User;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {
	String baseUrl="http://localhost:8282/user";
	
	

	@Test
	void testSignIn() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		
		User user = new User();
		user.setEmailId("ravi@gmail.com");
		user.setUserPassword("12345");
		user.setUsername("Ravi");
		
		String result = restTemplate.postForObject(baseUrl+"/userSignIn",user, String.class);
		
		//Assertions.assertEquals("User Stored successfully", result);
		Assertions.assertEquals("Failed to store User Info. User details excist.", result);
	}

	@Test
	void testLogIn() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		
		User user = new User();
		user.setEmailId("ravi@gmail.com");
		user.setUserPassword("12345");
				
		String result = restTemplate.postForObject(baseUrl+"/userLogIn",user, String.class);
		
		Assertions.assertEquals("Log In Successfull", result);
		
	}

	@Test
	void testLogout() {
		//fail("Not yet implemented");
				RestTemplate restTemplate = new RestTemplate();
									
				String result = restTemplate.getForObject(baseUrl+"/userLogOut/raj@gmail.com", String.class);
				
				Assertions.assertEquals("Log Out Successfully", result);
		
	}

}
