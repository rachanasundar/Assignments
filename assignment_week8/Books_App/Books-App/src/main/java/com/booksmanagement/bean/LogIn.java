package com.booksmanagement.bean;

public class LogIn {
	private long phoneNumber;
	 private String emailId;
	 private String name;
	 private String password;
		 
	public LogIn() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LogIn(long phoneNumber, String emailId, String name, String password) {
		super();
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.name = name;
		this.password = password;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
