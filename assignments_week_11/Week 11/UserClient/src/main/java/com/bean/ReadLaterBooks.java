package com.bean;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class ReadLaterBooks {
	@EmbeddedId
	private CompositeKey key;
	private String bookName;
	private String author;
	private String bookGenre;
	private String bookImageUrl;
	private float bookPrice;
	private float bookRating;
	public ReadLaterBooks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReadLaterBooks(CompositeKey key, String bookName, String author, String bookGenre, String bookImageUrl,
			float bookPrice, float bookRating) {
		super();
		this.key = key;
		this.bookName = bookName;
		this.author = author;
		this.bookGenre = bookGenre;
		this.bookImageUrl = bookImageUrl;
		this.bookPrice = bookPrice;
		this.bookRating = bookRating;
	}
	
	public CompositeKey getKey() {
		return key;
	}
	public void setKey(CompositeKey key) {
		this.key = key;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getBookGenre() {
		return bookGenre;
	}
	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}
	public String getBookImageUrl() {
		return bookImageUrl;
	}
	public void setBookImageUrl(String bookImageUrl) {
		this.bookImageUrl = bookImageUrl;
	}
	public float getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(float bookPrice) {
		this.bookPrice = bookPrice;
	}
	public float getBookRating() {
		return bookRating;
	}
	public void setBookRating(float bookRating) {
		this.bookRating = bookRating;
	}
	@Override
	public String toString() {
		return "ReadLaterBooks [key=" + key + ", bookName=" + bookName + ", author=" + author + ", bookGenre="
				+ bookGenre + ", bookImageUrl=" + bookImageUrl + ", bookPrice=" + bookPrice + ", bookRating="
				+ bookRating + "]";
	}
	
	
}
