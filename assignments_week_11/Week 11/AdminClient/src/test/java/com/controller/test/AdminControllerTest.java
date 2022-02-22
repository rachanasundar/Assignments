package com.controller.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.web.client.RestTemplate;

import com.bean.Admin;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class AdminControllerTest {
	String baseUrl="http://localhost:8181/admin";
	@Test
	void testSignIn() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		Admin admin = new Admin();
		admin.setEmailId("admin@gmail.com");
		admin.setAdminPassword("admin");
		
		String result = restTemplate.postForObject(baseUrl+"/adminSignIn",admin, String.class);
		Assertions.assertEquals("Admin id must be unique", result);
		//Assertions.assertEquals("Admin " + admin.getEmailId() + " Sign In successfully", result);
	}
	

	@Test
	void testLogIn() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		Admin admin = new Admin();
		admin.setEmailId("admin@gmail.com");
		admin.setAdminPassword("admin");
		String result = restTemplate.postForObject(baseUrl+"/adminLogIn",admin, String.class);
		Assertions.assertEquals( "Admin " + admin.getEmailId() + " Log In Succesful", result);
		
	}

	@Test
	void testLogOut() {
		//fail("Not yet implemented");
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.getForObject(baseUrl+"/adminLogOut/admin@gmail.com", String.class);
		
		Assertions.assertEquals("Successfully Log Out", result);
	}

}
