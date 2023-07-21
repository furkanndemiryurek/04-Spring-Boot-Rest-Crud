package com.rest.restcruddemo.dao.abstracts;

import java.util.List;

import com.rest.restcruddemo.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();
}
