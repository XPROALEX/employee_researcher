package com.advancia.employee_researcher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advancia.employee_researcher.model.Employee;
import com.advancia.employee_researcher.model.SearchDTO;
import com.advancia.employee_researcher.repository.CustomSearchRepository;
import com.advancia.employee_researcher.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private CustomSearchRepository customSearchRepository;

	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	public List<Employee> getFilteredEmployee(SearchDTO search) {
		return customSearchRepository.getFilteredEmployee(search);
	}

}
