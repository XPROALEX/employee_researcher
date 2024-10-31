package com.advancia.employee_researcher.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.advancia.employee_researcher.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

}
