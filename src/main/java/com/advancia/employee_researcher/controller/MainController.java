package com.advancia.employee_researcher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.advancia.employee_researcher.model.Employee;
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


		model.addAttribute("allDepList", departmentService.getAlldepartments());
		model.addAttribute("allLocList", locationService.getAllLocations());
		model.addAttribute("allCounList", countryService.getAllCountries());
		model.addAttribute("allRegList", regionService.getAllRegions());
		return "index";
	}

	@PostMapping("/search")
	public String postMethodName(@RequestParam(required = false, value = "firstName") String firstName,
			@RequestParam(required = false, value = "lastName") String lastName,
			@RequestParam(required = false, value = "departmentId") Long departmentId,
			@RequestParam(required = false, value = "locationId") Long locationId,
			@RequestParam(required = false, value = "countryId") String countryId,
			@RequestParam(required = false, value = "regionId") Long regionId,
			@RequestParam(required = false, value = "minSalary") int minSalary,
			@RequestParam(required = false, value = "maxSalary") int maxSalary, Model model) {

		List<Employee> emp = employeeService.getFilteredEmployee(firstName, lastName, departmentId, locationId,
				countryId, regionId,minSalary , maxSalary );

		//List<Employee>emp= employeeService.getAllEmployees();
		
		model.addAttribute("employeeList", emp);

		return "index";
	}

}
