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
@Table(name = "COUNTRIES")
public class Country {
	@Id
	@Column(name = "COUNTRY_ID")
	private String countryId;

	@Column(name = "COUNTRY_NAME")
	private String countryName;

	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name = "REGION_ID")
	private Region region;

	@OneToMany(mappedBy = "country",fetch =FetchType.LAZY )
	private List<Location> locations;

	public String getCountryId() {
		return countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public Region getRegion() {
		return region;
	}

	public List<Location> getLocations() {
		return locations;
	}

}
