
package com.hcl.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.exception.ResourceNotFoundException;
import com.hcl.model.BookInfo;
import com.hcl.repository.BookInfoRepository;
import com.hcl.service.BookInfoService;

@Service
public class BookInfoServiceImpl implements BookInfoService {

	@Autowired
	private BookInfoRepository bookInfoRepository;

	// Book creation
	@Override
	public BookInfo createBook(BookInfo bookInfo) {
		return bookInfoRepository.save(bookInfo);
	}

	// update book

	@Override
	public BookInfo updateBook(BookInfo book) {
		return bookInfoRepository.save(book);
	}

	// search Book By BookId

	@Override
	public BookInfo searchByBookId(Long bookId) {
		return bookInfoRepository.findById(bookId).get();

	}

	// search Book By Name

	@Override
	public BookInfo searchByBookName(String bookName) {
		BookInfo book = bookInfoRepository.findByBookName(bookName);
		return book;

	}

	// search Book by publication

	@Override
	public BookInfo searchByBookPublication(String bookPublication) {
		return bookInfoRepository.findByBookPublication(bookPublication);
	}

	// search Book by Author

	@Override
	public BookInfo searchByAuthor(String author) {
		return bookInfoRepository.findByAuthor(author);
	}

	// search all books

	@Override
	public List<BookInfo> searchAllBooks() {
		return bookInfoRepository.findAll();
	}

	@Override
	public BookInfo deleteByBookId(Long bookId) {
		
		BookInfo book1 = bookInfoRepository.findById(bookId).get();
		if (book1 == null) {
			throw new ResourceNotFoundException("Book not found With Id:" + bookId);
		} else {

			book1.setActiveFlag(0);
			return bookInfoRepository.save(book1);
		}

	}

}