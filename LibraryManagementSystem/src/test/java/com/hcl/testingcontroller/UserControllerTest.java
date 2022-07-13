package com.hcl.testingcontroller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
import com.hcl.controller.UserController;
import com.hcl.model.User;
import com.hcl.serviceimpl.UserServiceImpl;

@ComponentScan(basePackages = "com.hcl.testingcontroller")
@AutoConfigureMockMvc
@ContextConfiguration
@SpringBootTest(classes = { UserControllerTest.class })
@TestMethodOrder(OrderAnnotation.class)
public class UserControllerTest {

	@Autowired
	MockMvc mockMvc;

	@InjectMocks
	UserController userController;

	@Mock
	UserServiceImpl userService;

	User user;
	List<User> users;

	@BeforeEach
	public void initData() {
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
	}

	// add User
	@SuppressWarnings("static-access")
	@DisplayName("test_AddUser")
	@Test
	@Order(1)
	
	public void test_AddUser() throws Exception {

		user = new User().builder().userId(1L).userEmailId("rajiya@gmail.com").userName("rajiya").build();

		when(userService.addUser(user)).thenReturn(user);

		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(user);

		this.mockMvc.perform(post("/add").content(jsonbody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated()).andDo(print());

	}

	// updateBook
	@DisplayName("test_UpdateUser")
	@Test
	@Order(2)
	@Disabled
	public void test_UpdateUser() throws Exception {

		user = new User().builder().userId(1L).userEmailId("rajiya@gmail.com").userName("rajiya").build();
		Long userId = 1L;

		when(userService.getByUserId(userId)).thenReturn(user);
		when(userService.updateUser(user)).thenReturn(user);

		ObjectMapper mapper = new ObjectMapper();
		String jsonbody = mapper.writeValueAsString(user);

		this.mockMvc.perform(put("/get/{userId}", userId).content(jsonbody).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andDo(print());

	}

	// Search user By userId
	@DisplayName("test_GetByUserId")
	@Test
	@Order(3)
	@Disabled
	public void testGetByUserId() throws Exception {
		user = new User().builder().userId(1L).userEmailId("rajiya@gmail.com").userName("rajiya").build();
		Long userId = 1L;

		when(userService.getByUserId(userId)).thenReturn(user);

		this.mockMvc.perform(get("/get/{userId}", userId)).andExpect(status().isFound())
				.andExpect(MockMvcResultMatchers.jsonPath(".userId").value(1L))
				.andExpect(MockMvcResultMatchers.jsonPath(".userEmailId").value("rajiya@gmail.com"))
				.andExpect(MockMvcResultMatchers.jsonPath(".userName").value("rajiya")).andDo(print());

	}

	// get all users
	@DisplayName("test_GetAllUsers")
	@Test
	@Order(7)
	public void testGetAllUsers() throws Exception {

		users = new ArrayList<>();
		users.add(User.builder().userName("Ramesh").userAge(25L).userEmailId("ramesh@gmail.com").userGender("Male")
				.userMobileNo("9999999999").userAddress("Mumbai").userType("STU").userStatus("Active").build());

		// users.add(user);

		when(userService.getAllUsers()).thenReturn(users);

		this.mockMvc.perform(get("/getAllUsers")).andExpect(status().isOk()).andDo(print());

	}

}
