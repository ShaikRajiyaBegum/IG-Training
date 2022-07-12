
package com.hcl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.model.BookInfo;

//@Repository
public interface BookInfoRepository extends JpaRepository<BookInfo, Long> {

	BookInfo findByBookName(String bookName);

	BookInfo findByBookPublication(String bookPublication);

	BookInfo findByAuthor(String author);

}
