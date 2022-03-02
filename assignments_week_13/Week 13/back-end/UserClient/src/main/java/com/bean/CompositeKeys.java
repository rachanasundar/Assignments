package com.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class CompositeKeys implements Serializable {
	private String emailId;
	private int bookId;
	
	
	public CompositeKeys() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompositeKeys(String emailId, int bookId) {
		super();
		this.emailId = emailId;
		this.bookId = bookId;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	@Override
	public String toString() {
		return "CompositeKeys [emailId=" + emailId + ", bookId=" + bookId + "]";
	}

}
