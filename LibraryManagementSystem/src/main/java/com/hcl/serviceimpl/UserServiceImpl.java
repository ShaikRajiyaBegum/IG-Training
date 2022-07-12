
package com.hcl.serviceimpl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.exception.APIException;
import com.hcl.model.User;
import com.hcl.repository.UserRepository;
import com.hcl.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User addUser(User user) {

		Optional<User> existedUser = userRepository.findByUserEmailId(user.getUserEmailId());
		if (existedUser.isPresent()) {

			LOGGER.error("UserServiceImpl:: addUser!!! APIException :");
			throw new APIException("User is already present with the given email......:" + user.getUserEmailId());

		} else {
			return userRepository.save(user);
		}

	}

	@Override
	public List<User> getAllUsers() {

		List<User> users = userRepository.findAll();

		if (users.isEmpty()) {

			LOGGER.error("UserServiceImpl:: getAllUsers!!! APIException :");
			throw new APIException("Users list is empty......:");

		} else {

			return users;
		}

	}

	@Override
	public User getByUserId(Long userId) {

		User user = userRepository.findById(userId).get();
		if (user == null) {
			LOGGER.error("UserServiceImpl:: getByUserId!!! NoSuchElementException :");
			throw new NoSuchElementException("User is not present with the given id......:" + user.getUserId());
		} else {
			return user;
		}

	}

	@Override
	public User updateUser(User user) {

		User existedUser = userRepository.findById(user.getUserId()).get();

		if (existedUser == null) {
			LOGGER.error("UserServiceImpl:: updateUser!!! NoSuchElementException :");
			throw new NoSuchElementException("User is not present with the given id......:" + user.getUserId());
		} else {
			existedUser.setUserName(user.getUserName());
			existedUser.setUserAge(user.getUserAge());
			existedUser.setUserGender(user.getUserGender());
			existedUser.setUserEmailId(user.getUserEmailId());
			existedUser.setUserAddress(user.getUserAddress());
			existedUser.setUserType(user.getUserType());
			existedUser.setUserMobileNo(user.getUserMobileNo());

			User updatedUser = userRepository.save(existedUser);
			return updatedUser;
		}

	}

	@Override
	public void deleteUser(Long userId) {
		User user = userRepository.findById(userId).get();
		if (user == null) {
			LOGGER.error("UserServiceImpl:: deleteUser!!! NoSuchElementException :");
			throw new NoSuchElementException("User is not found with the given id......:" + user.getUserId());
		} else {
			user.setUserStatus("inactive");
			userRepository.save(user);
		}

	}
}
