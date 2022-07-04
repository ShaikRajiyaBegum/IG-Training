package com.hcl.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.hcl.model.BookInfo;

@Component
public class Processor implements ItemProcessor<BookInfo, BookInfo> {

	private static final Map<String, String> book_Publications = new HashMap<>();

	public Processor() {
		book_Publications.put("aaaa", "java_aaaa");
		book_Publications.put("bbbb", "python_bbbb");
		book_Publications.put("cccc", "datascience_cccc");
		book_Publications.put("dddd", "embedded_dddd");
	}

	@Override
	public BookInfo process(BookInfo bookInfo) throws Exception {
		String book_PublicationsCode = bookInfo.getBook_Publication();
		String book_Publicationsvalue = book_Publications.get(book_PublicationsCode);
		bookInfo.setBook_Publication(book_Publicationsvalue);

		System.out.println(String.format("Converted from [%s] to [%s]", book_PublicationsCode, book_Publicationsvalue));
		return bookInfo;
	}
}
