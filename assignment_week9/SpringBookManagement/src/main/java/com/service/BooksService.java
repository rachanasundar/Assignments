package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Books;
import com.dao.BooksDao;

@Service
public class BooksService {

	@Autowired
	BooksDao booksDao;

	public List<Books> getAllBooks() {
		return booksDao.findAll();
	}

	public Optional<Books> getBookById(int bookId) {
		return booksDao.findById(bookId);
	}

	public String storeBook(Books book) {

		if (booksDao.existsById(book.getBookId())) {
			return "Book id must be unique";
		} else {
			booksDao.save(book);
			return "Book " + book.getBookId() + " stored successfully";
		}
	}

	public String deleteBook(int bookId) {
		if (!booksDao.existsById(bookId)) {
			return "Book  " + bookId + " details not present";
		} else {
			booksDao.deleteById(bookId);
			return "Book " + bookId + " deleted successfully";
		}
	}

	public String updateBookName(Books book) {
		if (!booksDao.existsById(book.getBookId())) {
			return "Book details not present";
		} else {
			Books b = booksDao.getById(book.getBookId());
			b.setBookName(book.getBookName());
			booksDao.saveAndFlush(b);
			return "Book updated successfully";
		}
	}

	public String updateAuthor(Books book) {
		if (!booksDao.existsById(book.getBookId())) {
			return "Book details not present";
		} else {
			Books b = booksDao.getById(book.getBookId());
			b.setAuthor(book.getAuthor());
			booksDao.saveAndFlush(b);
			return "Book updated successfully";
		}
	}

	public String updateBookGenre(Books book) {
		if (!booksDao.existsById(book.getBookId())) {
			return "Book details not present";
		} else {
			Books b = booksDao.getById(book.getBookId());
			b.setBookGenre(book.getBookGenre());
			booksDao.saveAndFlush(b);
			return "Book updated successfully";
		}
	}

	public String updateBookPrice(Books book) {
		if (!booksDao.existsById(book.getBookId())) {
			return "Book details not present";
		} else {
			Books b = booksDao.getById(book.getBookId());
			b.setBookPrice(book.getBookPrice());
			booksDao.saveAndFlush(b);
			return "Book updated successfully";
		}
	}

	public String updateBookStock(Books book) {
		if (!booksDao.existsById(book.getBookId())) {
			return "Book details not present";
		} else {
			Books b = booksDao.getById(book.getBookId());
			b.setBookStock(book.getBookStock());
			booksDao.saveAndFlush(b);
			System.out.println(b);
			return "Book updated successfully";
		}
	}
}
