package com.hcl.batch;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.hcl.model.BookInfo;
import com.hcl.model.User;

@Component
public class Processor implements ItemProcessor<BookInfo, BookInfo> {

	private static final Logger LOGGER = LoggerFactory.getLogger(Processor.class);

	@Override
	public BookInfo process(BookInfo bookInfo) throws Exception {

		LOGGER.info("Processor:: Processing starts......::input" + bookInfo);

		bookInfo.setCreatedBy(User.builder().userId(1L).build());

		bookInfo.setActiveFlag(1);

		bookInfo.setCreatedOn(new Date());

		return bookInfo;
	}
}
