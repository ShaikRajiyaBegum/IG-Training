package com.hcl.testingservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.model.BookInfo;
import com.hcl.model.BookIssue;
import com.hcl.model.User;
import com.hcl.repository.BookInfoRepository;
import com.hcl.repository.BookIssueRepository;
import com.hcl.repository.UserRepository;
import com.hcl.serviceimpl.BookIssueServiceImpl;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest(classes = { BookIIssueServiceTest.class })
@TestMethodOrder(OrderAnnotation.class)
class BookIIssueServiceTest {

	@Mock
	BookIssueRepository bookIssueRepository;

	@InjectMocks
	BookIssueServiceImpl bookIssueService;

	@Mock
	UserRepository userRepository;

	@Mock
	BookInfoRepository bookInfoRepository;

	private BookIssue bookIssue;

	

	

	@DisplayName("Junit test for test_GetAllIssues")
	@Test
	public void testGetAllIssues() {
		bookIssue = BookIssue.builder().bookIssuedDate(new Date()).bookPages(150L).status("requested").build();
		when(bookIssueRepository.findAll()).thenReturn(List.of(bookIssue, bookIssue));
		List<BookIssue> bookIssueList = bookIssueService.getAllIssues();
		assertThat(bookIssueList).isNotNull();
		assertThat(bookIssueList.size()).isGreaterThan(0);
	}

	@DisplayName("Junit test for test_GetIssueByStatus")
	@Test
	public void testGetIssueByStatus() {
		bookIssue = BookIssue.builder().bookIssuedDate(new Date()).bookPages(150L).status("requested").build();
		when(bookIssueRepository.findIssuesByStatus("requested")).thenReturn(List.of(bookIssue, bookIssue));
		List<BookIssue> bookIssueList = bookIssueService.getIssueByStatus("requested");
		assertThat(bookIssueList).isNotNull();
		assertThat(bookIssueList.size()).isGreaterThan(1);
	}
}
