package com.xcaliber.foodstall.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.xcaliber.foodstall.model.User;
import com.xcaliber.foodstall.service.UserService;

@Component
public class UserUtil {

	@Autowired
	private UserService userService;

	public User getLoggedInUser() {
		User user = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			String username = ((UserDetails) principal).getUsername();
			user = userService.findByUsername(username);
		} else {
			String username = principal.toString();
			user = userService.findByUsername(username);
		}
		return user;
	}
}
