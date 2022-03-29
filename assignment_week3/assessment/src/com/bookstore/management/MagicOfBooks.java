package com.bookstore.management;
import com.bookstore.management.bean.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MagicOfBooks {
	
	//bookMap object to store books
	LinkedHashMap<Integer, Book> bookMap= new LinkedHashMap<>();
	
	
	 Scanner scanner=new Scanner(System.in);
	 
	 //to add new book
	 public void addBook() throws CustomeExceptions {
		  
		Book book=new Book();
			System.out.println("Enter a book id");
			book.setBookId(scanner.nextInt());
	
			System.out.println("Enter a book name");
			
			book.setBookName(scanner.next());
	
			System.out.println("Enter a book price");
			book.setPrice(scanner.nextInt());
	
			System.out.println("Enter a book genre");
			book.setGenre(scanner.next());
			
			System.out.println("Enter number of copies sold");
			book.setNoOfCopyesSold(scanner.nextInt());
			
			System.out.println("Enter a book status: Available/Soldout");
			book.setBookStatus(scanner.next());
			
			bookMap.put(book.getBookId(), book);
			System.out.println("Book added successfully");
			
}
	 
	 //to delete a book
	 public void deleteBook() throws  IOException {
		
		System.out.println("Enter book id you want to delete");
    	int id=scanner.nextInt();
    	bookMap.remove(id);
			System.out.println("Book deleted");
	}
	 
	 //to update a book
	public void updateBook() throws CustomeExceptions {
		
		Book b= new Book();
    	System.out.println("Enter a book id");
    	b.setBookId(scanner.nextInt());
    	
		System.out.println("Enter a book name");
		b.setBookName(scanner.next());

		System.out.println("Enter a book price");
		b.setPrice(scanner.nextInt());

		System.out.println("Enter a book genre");
		b.setGenre(scanner.next());
		
		System.out.println("Enter number of copies sold");
		b.setNoOfCopyesSold(scanner.nextInt());
		
		System.out.println("Enter a book status: Available/Soldout");
		b.setBookStatus(scanner.next());
		
		bookMap.replace(b.getBookId(), b);
		System.out.println("Book Updated Successfully");
		}
		
	
	public void displayBookInformation() {
		
		
	  List<Book> bookList = new ArrayList<>(bookMap.values());
	  if (!bookList.isEmpty()) 
		{
		bookList.stream().forEach(book->System.out.println(book));
		}
		else {
			System.out.println("books is Empty");
		}


		
	}

	public void countAllBooks() throws IOException {
		
		System.out.println("Number of books present in a store : "+bookMap.size());
		
		
	}

	//to find book with genre Autobiography
	public void genreAutobiography() {
		List<Book> bookListA = new ArrayList<>(bookMap.values());
		bookListA.stream().filter(s->s.getGenre().equalsIgnoreCase("Autobiography")).forEach(s->System.out.println(s));
			if(bookListA.stream().filter(s->s.getGenre().equalsIgnoreCase("Autobiography")).count()==0)
			System.out.println("No books found");
	}
	//to display the book list from low to high price
	public void lowToHigh(int i) {
		List<Book> bookListL = new ArrayList<>(bookMap.values());
		if (bookListL.size() > 0) {
		
		List<Book> sortedBook= bookListL.stream().sorted((b1,b2)->b1.getPrice()-(b2.getPrice())).collect(Collectors.toList());
		sortedBook.stream().forEach(b->System.out.println(b));
		}	
		else {
			System.out.println("books is Empty");
		}
	}

	//to display the book list from high to low price
	public void highToLow(int i) {
		List<Book> bookListH = new ArrayList<>(bookMap.values());
		if (bookListH.size() > 0) {
		
		List<Book> sortedBook2= bookListH.stream().sorted((b1,b2)->b2.getPrice()-(b1.getPrice())).collect(Collectors.toList());
		sortedBook2.stream().forEach(b->System.out.println(b));
		}	
		else {
			System.out.println("books is Empty");
		}
	
	}
	// to find best selling books based on number of copies sold
	public void bestSelling(int i) {
		List<Book> bookListS = new ArrayList<>(bookMap.values());
		if (bookListS.size() > 0) {
		List<Book> sortedBook3= bookListS.stream().sorted((b1,b2)->b2.getNoOfCopyesSold()-(b1.getNoOfCopyesSold())).collect(Collectors.toList());
		sortedBook3.stream().forEach(b->System.out.println(b));
			
		}
	         
	   }
	

	
	
	
}	
		

