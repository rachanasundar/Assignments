package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Admin;
import com.dao.AdminDao;

@Service
public class AdminService {
	@Autowired
	AdminDao adminDao;

	public String signIn(Admin admin) {
		if (adminDao.existsById(admin.getEmailId())) {
			return "Admin id must be unique";
		} else {
			adminDao.save(admin);
			return "Admin " + admin.getEmailId() + " Sign In Successful";
		}
	}

	public String logIn(Admin admin) {
		if (!adminDao.existsById(admin.getEmailId())) {
			return "Admin " + admin.getEmailId() + " details not present";
		} else {
			Admin a = adminDao.getById(admin.getEmailId());
			if (a.getAdminPassword().equals(admin.getAdminPassword())) {
				return "Admin " + admin.getEmailId() + " Log In Successful";
			} else {
				return "Admin " + admin.getEmailId() + " Log In Failed. Wrong Password";
			}
		}
	}

	public String logOut(String email) {
		if (adminDao.existsById(email)) {
			return "Successfully Log Out";
		} else {
			return "Failed to Log Out. Invaild email";
		}

	}

}
