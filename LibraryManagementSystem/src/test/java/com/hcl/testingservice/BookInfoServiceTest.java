package com.hcl.testingservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.model.BookInfo;
import com.hcl.repository.BookInfoRepository;
import com.hcl.serviceimpl.BookInfoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = { BookInfoServiceTest.class })
@TestMethodOrder(OrderAnnotation.class)
class BookInfoServiceTest {

	@InjectMocks
	BookInfoServiceImpl bookInfoService;

	@Mock
	BookInfoRepository bookInfoRepository;

	BookInfo book;
	List<BookInfo> books;

	@BeforeEach
	public void initData() {
		BookInfo book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();

	}

	// Test Create Book

	@DisplayName("test_CreateBook")
	@Test
	@Order(1)
	public void testCreateBook() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();
		when(bookInfoRepository.save(book)).thenReturn(book);

		assertEquals(book, bookInfoService.createBook(book));
	}

	// Test Update Book

	@DisplayName("test_UpdateBook")
	@Test
	@Order(2)
	public void testUpdateBook() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();

		book.setBookName("abc");
		when(bookInfoRepository.save(book)).thenReturn(book);
		BookInfo book2 = bookInfoService.updateBook(book);
		assertEquals(book, book2);

	}

	// Test to get Book by bookName

	@DisplayName("test_SearchByBookName")
	@Test
	@Order(3)
	public void testSearchByBookName() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();

		when(bookInfoRepository.findByBookName("abc")).thenReturn(book);

		assertEquals(book, bookInfoService.searchByBookName("abc"));

	}

	// Test to get Book by bookPublication

	@DisplayName("test_SearchByBookPublication")
	@Test
	@Order(4)
	public void testSearchByBookPublication() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();

		when(bookInfoRepository.findByBookPublication("sam publications")).thenReturn(book);
		assertEquals(book, bookInfoService.searchByBookPublication("sam publications"));

	}

	// Test to get Book by bookAuthor

	@DisplayName("test_SearchByAuthor")
	@Test
	@Order(5)
	public void testSearchByAuthor() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();

		when(bookInfoRepository.findByAuthor("narayana")).thenReturn(book);
		assertEquals(book, bookInfoService.searchByAuthor("narayana"));

	}

	// Test to getAllBooks

	@DisplayName("test_SearchAllBooks")
	@Test
	@Order(6)
	public void testSearchAllBooks() {
		books = new ArrayList<>();
		books.add(book);
		when(bookInfoRepository.findAll()).thenReturn(books);
		assertEquals(1, bookInfoService.searchAllBooks().size());
	}

	// Test for getting book by bookId

	@DisplayName("test_SearchByBookId")
	@Test
	@Order(7)
	public void testSearchByBookId() {
		book = BookInfo.builder().bookId(1L).bookName("java").author("narayana").bookPages(120L)
				.bookPublication(" sam publications").activeFlag(1).build();
		when(bookInfoRepository.findById(book.getBookId())).thenReturn(Optional.of(book));
		BookInfo bookById = bookInfoService.searchByBookId(1L);
		assertThat(bookById).isNotNull();

	}

	@AfterEach
	public void endData() {
		book = null;
	}

}
