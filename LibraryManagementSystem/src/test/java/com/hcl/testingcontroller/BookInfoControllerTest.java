
package com.hcl.testingcontroller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.controller.BookInfoController;
import com.hcl.model.BookInfo;
import com.hcl.serviceimpl.BookInfoServiceImpl;

@ComponentScan(basePackages = "com.hcl.testingcontroller")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes = { BookInfoControllerTest.class })
@TestMethodOrder(OrderAnnotation.class)
class BookInfoControllerTest {

	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	BookInfoController bookInfoController;

	@Mock
	BookInfoServiceImpl bookInfoService;

	BookInfo bookInfo;

	List<BookInfo> books;

	@BeforeEach
	public void initData() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookInfoController).build();
	}

	

	// Search book By bookId
	@DisplayName("test_SearchByBookId")
	@Test
	@Order(1)
	public void testSearchByBookId() throws Exception {
		bookInfo = BookInfo.builder().bookId(1L).bookName("materials").bookPublication("sanaya").build();
		Long bookId = 1L;

		when(bookInfoService.searchByBookId(bookId)).thenReturn(bookInfo);

		ResponseEntity<BookInfo> res = bookInfoController.searchByBookId(bookId);
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(bookId, res.getBody().getBookId());

	}

	// Search book By BookName
	@DisplayName("test_SearchByBookName")
	@Test
	@Order(2)
	public void testSearchByBookName() throws Exception {
		bookInfo = BookInfo.builder().bookId(1L).bookName("materials").bookPublication("sanaya").build();
		String bookName = "materials";

		when(bookInfoService.searchByBookName(bookName)).thenReturn(bookInfo);

		ResponseEntity<BookInfo> res = bookInfoController.searchByBookName(bookName);
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(bookName, res.getBody().getBookName());

	}

	// Search book By BookPublication
	@DisplayName("test_SearchByBookPublication")
	@Test
	@Order(3)
	public void testSearchByBookPublication() throws Exception {
		bookInfo = BookInfo.builder().bookId(1L).bookName("materials").bookPublication("sanaya").build();
		String bookPublication = "sanaya";

		when(bookInfoService.searchByBookPublication(bookPublication)).thenReturn(bookInfo);

		ResponseEntity<BookInfo> res = bookInfoController.searchByBookPublication(bookPublication);
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(bookPublication, res.getBody().getBookPublication());

	}

	// Search book By author
	@DisplayName("test_SearchByAuthor")
	@Test
	@Order(4)
	public void testSearchByAuthor() throws Exception {
		bookInfo = BookInfo.builder().bookId(1L).bookName("materials").author("Ram").bookPublication("sanaya").build();
		String author = "Ram";

		when(bookInfoService.searchByAuthor(author)).thenReturn(bookInfo);

		ResponseEntity<BookInfo> res = bookInfoController.searchByAuthor(author);
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(author, res.getBody().getAuthor());

	}

	// Search AllBooks
	@DisplayName("test_SearchAllBooks")
	@Test
	@Order(5)
	public void testSearchAllBooks() throws Exception {

		books = new ArrayList<BookInfo>();
		books.add(BookInfo.builder().bookId(1L).bookName("materials").author("Ram").bookPublication("sanaya").build());

		when(bookInfoService.searchAllBooks()).thenReturn(books);
		ResponseEntity<List<BookInfo>> res = bookInfoController.searchAllBooks();
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(1, res.getBody().size());

	}

	
}
