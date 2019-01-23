package com.xcaliber.foodstall.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xcaliber.foodstall.auth.service.SecurityService;
import com.xcaliber.foodstall.model.Category;
import com.xcaliber.foodstall.model.Menu;
import com.xcaliber.foodstall.model.User;
import com.xcaliber.foodstall.service.CategoryService;
import com.xcaliber.foodstall.service.UserService;
import com.xcaliber.foodstall.validator.UserValidator;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	
	@Autowired
	private SecurityService securityService;

	@Autowired
	private UserValidator userValidator;

	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registration(Model model) {
		model.addAttribute("userForm", new User());

		return "registration";
	}

	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		securityService.autologin(userForm.getUserName(), userForm.getPasswordConfirm());

		return "redirect:/welcome";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, String error, String logout) {
		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@RequestMapping(value = { "/", "/welcome" }, method = RequestMethod.GET)
	public ModelAndView welcome(Model model) {
		ModelAndView mv = new ModelAndView("welcome");
		Menu menu = new Menu();
		List<String> itemList = new ArrayList();
		mv.addObject("menuForm", menu);
		itemList.addAll(categoryService.findAll().stream().map(s -> s.getCategoryName()).collect(Collectors.toList()));
		mv.addObject("itemList", itemList);
		return mv;
	}
}
