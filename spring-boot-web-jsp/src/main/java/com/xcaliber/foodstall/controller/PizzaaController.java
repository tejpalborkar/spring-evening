package com.xcaliber.foodstall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PizzaaController {
	
	@ResponseBody
	@RequestMapping("/add")
	public String cartAdd() {
		return "addCart";
	}

	@RequestMapping("/remove")
	public String removeItem() {
		return "menu";
	}

}
