package com.booksmanagement.bean;

public class Books {
	
	private int bookId;
	private String bookName;
	private String author;
	private String bookGenre;
	private String bookImageUrl;
	private float bookRating;
	private String bookPublisher;
	
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
	public float getBookRating() {
		return bookRating;
	}
	public void setBookRating(float bookRating) {
		this.bookRating = bookRating;
	}
	public String getBookPublisher() {
		return bookPublisher;
	}
	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", bookGenre=" + bookGenre
				+ ", bookImageUrl=" + bookImageUrl + ", bookRating=" + bookRating + ", bookPublisher=" + bookPublisher
				+ "]";
	}

}
