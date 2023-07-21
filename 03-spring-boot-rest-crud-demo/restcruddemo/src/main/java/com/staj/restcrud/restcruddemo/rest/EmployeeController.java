package com.staj.restcrud.restcruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.staj.restcrud.restcruddemo.business.abstracts.EmployeeService;
import com.staj.restcrud.restcruddemo.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	EmployeeService manager;	
	
	@Autowired
	public EmployeeController(EmployeeService manager) {
		this.manager = manager;
	}
	
	
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return manager.findAll();
	}

	@GetMapping("/employee/{id}")
	public Employee getById(@PathVariable("id")int id) {
		return manager.findById(id);
	}
	
	@DeleteMapping("/employee/{employeeId}")
	public void deleteById(@PathVariable("employeeId")int id) {
		manager.deleteById(id);
	}
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		manager.addEmployee(theEmployee);
		return theEmployee;
	}
	
	@PutMapping("/employee")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		manager.updateEmployee(theEmployee);
		return theEmployee;
	}
	
	
	
	
	
	
}
