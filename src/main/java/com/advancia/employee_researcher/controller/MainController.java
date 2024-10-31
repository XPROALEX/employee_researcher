package com.advancia.employee_researcher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.advancia.employee_researcher.service.CountryService;
import com.advancia.employee_researcher.service.DepartmentService;
import com.advancia.employee_researcher.service.EmployeeService;
import com.advancia.employee_researcher.service.LocationService;
import com.advancia.employee_researcher.service.RegionService;

@Controller
public class MainController {
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private CountryService countryService;

	@Autowired
	private RegionService regionService;

	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("allEmpist", employeeService.getAllEmployees());
		model.addAttribute("allDepList", departmentService.getAlldepartments());
		model.addAttribute("allLocList", locationService.getAllLocations());
		model.addAttribute("allCounList", countryService.getAllCountries());
		model.addAttribute("allRegList", regionService.getAllRegions());
		return "index";
	}
}
