package com.advancia.employee_researcher.model;

public class SearchDTO {
	private String firstName;
	private String lastName;
	private Long departmentId;
	private Long locationId;
	private String countryId;
	private Long regionId;
	private int minSalary;
	private int maxSalary=100000;

	public SearchDTO() {
		super();
	}

	public SearchDTO(String firstName, String lastName, Long departmentId, Long locationId, String countryId,
			Long regionId, int minSalary, int maxSalary) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.departmentId = departmentId;
		this.locationId = locationId;
		this.countryId = countryId;
		this.regionId = regionId;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

	public int getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(int minSalary) {
		this.minSalary = minSalary;
	}

	public int getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(int maxSalary) {
		this.maxSalary = maxSalary;
	}

}
