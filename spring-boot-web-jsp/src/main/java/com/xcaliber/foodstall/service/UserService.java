package com.xcaliber.foodstall.service;

import java.util.List;

import com.xcaliber.foodstall.dto.UserRegistrationDto;
import com.xcaliber.foodstall.model.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);

	public List<User> getAllUser();

	public User findById(int id);

	public void update(User user, int id);

	public void deleteUserById(int id);

	public String addUserInfo(UserRegistrationDto userRegistrationDto);

	void createUser(UserRegistrationDto userDto);

}
