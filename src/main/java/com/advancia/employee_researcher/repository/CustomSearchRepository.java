package com.advancia.employee_researcher.repository;

import java.util.ArrayList;
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
import com.advancia.employee_researcher.model.SearchDTO;

@Repository
public class CustomSearchRepository {
	@Autowired
	private EntityManager em;

	public List<Employee> getFilteredEmployee2(SearchDTO search) {

		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

		List<Predicate> predicates = new ArrayList<Predicate>();

		// employee
		Root<Employee> root = criteriaQuery.from(Employee.class);

		// JOIN
		Join<Employee, Department> departmentJoin = root.join("department");
		Join<Department, Location> locationJoin = departmentJoin.join("location");
		Join<Location, Country> countryJoin = locationJoin.join("country");
		Join<Country, Region> regionJoin = countryJoin.join("region");

		// root first name (String) like
		if (search.getFirstName() != null && !search.getFirstName().isBlank()) {

			Predicate firstNamePredicate = criteriaBuilder.like(root.get("firstName"),
					"%" + search.getFirstName() + "%");
			predicates.add(firstNamePredicate);
		}

		// root last name (string) like
		if (search.getLastName() != null && !search.getLastName().isBlank()) {

			Predicate lastNamePredicate = criteriaBuilder.like(root.get("lastName"), "%" + search.getLastName() + "%");
			predicates.add(lastNamePredicate);
		}

		// country (string) equal
		if (search.getCountryId() != null && !search.getCountryId().isBlank()) {

			Predicate countryPredicate = criteriaBuilder.equal(countryJoin.get("getCountryId"), search.getCountryId());
			predicates.add(countryPredicate);
		}

		// department (long) equal
		if (search.getDepartmentId() != 0) {

			Predicate departmentPredicate = criteriaBuilder.equal(departmentJoin.get("departmentId"),
					search.getDepartmentId());
			predicates.add(departmentPredicate);
		}

		// location (long) equal
		if (search.getLocationId() != 0) {

			Predicate locationPredicate = criteriaBuilder.equal(locationJoin.get("locationId"), search.getLocationId());
			predicates.add(locationPredicate);
		}

		// region (long) equal
		if (search.getRegionId() != 0) {

			Predicate regionPredicate = criteriaBuilder.equal(regionJoin.get("regionId"), search.getRegionId());
			predicates.add(regionPredicate);
		}

		// salary min (int) greater than or equal
		if (search.getMinSalary() != 0) {
			Predicate minSalaryPredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("salary"),
					search.getMinSalary());

			predicates.add(minSalaryPredicate);
		}

		// salary max (int) less than or equal
		if (search.getMinSalary() != 0) {
			Predicate maxSalaryPredicate = criteriaBuilder.lessThanOrEqualTo(root.get("salary"), search.getMaxSalary());

			predicates.add(maxSalaryPredicate);
		}

		criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));

		TypedQuery<Employee> query = em.createQuery(criteriaQuery);

		return query.getResultList();
	}

	public List<Employee> getFilteredEmployee(SearchDTO search) {
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

		List<Predicate> predicatesList = new ArrayList<Predicate>();

		if (search.getFirstName() != null && !search.getFirstName().isBlank())
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(
					criteriaBuilder.lower(root.get("firstName")), "%" + search.getFirstName().toLowerCase() + "%"));

		if (search.getLastName() != null && !search.getLastName().isBlank())
			predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")),
					"%" + search.getLastName().toLowerCase() + "%"));

		if (search.getDepartmentId() != 0)
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.equal(departmentJoin.get("departmentId"), search.getDepartmentId()));

		if (search.getLocationId() != 0)
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.equal(locationJoin.get("locationId"), search.getLocationId()));

		if (search.getCountryId() != null && !search.getCountryId().isBlank())
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.equal(countryJoin.get("countryId"), search.getCountryId()));

		if (search.getRegionId() != 0)
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.equal(regionJoin.get("regionId"), search.getRegionId()));

		if (search.getMinSalary() != 0)
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.greaterThanOrEqualTo(root.get("salary"), search.getMinSalary()));

		if (search.getMaxSalary() != 0)
			predicate = criteriaBuilder.and(predicate,
					criteriaBuilder.lessThanOrEqualTo(root.get("salary"), search.getMaxSalary()));

		criteriaQuery.where(predicate);
		TypedQuery<Employee> query = em.createQuery(criteriaQuery);

		return query.getResultList();
	}
}
