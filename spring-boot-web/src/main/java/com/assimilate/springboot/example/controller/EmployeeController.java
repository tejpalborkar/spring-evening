package com.assimilate.springboot.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.assimilate.springboot.example.model.Employee;
import com.assimilate.springboot.example.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/list-emp")
	public ModelAndView listEmployees() {
		ModelAndView modelAndView = new ModelAndView("viewemp");
		List<Employee> employeeList = employeeService.getAll();
		modelAndView.addObject("list", employeeList);
		return modelAndView;
	}

	@RequestMapping(value = "/create-employee", method = RequestMethod.GET)
	public ModelAndView createEmpForm() {
		ModelAndView modelAndView = new ModelAndView("create-employee");
		modelAndView.addObject("command", new Employee());
		return modelAndView;
	}

	@RequestMapping(value = "/create-employee", method = RequestMethod.POST)
	public String createEmployeeSubmit(Employee employee) {
		employeeService.createEmployee(employee);
		System.out.println("Employee saved successfully");
		return "redirect:/list-emp";
	}

	@RequestMapping(value = "/hello-world")
	public String helloWorld() {
		System.out.println("Executing hello world");
		return "helloworld";
	}
	
	

	@RequestMapping(value = "/editemp/{id}")
	public ModelAndView editEmp(@PathVariable("id") Integer employeeId) {
		ModelAndView modelAndView = new ModelAndView("empeditform");

		Employee employee = employeeService.findEmployeeById(employeeId);
		modelAndView.addObject("command", employee);

		return modelAndView;
	}

//	deleteemp/9

	@RequestMapping(value = "/deleteemp/{id}")
	public String deleteEmpployee(@PathVariable("id") Integer employeeId) {
		employeeService.deleteEmployeeById(employeeId);

		return "redirect:/list-emp";
	}
	
	
	@PostMapping(value = "/editsave")
	public String saveEmployee(Employee employee)  {
		ModelAndView modelAndView = new ModelAndView("editempform");

		employeeService.updateEmployee(employee);
		modelAndView.addObject("command", employee);

		return "redirect:/list-emp";
	}

	
}