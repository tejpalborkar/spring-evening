package com.xcaliber.foodstall.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.xcaliber.foodstall.model.Emp;
import com.xcaliber.foodstall.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/list-emp")
	public ModelAndView listEmployees() {

		ModelAndView modelAndView = new ModelAndView("viewemp");

		List<Emp> employeeList = employeeService.getAll();

		modelAndView.addObject("list", employeeList);

		return modelAndView;

	}



	@RequestMapping(value = "/create-empeloyee", method = RequestMethod.GET)
	public ModelAndView createEmpForm() {

		ModelAndView modelAndView = new ModelAndView("create-employee");

		modelAndView.addObject("command", new Emp());

		return modelAndView;

	}



	@RequestMapping(value = "/create-employee", method = RequestMethod.POST)

	public String createEmployeeSubmit(Emp employee) {

		employeeService.createEmployee(employee);

		System.out.println("Employee saved successfully");

		return "redirect:/list-emp";

	}



}