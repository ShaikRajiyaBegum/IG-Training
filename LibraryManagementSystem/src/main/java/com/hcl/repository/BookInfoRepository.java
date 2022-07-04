package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.model.BookInfo;

@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo, Long> {

}
