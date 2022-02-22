package com.bean;


public class User {

	private String emailId;
	private String username;
	private String userPassword;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String emailId, String username, String userPassword) {
		super();
		this.emailId = emailId;
		this.username = username;
		this.userPassword = userPassword;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "User [emailId=" + emailId + ", username=" + username + ", userPassword=" + userPassword + "]";
	}
}
