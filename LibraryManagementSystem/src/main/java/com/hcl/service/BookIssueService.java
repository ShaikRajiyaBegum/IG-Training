
package com.hcl.service;

import java.util.List;

import com.hcl.model.BookIssue;

public interface BookIssueService {

	BookIssue createBookIssue(Long userId, Long bookId, Long libId, BookIssue bookIssue);

	List<BookIssue> getAllIssues();

	List<BookIssue> getIssueByStatus(String status);
}