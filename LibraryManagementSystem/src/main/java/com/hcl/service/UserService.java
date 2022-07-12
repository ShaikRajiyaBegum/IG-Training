package com.hcl.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hcl.model.User;

@Service
public interface UserService {

	public User addUser(User user);

	public List<User> getAllUsers();

	public User getByUserId(Long userId);

	public User updateUser(User user);

	public void deleteUser(Long userId);
}
