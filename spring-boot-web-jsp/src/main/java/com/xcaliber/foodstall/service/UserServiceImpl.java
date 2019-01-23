package com.xcaliber.foodstall.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.xcaliber.foodstall.dao.UserDao;
import com.xcaliber.foodstall.dto.UserRegistrationDto;
import com.xcaliber.foodstall.model.User;
import com.xcaliber.foodstall.repository.UserRepository;


@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;

	@Override
	public String addUserInfo(UserRegistrationDto userRegistrationDto) {
		User user = new User();
		user.setFirstName(userRegistrationDto.getFirstName());
		user.setLastName(userRegistrationDto.getLastName());
		user.setEmail(userRegistrationDto.getEmail());
		user.setUserName(userRegistrationDto.getUserName());
		user.setPassword(userRegistrationDto.getPassword());

		userDao.save(user);
		return null;
	}

	@Override
	public void createUser(UserRegistrationDto userDto) {
		// userDao.save(userDto);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.findAll();
	}

	@Override
	public User findById(int eId) {
		return userDao.findOne(eId);
	}

	@Override
	public void update(User user, int id) {
		userDao.saveOrUpdate(user);
	}

	@Override
	public void deleteUserById(int id) {
		userDao.delete(findById(id));
	}
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUserName(username);
	}

}
