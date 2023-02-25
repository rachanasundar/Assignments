package com.bookstore.management.bean;
import java.io.Serializable;
import com.bookstore.management.CustomeExceptions;

public class Book {
	private int bookId;
	private String bookName;
	private int price;
	private String genre;
	private int noOfCopyesSold;
	private String bookStatus;
	
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getBookName() {
		return bookName;
	}
	public int getPrice() {
		return price;
	}
	public Book(int bookId, String bookName, int price, String genre, int noOfCopyesSold, String bookStatus) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.price = price;
		this.genre = genre;
		this.noOfCopyesSold = noOfCopyesSold;
		this.bookStatus = bookStatus;
	}

	public String getGenre() {
		return genre;
	}
	public int getNoOfCopyesSold() {
		return noOfCopyesSold;
	}
	public String getBookStatus() {
		return bookStatus;
	}
	
	
	// throws expception if invaild input is added
	public void setBookName(String bookName) throws CustomeExceptions  {
		if(bookName.isEmpty()) {
			throw new CustomeExceptions("Enter a proper  book name");
		}else
		this.bookName = bookName;
	}
	
	public void setPrice(int price)throws CustomeExceptions {
		if(price<=0)
		{
			throw new CustomeExceptions("Price cannot less than or equal to zero");			
		}
		else {
		this.price = price;
		}	}
	
	
	public void setGenre(String genre) throws CustomeExceptions {
		if(genre.isEmpty()) {
			throw new CustomeExceptions("Enter a proper Genre");}
		else
		this.genre = genre;
		
	}
	
	public void setNoOfCopyesSold(int noOfCopyesSold)throws CustomeExceptions {
		
		if(noOfCopyesSold<=0)
		{
			throw new CustomeExceptions("Number Of Copies Sold cannot less than or equal to zero");			
		}
		else {
			this.noOfCopyesSold = noOfCopyesSold;
								}
		
	
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) throws CustomeExceptions {
		if(bookId<=0)
		{
			throw new CustomeExceptions("Book Id cannot less than or equal to zero");			
		}else {
			this.bookId = bookId;
		}
		
	}
	
	public void setBookStatus(String bookStatus) throws CustomeExceptions {
		if(bookStatus.isEmpty()) {
			throw new CustomeExceptions("Enter a proper  book status ");
		}else
		this.bookStatus = bookStatus;
	}
	
	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", bookName=" + bookName + ", price=" + price + ", genre=" + genre
				+ ", noOfCopyesSold=" + noOfCopyesSold + "]";
	}
	

}
