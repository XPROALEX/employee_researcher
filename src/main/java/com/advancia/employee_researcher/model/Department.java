package com.advancia.employee_researcher.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENTS")
public class Department {
	@Id
	@Column(name = "DEPARTMENT_ID")
	private Long departmentId;

	@Column(name = "DEPARTMENT_NAME", length = 30, nullable = false)
	private String departmentName;

	@ManyToOne
	@JoinColumn(name = "MANAGER_ID")
	private Employee manager;

	@OneToMany(mappedBy = "department")
	private List<Employee> employees;

	public Long getDepartmentId() {
		return departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public Employee getManager() {
		return manager;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

}