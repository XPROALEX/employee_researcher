package com.advancia.employee_researcher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advancia.employee_researcher.repository.RegionRepository;

@Service
public class RegionService {

	@Autowired
	private RegionRepository regionRepository;

	public Object getAllRegions() {
		return regionRepository.findAll();
	}

}
