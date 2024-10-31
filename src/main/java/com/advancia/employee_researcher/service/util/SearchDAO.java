package com.advancia.employee_researcher.service.util;

public class SearchDAO {

	private String name;
	private String departmentId;
	private String locationId;
	private String countryId;
	private String regionId;
	private int minSalary;
	private int maxSalary;

	public SearchDAO() {
		super();
	}

	public SearchDAO(String name, String departmentId, String locationId, String countryId, String regionId,
			int minSalary, int maxSalary) {
		super();
		this.name = name;
		this.departmentId = departmentId;
		this.locationId = locationId;
		this.countryId = countryId;
		this.regionId = regionId;
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
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
