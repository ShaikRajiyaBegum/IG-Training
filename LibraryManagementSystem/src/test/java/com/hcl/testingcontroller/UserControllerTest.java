package com.hcl.testingcontroller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
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
	public void testAddUser() throws Exception {

		User user = User.builder().userId(1L).userEmailId("rajiya@gmail.com").userName("rajiya").build();

		when(userService.addUser(user)).thenReturn(user);

		ResponseEntity<User> res = userController.addUser(user);
		assertEquals(HttpStatus.CREATED, res.getStatusCode());
		assertEquals(user, res.getBody());

	}

	// update User
	@DisplayName("test_UpdateUser")
	@Test
	@Order(2)
	public void testUpdateUser() throws Exception {

		user = new User().builder().userId(1L).userEmailId("rajiya@gmail.com").userName("rajiya").build();

		when(userService.updateUser(user)).thenReturn(user);

		ResponseEntity<User> res = userController.updateUser(user);

		assertEquals(HttpStatus.OK, res.getStatusCode());
		assertEquals(user, res.getBody());

	}

	// Search user By userId
	@DisplayName("test_GetByUserId")
	@Test
	@Order(3)
	public void testGetByUserId() throws Exception {
		user = new User().builder().userId(1L).userEmailId("rajiya@gmail.com").userName("rajiya").build();
		Long userId = 1L;

		when(userService.getByUserId(userId)).thenReturn(user);

		ResponseEntity<User> res = userController.getByUserId(userId);
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(userId, res.getBody().getUserId());

	}

	// get all users
	@DisplayName("test_GetAllUsers")
	@Test
	@Order(4)
	public void testGetAllUsers() throws Exception {

		users = new ArrayList<User>();
		users.add(User.builder().userName("Ramesh").userAge(25L).userEmailId("ramesh@gmail.com").userGender("Male")
				.userMobileNo("9999999999").userAddress("Mumbai").userType("STU").userStatus("Active").build());

		when(userService.getAllUsers()).thenReturn(users);
		ResponseEntity<List<User>> res = userController.getAllUsers();
		assertEquals(HttpStatus.FOUND, res.getStatusCode());
		assertEquals(1, res.getBody().size());

	}

}
