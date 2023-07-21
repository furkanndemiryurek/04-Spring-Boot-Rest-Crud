package com.rest.restcruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.restcruddemo.dao.abstracts.EmployeeDAO;
import com.rest.restcruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	
	EmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeRestController(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}
	
}
