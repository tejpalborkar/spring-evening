package com.assimilate.springmvc.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assimilate.springmvc.business.EmployeeService;
import com.assimilate.springmvc.business.EmployeeServiceImpl;
import com.assimilate.springmvc.model.Employee;

@Controller
public class LoginController {

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public ModelAndView doLogin(@RequestParam("userName") String userName, @RequestParam("password") String password) {
		ModelAndView modelAndView = new ModelAndView();
		EmployeeService empService = new EmployeeServiceImpl();
		Employee employee = empService.login(userName, password);
		if (employee == null) {

			modelAndView.addObject("errorMessahe", "Incorrect user name or password");

			modelAndView.setViewName("login");

		} else {
			List<Employee> employees = new ArrayList<>();
			employees.add(employee);
			modelAndView.addObject("employees", employees);
			modelAndView.setViewName("welcome");

		}

		return modelAndView;
	}
}
