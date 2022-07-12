package com.hcl.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.BookIssue;

@Repository
public interface BookIssueRepository extends JpaRepository<BookIssue, Long> {

	List<BookIssue> findIssuesByStatus(String Status);
}
