package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.stereotype.Service;

import com.bean.AdminLogIn;
import com.bean.User;
import com.dao.AdminDao;

@Service
public class AdminService {

	@Autowired
	AdminDao adminDao;

	public String storeAdminInfo(AdminLogIn admin) {

		if (adminDao.existsById(admin.getEmailId())) {
			return "Admin id must be unique";
		} else {
			adminDao.save(admin);
			return "Admin " + admin.getEmailId() + " Sign In successfully";
		}
	}

	public String updateAdminPassword(AdminLogIn admin) {
		if (!adminDao.existsById(admin.getEmailId())) {
			return "Admin " + admin.getEmailId() + " details not present";
		} else {
			AdminLogIn a = adminDao.getById(admin.getEmailId());
			a.setAdminPassword(admin.getAdminPassword());
			adminDao.saveAndFlush(a);
			return "Admin" + admin.getEmailId() + " password updated successfully";
			
		}

	}

	public String login(AdminLogIn admin) {
		if (!adminDao.existsById(admin.getEmailId())) {
			return "Admin " + admin.getEmailId() + " details not present";
		} else {
			AdminLogIn a = adminDao.getById(admin.getEmailId());
			if (a.getAdminPassword().equals(admin.getAdminPassword())) {
				return "Admin " + admin.getEmailId() + " Log In Succesful";
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
