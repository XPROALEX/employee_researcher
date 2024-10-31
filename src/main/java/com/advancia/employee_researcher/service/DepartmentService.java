package com.advancia.employee_researcher.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advancia.employee_researcher.model.Department;
import com.advancia.employee_researcher.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	public List<Department> getAlldepartments() {
		return departmentRepository.findAll();
	}
}
