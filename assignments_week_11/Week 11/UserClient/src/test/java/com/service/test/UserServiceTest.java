package com.service.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;
@ExtendWith(MockitoExtension.class)
class UserServiceTest {
	
	@Mock
	UserDao userDao;
	
	@InjectMocks
	UserService userService;
	

	@Test
	void testStoreUser() {
		//fail("Not yet implemented");
		User user =new User();
		user.setEmailId("raj@gmail.com");
		user.setUsername("Raj");
		user.setUserPassword("12345");
		String result = userService.storeUser(user);
		Assertions.assertEquals("User Stored successfully",result);
		
	}

	@Test
	void testLogin() {
		//fail("Not yet implemented");
		User user =new User();
		user.setEmailId("raj@gmail.com");
		user.setUserPassword("12345");
		Mockito.when(userDao.existsById(user.getEmailId())).thenReturn(true);
		Mockito.when(userDao.getById(user.getEmailId())).thenReturn(user);
		Assertions.assertEquals("Log In Successfull", userService.login(user));
		
	}

	@Test
	void testLogOut() {
		//fail("Not yet implemented");
		Mockito.when(userDao.existsById("raj@gmail.com")).thenReturn(true);
		String result = userService.logOut("raj@gmail.com");
		Assertions.assertEquals("Log Out Successfully", result);
	}

	@Test
	void testUpdateUserName() {
		//fail("Not yet implemented");
		User user =new User();
		user.setEmailId("raj@gmail.com");
		user.setUsername("Raj");
		Mockito.when(userDao.existsById(user.getEmailId())).thenReturn(true);
		Mockito.when(userDao.getById(user.getEmailId())).thenReturn(user);
		Assertions.assertEquals("User " + user.getEmailId() + " name updated successfully",userService.updateUserName(user) );
		
	}

	@Test
	void testUpdateUserPassword() {
		//fail("Not yet implemented");
		User user =new User();
		user.setEmailId("raj@gmail.com");
		user.setUserPassword("raj123");
		Mockito.when(userDao.existsById(user.getEmailId())).thenReturn(true);
		Mockito.when(userDao.getById(user.getEmailId())).thenReturn(user);
		Assertions.assertEquals("User " + user.getEmailId() + " password updated successfully",userService.updateUserPassword(user) );
	}

	@Test
	void testGetAllUser() {
		//fail("Not yet implemented");
		List<User> listOfUsers = new ArrayList<User>();
		User user1= new User("ravi@gmail.com", "Ravi","1234");
		User user2= new User("ravish@gmail.com", "Ravish","1234");
		listOfUsers.add(user1);
		listOfUsers.add(user2);
		Mockito.when(userDao.findAll()).thenReturn(listOfUsers);
		Assertions.assertTrue(userService.getAllUser().stream().count()==2);
	}


	@Test
	void testDeleteUserInfo() {
		//fail("Not yet implemented");
		String email ="ravi@gmail.com";
		Mockito.when(userDao.existsById(email)).thenReturn(true);
		Assertions.assertEquals("User " + email + " deleted successfully", userService.deleteUserInfo(email));
	}

}
