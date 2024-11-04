package com.advancia.employee_researcher.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.advancia.employee_researcher.model.Country;
import com.advancia.employee_researcher.model.Department;
import com.advancia.employee_researcher.model.Employee;
import com.advancia.employee_researcher.model.Location;
import com.advancia.employee_researcher.model.Region;

@Repository
public class CustomSearchRepository {
	@Autowired
	private EntityManager em;

	public List<Employee> getFilteredEmployee(String firstName, String lastName, Long departmentId, Long locationId,
			String countryId, Long regionId, int minSalary, int maxSalary) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

		// employee
		Root<Employee> root = criteriaQuery.from(Employee.class);

		// JOIN
		Join<Employee, Department> departmentJoin = root.join("department");
		Join<Department, Location> locationJoin = departmentJoin.join("location");
		Join<Location, Country> countryJoin = locationJoin.join("country");
		Join<Country, Region> regionJoin = countryJoin.join("region");

		Predicate predicate = criteriaBuilder.conjunction();

		if (firstName != null || !firstName.isBlank())
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%"));

		if (lastName != null || !lastName.isBlank())
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%"));

		if (departmentId != 0)
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.equal(departmentJoin.get("departmentId"), departmentId));

		if (locationId != 0)
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.equal(locationJoin.get("locationId"), locationId));

		if (countryId != null || !countryId.isBlank())
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(countryJoin.get("countryId"), countryId));

		if (locationId != 0)
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(regionJoin.get("regionId"), regionId));

		if (minSalary != 0)
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), minSalary));

		if (maxSalary != 0)
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.lessThanOrEqualTo(root.get("salary"), maxSalary));

		criteriaQuery.where(predicate);
		TypedQuery<Employee> query = em.createQuery(criteriaQuery);

		return query.getResultList();
	}
}
