package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.AdminLogIn;
import com.bean.User;
import com.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;

	@PostMapping(value = "adminSignIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String signIn(@RequestBody AdminLogIn admin) {
		return adminService.storeAdminInfo(admin);
	}

	@PatchMapping(value = "updateAdminPassword")
	public String updateAdminPassword(@RequestBody AdminLogIn admin) {
		return adminService.updateAdminPassword(admin);
	}

	@PostMapping(value = "adminLogIn", consumes = MediaType.APPLICATION_JSON_VALUE)
	public String logIn(@RequestBody AdminLogIn admin) {
		return adminService.login(admin);
	}

	@GetMapping(value = "adminLogOut/{email}")
	public String logout(@PathVariable("email") String email) {
		return adminService.logOut(email);
	}
}
