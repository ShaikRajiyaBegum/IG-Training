package com.hcl.testingrepository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.hcl.model.User;
import com.hcl.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;

	User user;
	List<User> users;

	@BeforeEach
	public void initData() {
		user = User.builder().userName("rajiya").userAge(26L).userEmailId("rajiya430@gmail.com").userGender("Female")
				.userMobileNo("1234567890").userAddress("Hyd").userType("user").build();
	}

	@DisplayName("Junit test for add user")
	@Test
	public void testAddUser() {
		User savedUser = userRepository.save(user);
		assertThat(savedUser).isNotNull();
		assertThat(savedUser.getUserId()).isGreaterThan(0);
	}

	@DisplayName("Junit Test for get getAllUsers")
	@Test
	public void testGetAllUsers() {
		User user1 = User.builder().userName("rajiya1").userAge(26L).userEmailId("rajiya430@gmail.com")
				.userGender("Female").userMobileNo("1234567890").userAddress("Hyd").userType("user").build();

		users = new ArrayList<>();
		users.add(user1);
	//	users.add(user);
		//userRepository.saveAll(users);
		List<User> userList = userRepository.findAll();
		assertThat(userList).isNotNull();
		assertThat(userList.size()).isGreaterThan(0);
		//assertThat(userList.size()).isEqualTo(1);
	}

	@DisplayName("Junit test for get getByUserId")
	@Test
	public void testGetByUserId() {
		userRepository.save(user);
		User savedUser = userRepository.findById(user.getUserId()).get();
		assertThat(savedUser).isNotNull();
	}

	@DisplayName("Junit test for update user")
	@Test
	public void testUpdateUser() {
		userRepository.save(user);
		User savedUser = userRepository.findById(user.getUserId()).get();
		savedUser.setUserName("naushik");
		savedUser.setUserGender("male");
		User updatedUser = userRepository.save(savedUser);
		assertThat(updatedUser.getUserName()).isEqualTo("naushik");
		assertThat(updatedUser.getUserGender()).isEqualTo("male");
	}

}
