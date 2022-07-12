package com.hcl.batch;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hcl.model.BookInfo;
import com.hcl.repository.BookInfoRepository;

@Component
public class DBWriter implements ItemWriter<BookInfo> {

	private BookInfoRepository bookInfoRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(DBWriter.class);

	@Autowired
	public DBWriter(BookInfoRepository bookInfoRepository) {
		this.bookInfoRepository = bookInfoRepository;
	}

	@Override
	public void write(List<? extends BookInfo> Books) throws Exception {

		LOGGER.info("DBWriter:: Data saved for Books!!!!input :" + Books);

		System.out.println("Data Saved for Books: " + Books);
		bookInfoRepository.saveAll(Books);
	}
}
