package com.advancia.employee_researcher.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATIONS")
public class Location {

	@Id
	@Column(name = "LOCATION_ID")
	private Long locationId;

	@Column(name = "STREET_ADDRESS")
	private String streetAddress;

	@Column(name = "POSTAL_CODE")
	private String postalCode;

	@Column(name = "CITY")
	private String city;

	@Column(name = "STATE_PROVINCE")
	private String stateProvince;

	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name = "COUNTRY_ID")
	private Country country;

	@OneToMany(mappedBy = "location",fetch =FetchType.LAZY )
	private List<Department> departments;

	public Long getLocationId() {
		return locationId;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getCity() {
		return city;
	}

	public String getStateProvince() {
		return stateProvince;
	}

	public Country getCountry() {
		return country;
	}

	public List<Department> getDepartments() {
		return departments;
	}
	
	

}
