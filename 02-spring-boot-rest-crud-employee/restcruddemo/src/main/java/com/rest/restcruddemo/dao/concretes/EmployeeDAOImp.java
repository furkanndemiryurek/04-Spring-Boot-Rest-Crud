package com.rest.restcruddemo.dao.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rest.restcruddemo.dao.abstracts.EmployeeDAO;
import com.rest.restcruddemo.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


@Repository
public class EmployeeDAOImp implements EmployeeDAO{

	EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> query = entityManager.createQuery("FROM employee",Employee.class);
		List<Employee> employees = query.getResultList();
		return employees;
	}

}
