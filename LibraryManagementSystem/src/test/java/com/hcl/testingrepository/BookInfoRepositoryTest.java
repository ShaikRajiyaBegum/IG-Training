package com.hcl.testingrepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hcl.model.BookInfo;
import com.hcl.repository.BookInfoRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookInfoRepositoryTest {

	@Autowired
	BookInfoRepository bookInfoRepository;

	BookInfo book;
	List<BookInfo> books;

	@BeforeEach
	public void initData() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();
	}


	//Test to to create book
	@DisplayName("test_CreateBook")
	@Test
	public void testCreateBook() {
		BookInfo savedBook = bookInfoRepository.save(book);
		assertThat(savedBook).isNotNull();
		assertThat(savedBook.getBookId()).isGreaterThan(0);
	}


	//Test to get all Books
	@DisplayName("test_SearchAllBooks")
	@Test
	public void testSearchAllBooks() {

		books = new ArrayList<>();
		books.add(book);
		List<BookInfo> booksList = bookInfoRepository.findAll();
		assertThat(booksList).isNotNull();
		assertThat(booksList.size()).isGreaterThan(0);

	}
	// Test to get Book by bookName

	@DisplayName("test_SearchByBookName")
	@Test
	public void testSearchByBookName() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();
		bookInfoRepository.save(book);
		BookInfo bookByName = bookInfoRepository.findByBookName("java");
		assertThat(bookByName).isNotNull();

	}
	// Test to get Book by bookPublication

	@DisplayName("test_SearchByBookPublication")
	@Test
	public void testSearchByBookPublication() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();

		assertEquals(book, bookInfoRepository.findByBookPublication("sam publications"));

	}

	// Test to get Book by Author

	@DisplayName("test_SearchByAuthor")
	@Test
	public void testSearchByAuthor() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();
		BookInfo bookByAuthor = bookInfoRepository.findByAuthor(book.getAuthor());
		assertNotNull(bookByAuthor);
		assertThat(bookByAuthor.getAuthor()).isEqualTo("narayana");

	}

	// Test for getting book by bookId

	@DisplayName("test_SearchByBookId")
	@Test
	public void testSearchByBookId() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();
		assertThat(bookInfoRepository.findById(book.getBookId())).isNotNull();

	}


	// Test to update book
	@DisplayName("test_UpdateBook")
	@Test
	public void testUpdateBook() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();
		BookInfo savedBook = bookInfoRepository.findById(book.getBookId()).get();
		savedBook.setBookName("aaaa");

		BookInfo updatedBook = bookInfoRepository.save(savedBook);
		assertNotEquals(savedBook, updatedBook);
	}
}
