package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.Books;
import com.hcl.repository.BooksRepository;
import com.hcl.service.BooksService;

@RestController
@RequestMapping(value = "/books")
public class BooksController {

	@Autowired
	private BooksService booksService;

	@PostMapping("/create")
	private int saveBook(@RequestBody Books books) {
		booksService.saveBook(books);
		return books.getBookId();
	}

	// creating put mapping that updates the book detail
	@PutMapping("/update/{bookId}")
	private Books update(@RequestBody Books books, @PathVariable("bookId") int bookId) {
		Books book = booksService.getBookById(bookId);
		booksService.updateBook(book);
		return book;
	}

	// getBook by bookId
	@GetMapping(value = "/{bookId}")
	public Books getBookById(@PathVariable int bookId) {
		return booksService.getBookById(bookId);

	}

	// get all books
	@GetMapping(value = "/all")
	public List<Books> getAllBooks() {
		return booksService.getAllBooks();

	}

	@DeleteMapping(value = "/delete/{bookId}")
	public void deleteBook(@PathVariable int bookId) {
		// Books book = booksService.getBookById(bookId);
		booksService.deleteBook(bookId);

	}

}
