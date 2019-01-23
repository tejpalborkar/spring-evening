package com.xcaliber.foodstall.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.xcaliber.foodstall.model.Item;
import com.xcaliber.foodstall.model.Menu;
import com.xcaliber.foodstall.service.ItemService;
import com.xcaliber.foodstall.views.CartForm;

@Controller
public class ApplicationController {

	@Autowired
	ItemService itemService;


	@RequestMapping("/pizza")
	public String pizzaMenu() {
		return "pizza";
	}

	@RequestMapping("/snacks")
	public String snacksMenu() {
		return "snacks";
	}

	@RequestMapping("/drinks")
	public String drinksMenu() {
		return "drinks";
	}

	@RequestMapping("/cart")
	public String cartItem() {
		return "addCart";
	}

	@RequestMapping("/menu")
	public String mainMenu() {
		return "menu";
	}

	@RequestMapping("/success")
	public String success() {
		return "thanks";
	}
}
