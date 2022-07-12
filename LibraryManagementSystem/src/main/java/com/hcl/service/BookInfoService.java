
package com.hcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.model.BookInfo;

@Service
public interface BookInfoService {

	BookInfo createBook(BookInfo bookInfo);

	BookInfo updateBook(BookInfo book);

	BookInfo searchByBookId(Long bookId);

	BookInfo searchByBookName(String bookName);

	BookInfo searchByBookPublication(String bookPublication);

	BookInfo searchByAuthor(String author);

	List<BookInfo> searchAllBooks();

	BookInfo deleteByBookId(Long bookId);
}
