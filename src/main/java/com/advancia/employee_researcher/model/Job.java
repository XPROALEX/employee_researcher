package com.advancia.employee_researcher.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JOBS")
public class Job {

	@Id
	@Column(name = "JOB_ID")
	private String jobId;
	
	@Column(name = "JOB_TITLE")
	private String jobTitle;
	
	@Column(name = "MIN_SALARY")
	private int minSalary;
	
	@Column(name = "MAX_SALARY")
	private int maxSalary;
	
	@OneToMany(mappedBy = "jobId")
	private List<Employee> employees;

	public String getJobId() {
		return jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public List<Employee> getEmployees() {
		return employees;
	}
	
}
