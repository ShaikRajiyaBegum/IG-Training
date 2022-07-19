package com.hcl.testingservice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.model.User;
import com.hcl.repository.UserRepository;
import com.hcl.serviceimpl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = { UserServiceTest.class })
@TestMethodOrder(OrderAnnotation.class)
public class UserServiceTest {

	@InjectMocks
	UserServiceImpl userService;

	@Mock
	UserRepository userRepository;

	User user;
	List<User> users;

	// Test addUser
	@DisplayName("test_AddUser")
	@Test
	@Order(1)
	public void testAddUser() {
		user = new User(1L, "Rajiya", 25L, "F", "Rajiya@gmail.com", "1234567890", "hyd", "lib", "active");
		when(userRepository.save(user)).thenReturn(user);

		assertEquals(user, userService.addUser(user));
	}

	// Test to getAllUsers

	@DisplayName("test_GetAllUsers")
	@Test
	@Order(2)
	public void testGetAllUsers() {

		List<User> users = new ArrayList<>();
		users.add(user);
		when(userRepository.findAll()).thenReturn(users);
		assertEquals(1, userService.getAllUsers().size());
	}

	// Test for getting user byId

	@DisplayName("test_GetByUserId ")
	@Test
	@Order(3)
	public void testGetByUserId() {
		User user1 = new User(2L, "Rajiya", 25L, "F", "Rajiya@gmail.com", "1234567890", "hyd", "lib", "active");

		Mockito.when(userRepository.findById(user1.getUserId())).thenReturn(Optional.of(user1));

		User userById = userService.getByUserId(user1.getUserId());
		assertThat(userById).isNotNull();
	}

	

	// Test to Update user

	@DisplayName("test_UpdateUser")
	@Test
	@Order(4)
	public void testUpdateUser() {
		user = new User(1L, "Rajiya", 25L, "F", "Rajiya@gmail.com", "1234567890", "hyd", "lib", "active");
		Mockito.when(userRepository.findById(user.getUserId())).thenReturn(Optional.of(user));

		user.setUserEmailId("gsdyt@gmail.com");
		Mockito.when(userRepository.save(user)).thenReturn(user);
		assertEquals(user, userService.updateUser(user));

	}

	

}
