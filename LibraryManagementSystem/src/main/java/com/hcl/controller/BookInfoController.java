
package com.hcl.controller;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.exception.ResourceNotFoundException;
import com.hcl.model.BookInfo;
import com.hcl.model.User;
import com.hcl.repository.UserRepository;
import com.hcl.service.BookInfoService;

@RestController
@RequestMapping(value = "/lms/bookInfo")
public class BookInfoController {

	@Autowired
	private BookInfoService bookInfoService;

	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(BookInfoController.class);

	// Create Book

	@PostMapping("/create/{libId}")
	public ResponseEntity<BookInfo> createBook(@PathVariable Long libId, @RequestBody BookInfo bookInfo) {

		LOGGER.info("BookInfoController:: createBook!!!!input :" + libId);

		User lib = userRepository.findById(libId).get();
		if (lib == null) {
			throw new NoSuchElementException("Librarian not found with this Id:" + libId);
		} else {
			bookInfo.setCreatedBy(lib);
			bookInfo.setCreatedOn(new Date());

			LOGGER.info("BookInfoController:: createBook!!!output :" + bookInfo);

			return new ResponseEntity<>(bookInfoService.createBook(bookInfo), HttpStatus.CREATED);

		}

	}

	// SearchBook By BookId

	@GetMapping("/search/{bookId}")
	public ResponseEntity<BookInfo> searchByBookId(@PathVariable Long bookId) {

		
		BookInfo book = bookInfoService.searchByBookId(bookId);

		if (book == null) {

			LOGGER.error("BookInfoController:: searchByBookId!!!! ResourceNotFoundException:");
			throw new ResourceNotFoundException("book not found With Id:" + bookId);

		} else {

			LOGGER.info("BookInfoController:: searchByBookId!!!!output :" + book);
			return new ResponseEntity<>(book, HttpStatus.FOUND);
		}
	}
	
	/*
	 * // SearchBook By BookId
	 * 
	 * @GetMapping("/search/{bookId}") public ResponseEntity<?>
	 * searchByBookId(@PathVariable Long bookId) {
	 * 
	 * LOGGER.info("BookInfoController:: searchByBookId!!!!input :" + bookId);
	 * BookInfo book = bookInfoService.searchByBookId(bookId);
	 * 
	 * if (book == null) {
	 * 
	 * LOGGER.
	 * error("BookInfoController:: searchByBookId!!!! ResourceNotFoundException:");
	 * throw new ResourceNotFoundException("book not found With Id:" + bookId);
	 * 
	 * } else {
	 * 
	 * LOGGER.info("BookInfoController:: searchByBookId!!!!output :" + book); return
	 * new ResponseEntity<>(book, HttpStatus.FOUND); } }
	 */

	// SearchBook ByName

	@GetMapping("/search/bookName")
	public ResponseEntity<BookInfo> searchByBookName(@RequestParam String bookName) {

		return new ResponseEntity<>(bookInfoService.searchByBookName(bookName), HttpStatus.FOUND);
	}

	// SearchBook By BookPublication

	@GetMapping("/search/bookPublication")
	public ResponseEntity<BookInfo> searchByBookPublication(@RequestParam String bookPublication) {

		LOGGER.info("BookInfoController:: searchByBookPublication!!!!input :" + bookPublication);
		BookInfo book = bookInfoService.searchByBookPublication(bookPublication);

		if (book == null) {

			LOGGER.error("BookInfoController:: searchByBookPublication!!!! ResourceNotFoundException:");
			throw new ResourceNotFoundException("book not found With bookPublication:" + bookPublication);

		} else {
			LOGGER.info("BookInfoController:: searchByBookPublication!!!!output :" + book);
			return new ResponseEntity<>(book, HttpStatus.FOUND);
		}

	}

	// SearchBook ByAuthor

	@GetMapping("/search/author")
	public ResponseEntity<BookInfo> searchByAuthor(@RequestParam String author) {

		LOGGER.info("BookInfoController:: searchByAuthor!!!!input :" + author);
		BookInfo book = bookInfoService.searchByAuthor(author);

		if (book == null) {

			LOGGER.error("BookInfoController:: searchByAuthor!!!! ResourceNotFoundException:");
			throw new ResourceNotFoundException("book not found With author:" + author);
		} else {

			LOGGER.info("BookInfoController:: searchByAuthor!!!!output :" + book);
			return new ResponseEntity<>(book, HttpStatus.FOUND);
		}
	}

	// update Book Book

	@PutMapping("/update/{libId}")
	public ResponseEntity<BookInfo> updateBook(@PathVariable Long libId, @RequestBody BookInfo bookInfo) {

		LOGGER.info("BookInfoController:: updateBook!!!!input :" + libId);

		User lib = userRepository.findById(libId).get();
		if (lib == null) {
			throw new NoSuchElementException("User not found With Id:" + libId);
		} else {
			bookInfo.setModifiedBy(lib);
			bookInfo.setModifiedOn(new Date());
			BookInfo book = bookInfoService.updateBook(bookInfo);

			LOGGER.info("BookInfoController:: updateBook!!!!output :" + book);
			return new ResponseEntity<>(book, HttpStatus.OK);
		}

	}

	// get all books

	@GetMapping("/search/all")
	public ResponseEntity<List<BookInfo> > searchAllBooks() {

		LOGGER.info("BookInfoController:: searchAllBooks!!!!input :");
		List<BookInfo> books = bookInfoService.searchAllBooks();

		if (books.isEmpty()) {

			LOGGER.error("BookInfoController:: searchAllBooks!!!! ResourceNotFoundException:");
			throw new ResourceNotFoundException("Books list is empty:");
		} else {

			LOGGER.info("BookInfoController:: searchAllBooks!!!!output :" + books);
			return new ResponseEntity<>(books, HttpStatus.FOUND);
		}
	}

	// delete Book

	@DeleteMapping("/delete/{bookId}")
	public ResponseEntity<?> deleteByBookId(@PathVariable Long bookId) {

		LOGGER.info("BookInfoController:: deleteByBookId!!!!input :" + bookId);
		return new ResponseEntity<>(bookInfoService.deleteByBookId(bookId), HttpStatus.OK);
	}
}