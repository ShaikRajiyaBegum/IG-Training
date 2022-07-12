package com.hcl.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.model.User;
import com.hcl.service.UserService;

@RestController
@RequestMapping(value = "/lms/user")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	// add User
	@PostMapping("/add")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		LOGGER.info("UserController:: addUser!!!!input :" + user);
		User user1 = userService.addUser(user);

		LOGGER.info("UserController:: addUser!!!output :" + user1);
		return new ResponseEntity<>(user1, HttpStatus.CREATED);

	}

	// get all users
	@GetMapping("/getAllUsers")
	public ResponseEntity<?> getAllUsers() {
		LOGGER.info("UserController:: getAllUsers!!!!input :");
		List<User> users = userService.getAllUsers();

		LOGGER.info("UserController:: getAllUsers!!!output :" + users);
		return new ResponseEntity<>(users, HttpStatus.FOUND);

	}

	// get user by id
	@GetMapping("/get/{userId}")
	public ResponseEntity<?> getByUserId(@PathVariable Long userId) {
		LOGGER.info("UserController:: getUserByUserId!!!!input :" + userId);
		User user = userService.getByUserId(userId);

		LOGGER.info("UserController:: getUserByUserId!!!output :" + user);
		return new ResponseEntity<>(user, HttpStatus.FOUND);

	}

	// update user
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody User user) {
		LOGGER.info("UserController:: updateUser!!!!input :" + user);
		User user1 = userService.updateUser(user);

		LOGGER.info("UserController:: updateUser!!!output :" + user1);
		return new ResponseEntity<>(user1, HttpStatus.OK);

	}

	// delete user by id
	@DeleteMapping("/delete/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		LOGGER.info("UserController:: deleteUser!!!!input :" + userId);
		userService.deleteUser(userId);

	}
}
