package com.assimilate.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {

	@RequestMapping(method = RequestMethod.GET, value = "/")
	public String index() {

		System.out.println("Executing index  method");
		return "index";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/helloWorld")
	public String helloWorld() {

		System.out.println("Executing hello world controller method");
		return "hello";
	}
}
