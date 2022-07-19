
package com.hcl.testingcontroller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
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

import com.hcl.controller.BookIssueController;
import com.hcl.model.BookInfo;
import com.hcl.model.BookIssue;
import com.hcl.model.User;
import com.hcl.repository.BookInfoRepository;
import com.hcl.repository.UserRepository;
import com.hcl.serviceimpl.BookIssueServiceImpl;

@ComponentScan(basePackages = "com.hcl.testingcontroller")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes = { BookIssueControllerTest.class })
@TestMethodOrder(OrderAnnotation.class)
class BookIssueControllerTest {

	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	BookIssueController bookIssueController;

	@Mock
	BookIssueServiceImpl bookIssueService;

	@Mock
	UserRepository userRepository;

	@Mock
	BookInfoRepository bookInfoRepository;

	BookIssue bookIssued;

	BookInfo bookInfo;

	List<BookIssue> booksIssues;

	User user;

	@BeforeEach
	public void initData() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookIssueController).build();
	}

	@Test
	public void testGetAllIssues() throws Exception {
		booksIssues = new ArrayList<BookIssue>();
		booksIssues.add(BookIssue.builder().build());

		when(bookIssueService.getAllIssues()).thenReturn(booksIssues);

		ResponseEntity<List<BookIssue>> res = bookIssueController.getAllIssues();
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(1, res.getBody().size());
	}

	

	@Test
	public void testCreateBookIsuue() throws Exception {

		bookIssued = BookIssue.builder().bookIssuedDate(new Date()).status("Approved").build();
		Long libId = 1L;
		Long userId = 1L;
		Long bookId = 1L;

		when(bookIssueService.createBookIssue(libId, userId, bookId, bookIssued)).thenReturn(bookIssued);

		ResponseEntity<BookIssue> res = bookIssueController.createBookIsuue(userId, libId, bookId, bookIssued);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(bookIssued, res.getBody());

	}

}
