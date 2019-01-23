package com.xcaliber.foodstall.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xcaliber.foodstall.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUserName(String username);
}
