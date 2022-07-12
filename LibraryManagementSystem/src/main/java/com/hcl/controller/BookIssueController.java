package com.hcl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.BookIssue;
import com.hcl.service.BookIssueService;

@RestController
@RequestMapping(value = "/lms/BookIssue")
public class BookIssueController {

	@Autowired
	private BookIssueService bookIssueService;

	private static final Logger LOGGER = LoggerFactory.getLogger(BookIssueController.class);

	// create book issue
	@PostMapping("/create/{userId}/{libId}/{bookId}")
	public ResponseEntity<?> createBookIsuue(@PathVariable("userId") Long userId, @PathVariable("libId") Long libId,
			@PathVariable("bookId") Long bookId, @RequestBody BookIssue bookIssue) {

		LOGGER.info("BookIssueController:: createBookIsuue!!!!input :" + bookIssue);
		BookIssue bookIssued = bookIssueService.createBookIssue(userId, libId, bookId, bookIssue);

		LOGGER.info("UserController:: addUser!!!output :" + bookIssued);

		return new ResponseEntity<>(bookIssued, HttpStatus.CREATED);

	}

	// get all BookIssues

	@GetMapping("/getAllIssues")
	public ResponseEntity<?> getAllIssues() {
		LOGGER.info("BookIssueController:: getAllIssues!!!!input :");
		List<BookIssue> bookIssues = bookIssueService.getAllIssues();

		LOGGER.info("UserController:: getAllUsers!!!output :" + bookIssues);
		return new ResponseEntity<>(bookIssues, HttpStatus.FOUND);

	}

	// Get Transaction by status

	@GetMapping("/get/status")
	public ResponseEntity<?> getIssueByStatus(@RequestParam String status) {
		LOGGER.info("UserController:: updateUser!!!!input :" + status);
		List<BookIssue> bookIssues = bookIssueService.getIssueByStatus(status);

		LOGGER.info("UserController:: updateUser!!!output :" + bookIssues);
		return new ResponseEntity<>(bookIssues, HttpStatus.OK);

	}

}
