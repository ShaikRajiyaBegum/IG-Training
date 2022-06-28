package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.Books;
import com.hcl.repository.BooksRepository;

@Service
public class BooksService {

	@Autowired
	private BooksRepository booksRepository;

	// save book
	public void saveBook(Books book) {
		booksRepository.save(book);
	}

	// get book By bookId
	public Books getBookById(int bookId) {
		return booksRepository.findById(bookId).orElse(new Books());

	}

	// getAllBooks
	public List<Books> getAllBooks() {
		List<Books> books = booksRepository.findAll();
		return books;

	}

	// update book
	public void updateBook(Books book) {

		booksRepository.save(book);

	}

	// delete book
	public void deleteBook(int bookId) {
		booksRepository.deleteById(bookId);

	}

}
