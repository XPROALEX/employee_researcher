package com.advancia.employee_researcher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advancia.employee_researcher.model.Region;

@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
