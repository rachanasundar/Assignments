package com.service.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.bean.Admin;
import com.dao.AdminDao;
import com.service.AdminService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class AdminServiceTest {

	@Mock
	AdminDao adminDao;
	@InjectMocks
	AdminService adminService;


	@Test
	void testSignIn() {
		// fail("Not yet implemented");
		Admin admin = new Admin();
		admin.setEmailId("admin@gmail.com");
		admin.setAdminPassword("admin");
		String result = adminService.signIn(admin);
		Assertions.assertEquals("Admin " + admin.getEmailId() + " Sign In successfully", result);
	}

	@Test
	void testLogIn() {
		// fail("Not yet implemented");

		Admin admin = new Admin();
		admin.setEmailId("admin@gmail.com");
		admin.setAdminPassword("admin");
		Mockito.when(adminDao.existsById(admin.getEmailId())).thenReturn(true);
		Mockito.when(adminDao.getById(admin.getEmailId())).thenReturn(admin);
		String result = adminService.logIn(admin);
		Assertions.assertEquals("Admin " + admin.getEmailId() + " Log In Succesful", result);

	}

	@Test
	void testLogOut() {
		// fail("Not yet implemented");
		Mockito.when(adminDao.existsById("admin@gmail.com")).thenReturn(true);
		String result = adminService.logOut("admin@gmail.com");
		Assertions.assertEquals("Successfully Log Out", result);
	}

}
