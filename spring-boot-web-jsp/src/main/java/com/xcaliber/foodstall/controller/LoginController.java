package com.xcaliber.foodstall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

	@ResponseBody
	@RequestMapping("/home")
	public String userWelcome() {
		return "welcome user";
	}

	@RequestMapping("/login")
	public String userLogin() {
		return "login";
	}

	@RequestMapping("/register")
	public String userRegistration() {
		return "register";
	}

	@PostMapping("/login")
	public String login() {
		return "menu";
	}
}
