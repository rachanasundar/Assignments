package com.bookstore.management;


import java.io.IOException;
import java.util.Scanner;

public class BookStoreManagementSystem {

	public static void main(String[] args) throws CustomeExceptions, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		
		MagicOfBooks mBook=new MagicOfBooks();
		boolean flag = true;
		while (flag) {
			System.out.println("1. Add entry into book");
			System.out.println("2. Delete entries from book");
			System.out.println("3. Update a book");
			System.out.println("4. Display all books" );
			System.out.println("5. Total count of books");
			System.out.println("6. Search for Autobiography books");
			System.out.println("7. Display by order");
			System.out.println("0. Exit");
			
			
			System.out.println("Enter your choice:");
			int choice = sc.nextInt();
			switch (choice) {
			case 0 : //to exit from while loop
				flag = false;
					break;
			case 1://to add book
						System.out.println("Enter a number of books you want to add");
						int n=sc.nextInt();
						
						for(int i=1;i<=n;i++) {
							mBook.addBook();
							}
						mBook.addBookToFile();
						break;
				
			case 2://Delete a book
					mBook.deleteBook();
				    break;
			case 3://Update a book
				mBook.updateBook();
				break;
			case 4:// display all information of book
				mBook.displayBookInformation();
				break;
			case 5:// to count the number of book
				System.out.println("Count of all books-");
				mBook.countAllBooks();
				break;
			case 6://to find with genre autobiography
				mBook.genreAutobiography();
			      break;
			case 7:
					System.out.println("Enter your choice:");
					System.out.println("1.Price low to high ");
					System.out.println("2.Price high to low ");
					System.out.println("3.Best selling");
				int ch = sc.nextInt();

				switch (ch) {

				case 1 : mBook.lowToHigh(1);
				         break;
				case 2:mBook.highToLow(2); 
				         break;
				case 3:mBook.bestSelling(3);
				        break;
				 default:System.out.println("Wrong choice.!");
				 break;
				}
			
			default:
				System.out.println("Wrong choice.!");
				break;

						
					
				    
			}
		}
		System.out.println("-------------------------------------------------------------------------");

}
}
