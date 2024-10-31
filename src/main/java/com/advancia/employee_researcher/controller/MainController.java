package com.advancia.employee_researcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.advancia.employee_researcher.service.DepartmentService;
import com.advancia.employee_researcher.service.EmployeeService;

@Controller
public class MainController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allemplist", employeeService.getAllEmployees());
		return "index";
	}
}
