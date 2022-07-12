
package com.hcl.testingcontroller;

import static org.assertj.core.api.Assertions.assertThat;

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
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.hcl.controller.BookInfoController;
import com.hcl.model.BookInfo;
import com.hcl.serviceimpl.BookInfoServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = { BookInfoControllerTest.class })
@TestMethodOrder(OrderAnnotation.class)
class BookInfoControllerTest {

	@InjectMocks
	BookInfoController BookInfoController;

	@Mock
	BookInfoServiceImpl bookInfoService;

	/*
	 * @Mock BookInfoRepository bookInfoRepository;
	 */
	private BookInfo book;

	@BeforeEach
	public void initData() {
		book = new BookInfo().builder().bookId(1L).bookName("java").author("narayana")
				.bookPublication("sam Publications").activeFlag(1).build();

	}

	// Test Create Book
	@DisplayName("test_CreateBook")
	@Test
	@Order(1)
	public void testCreateBook() {
		Mockito.when(bookInfoService.createBook(book)).thenReturn(book);
		ResponseEntity<?> savedbook = BookInfoController.createBook(book.getBookId(), book);
		assertThat(savedbook.getStatusCodeValue()).isEqualTo(201);

	}

	@AfterEach
	public void endData() {
		book = null;
	}
}
