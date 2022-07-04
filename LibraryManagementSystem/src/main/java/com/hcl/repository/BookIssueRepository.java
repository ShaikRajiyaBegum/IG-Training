package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.BookIssue;

@Repository
public interface BookIssueRepository extends JpaRepository<BookIssue, Long> {

}
