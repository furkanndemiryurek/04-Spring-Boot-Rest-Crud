package com.staj.restcrud.restcruddemo.business.abstracts;

import java.util.List;

import com.staj.restcrud.restcruddemo.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	
	Employee findById(Integer id);

	Employee addEmployee(Employee employee);
	
	Employee updateEmployee(Employee employee);
	
	String deleteById(Integer id);
	
}
