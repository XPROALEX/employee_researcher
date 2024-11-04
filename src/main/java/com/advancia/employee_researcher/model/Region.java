package com.advancia.employee_researcher.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "REGIONS")
public class Region {
	
	@Id
	@Column(name = "REGION_ID")
	private Long regionId;

	@Column(name = "REGION_NAME")
	private String regionName;

	@OneToMany(mappedBy = "region",fetch =FetchType.LAZY )
	private List<Country> countries;

	public Long getRegionId() {
		return regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public List<Country> getCountries() {
		return countries;
	}
	
	

}
