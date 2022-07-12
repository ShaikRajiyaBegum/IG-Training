package com.hcl.testingrepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hcl.model.BookIssue;
import com.hcl.repository.BookIssueRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookIssueRepositoryTest {

	@Autowired
	BookIssueRepository bookIssueRepository;

	BookIssue bookIssue;

	@BeforeEach
	public void setupBookIssue() {
		bookIssue = BookIssue.builder().bookIssuedDate(new Date()).bookPages(150L).status("requested").build();
	}

	@DisplayName("Junit test for test_createBookIssue")
	@Test
	public void testcreateBookIssue() {
		bookIssue = BookIssue.builder().bookIssuedDate(new Date()).bookPages(150L).status("requested").build();
		BookIssue savedBookIssue = bookIssueRepository.save(bookIssue);
		assertThat(savedBookIssue).isNotNull();
		assertThat(savedBookIssue.getTransactionId()).isGreaterThan(0);
	}

	@DisplayName("Junit test for testGetAllIssues")
	@Test
	public void testGetAllIssues() {
		bookIssue = BookIssue.builder().bookIssuedDate(new Date()).bookPages(150L).status("requested").build();

		bookIssueRepository.save(bookIssue);
		List<BookIssue> bookIssueList = new ArrayList<>();
		bookIssueList.add(bookIssue);
		List<BookIssue> bookIssueList1 = bookIssueRepository.findAll();
		assertThat(bookIssueList1).isNotNull();
		assertThat(bookIssueList1.size()).isGreaterThan(0);
	}

	@DisplayName("Junit test for test_GetIssueByStatus")
	@Test
	public void testGetIssueByStatus(String status) {
		bookIssue = BookIssue.builder().bookIssuedDate(new Date()).bookPages(150L).status("requested").build();
		List<BookIssue> existedIssues = new ArrayList<>();
		existedIssues = bookIssueRepository.findIssuesByStatus(status);

		assertThat(existedIssues).isNotNull();
		assertThat(existedIssues.size()).isEqualTo(23);
	}

}
