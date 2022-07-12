
package com.hcl.serviceimpl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.BookInfo;
import com.hcl.model.BookIssue;
import com.hcl.model.User;
import com.hcl.repository.BookInfoRepository;
import com.hcl.repository.BookIssueRepository;
import com.hcl.repository.UserRepository;
import com.hcl.service.BookIssueService;

@Service
public class BookIssueServiceImpl implements BookIssueService {

	@Autowired
	private BookIssueRepository bookIssueRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookInfoRepository bookInfoRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(BookIssueServiceImpl.class);

	@Override
	public BookIssue createBookIssue(Long userId, Long libId, Long bookId, BookIssue bookIssue) {

		LOGGER.info("BookIssueServiceImpl:: createBookIsuue!!!!input :" + bookIssue);

		User user = userRepository.findById(userId).get();
		BookInfo book = bookInfoRepository.findById(bookId).get();
		User lib = userRepository.findById(libId).get();

		bookIssue.setIssuedBy(lib);
		bookIssue.setIssuedTo(user);
		bookIssue.setBookId(book);
		bookIssue.setBookIssuedDate(new Date());
		bookIssue.setStatus("requested");
		bookIssue.setBookPages(bookIssue.getBookPages());
		bookIssue.setCreatedOn(bookIssue.getCreatedOn());
		bookIssue.setModifiedOn(bookIssue.getModifiedOn());
		bookIssue.setNoOfCopies(bookIssue.getNoOfCopies());

		LOGGER.info("BookIssueServiceImpl:: createBookIsuue!!!!output :" + bookIssue);
		return bookIssueRepository.save(bookIssue);
	}

	@Override
	public List<BookIssue> getAllIssues() {
		LOGGER.info("BookIssueServiceImpl:: getAllIssues!!!!input :");
		List<BookIssue> existedIssues = bookIssueRepository.findAll();
		LOGGER.info("BookIssueServiceImpl:: createBookIsuue!!!!output :" + existedIssues);
		return existedIssues;
	}

	@Override
	public List<BookIssue> getIssueByStatus(String status) {
		LOGGER.info("BookIssueServiceImpl:: getIssueByStatus!!!!input :" + status);
		List<BookIssue> existedIssues = bookIssueRepository.findIssuesByStatus(status);
		LOGGER.info("BookIssueServiceImpl:: getIssueByStatus!!!!output :" + existedIssues);
		return existedIssues;
	}

}
