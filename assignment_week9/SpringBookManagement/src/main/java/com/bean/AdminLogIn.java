package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminLogIn {
	@Id
	private String emailId;
	private String adminPassword;

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	@Override
	public String toString() {
		return "AdminLogIn [emailId=" + emailId + ", adminPassword=" + adminPassword + "]";
	}

}
