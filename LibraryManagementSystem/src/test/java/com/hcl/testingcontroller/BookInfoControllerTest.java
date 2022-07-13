
package com.hcl.testingcontroller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hcl.controller.BookInfoController;
import com.hcl.model.BookInfo;
import com.hcl.serviceimpl.BookInfoServiceImpl;

@ComponentScan(basePackages = "com.hcl")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes = { BookInfoControllerTest.class })
@TestMethodOrder(OrderAnnotation.class)
class BookInfoControllerTest {

	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	BookInfoController bookInfoController;

	@Mock
	BookInfoServiceImpl bookInfoService;

	private BookInfo book;

	List<BookInfo> books;

	@BeforeEach
	public void initData() {
		mockMvc = MockMvcBuilders.standaloneSetup(bookInfoController).build();
	}

	// createBook
	@DisplayName("test_CreateBook")
	@Test
	@Order(1)
	public void test_CreateBook() throws Exception {

		book = new BookInfo().builder().bookId(1L).bookName("materials").bookPublication("sanaya").build();

		when(bookInfoService.createBook(book)).thenReturn(book);

		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(book);

		this.mockMvc.perform(post("/create/{libId}").content(jsonbody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andDo(print());

	}

	// updateBook
	@DisplayName("test_UpdateBook")
	@Test
	@Order(2)
	public void test_UpdateBook() throws Exception {

		book = new BookInfo().builder().bookId(2L).bookName("materials").bookPublication("sanaya").build();
		Long libId = 1L;

		when(bookInfoService.searchByBookId(libId)).thenReturn(book);
		when(bookInfoService.updateBook(book)).thenReturn(book);

		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(book);

		this.mockMvc.perform(put("/update/{libId}", libId).content(jsonbody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print());

	}

	// SearchBook By BookId
	@DisplayName("testSearchByBookId")
	@Test
	@Order(3)
	public void testSearchByBookId() throws Exception {
		book = new BookInfo().builder().bookId(1L).bookName("materials").bookPublication("sanaya").build();
		Long bookId = 1L;

		when(bookInfoService.searchByBookId(bookId)).thenReturn(book);

		this.mockMvc.perform(get("/search/{bookId}", bookId)).andExpect(status().isFound())
				.andExpect(MockMvcResultMatchers.jsonPath(".bookId").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath(".bookName").value("materials"))
				.andExpect(MockMvcResultMatchers.jsonPath(".bookPublication").value("sanaya")).andDo(print());

	}

	// SearchBook By BookPublication
	@DisplayName("test_SearchByBookPublication")
	@Test
	@Order(4)
	public void testSearchByBookPublication() throws Exception {
		book = new BookInfo().builder().bookId(1L).bookName("materials").bookPublication("sanaya").build();
		String bookPublication = "sanaya";

		when(bookInfoService.searchByBookName(bookPublication)).thenReturn(book);

		this.mockMvc.perform(get("/search/bookPublication").param("bookPublication", "sanaya"))
				.andExpect(status().isFound()).andExpect(MockMvcResultMatchers.jsonPath(".bookId").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath(".bookName").value("materials"))
				.andExpect(MockMvcResultMatchers.jsonPath(".bookPublication").value("sanaya")).andDo(print());

	}

	// SearchBook By BookName
	@DisplayName("test_SearchByBookName")
	@Test
	@Order(5)
	public void testSearchByBookName() throws Exception {
		book = new BookInfo().builder().bookId(1L).bookName("materials").bookPublication("sanaya").build();
		String bookName = "materials";

		when(bookInfoService.searchByBookName(bookName)).thenReturn(book);

		this.mockMvc.perform(get("/search/bookName").param("bookName", "materials")).andExpect(status().isFound())
				.andExpect(MockMvcResultMatchers.jsonPath(".bookId").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath(".bookName").value("materials"))
				.andExpect(MockMvcResultMatchers.jsonPath(".bookPublication").value("sanaya")).andDo(print());

	}

	// SearchBook By BookAuthor
	@DisplayName("test_searchByAuthor")
	@Test
	@Order(6)
	public void testSearchByAuthor() throws Exception {
		book = new BookInfo().builder().bookId(1L).bookName("materials").bookPublication("sanaya").author("narayana")
				.build();
		String author = "narayana";

		when(bookInfoService.searchByAuthor(author)).thenReturn(book);

		this.mockMvc.perform(get("/search/author").param("author", "narayana")).andExpect(status().isFound())
				.andExpect(MockMvcResultMatchers.jsonPath(".bookId").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath(".bookName").value("materials"))
				.andExpect(MockMvcResultMatchers.jsonPath(".bookPublication").value("sanaya"))
				.andExpect(MockMvcResultMatchers.jsonPath(".author").value("narayana")).andDo(print());

	}

	// get all books
	@DisplayName("test_SearchAllBooks")
	@Test
	@Order(7)
	public void testSearchAllBooks() throws Exception {
		book = new BookInfo().builder().bookName("materials").bookPublication("sanaya").build();

		books = new ArrayList<>();
		books.add(book);

		when(bookInfoService.searchAllBooks()).thenReturn(books);

		this.mockMvc.perform(get("/search/all")).andExpect(status().isFound()).andDo(print());

	}

	// delete By BookId
	@DisplayName("test_DeleteByBookId")
	@Test
	@Order(8)
	public void testDeleteByBookId() throws Exception {
		book = new BookInfo().builder().bookId(1L).bookName("materials").bookPublication("sanaya").build();
		Long bookId = 1L;

		when(bookInfoService.deleteByBookId(bookId)).thenReturn(book);

		this.mockMvc.perform(delete("/delete/{bookId}", bookId)).andExpect(status().isOk());

	}

	@AfterEach
	public void endData() {
		book = null;
	}
}
