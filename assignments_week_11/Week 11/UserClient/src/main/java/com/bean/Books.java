package com.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

//@Entity
public class Books {
	//@Id
	private int bookId;
	private String bookName;
	private String author;
	private String bookGenre;
	private String bookImageUrl;
	private float bookPrice;
	private float bookRating;


	public Books() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Books(int bookId, String bookName, String author, String bookGenre, String bookImageUrl, float bookPrice,
			float bookRating) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.author = author;
		this.bookGenre = bookGenre;
		this.bookImageUrl = bookImageUrl;
		this.bookPrice = bookPrice;
		this.bookRating = bookRating;
		
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", bookGenre=" + bookGenre
				+ ", bookImageUrl=" + bookImageUrl + ", bookPrice=" + bookPrice + ", bookRating=" + bookRating + "]";
	}

	

	

}
