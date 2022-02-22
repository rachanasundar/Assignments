package com.bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class UserLikedBooks {
	@EmbeddedId
	private CompositeKeys keys;
	private String bookName;
	
	public CompositeKeys getKeys() {
		return keys;
	}
	public void setKeys(CompositeKeys keys) {
		this.keys = keys;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	@Override
	public String toString() {
		return "UserLikedBooks [keys=" + keys + ", bookName=" + bookName + "]";
	}
	
	
	
	
}
