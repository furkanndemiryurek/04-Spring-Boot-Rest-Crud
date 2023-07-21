package com.staj.restcrud.restcruddemo.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.staj.restcrud.restcruddemo.business.abstracts.EmployeeService;
import com.staj.restcrud.restcruddemo.dataaccess.abstracts.EmployeeDAO;
import com.staj.restcrud.restcruddemo.entity.Employee;

import jakarta.transaction.Transactional;

@Service
public class EmployeeManager implements EmployeeService{

	EmployeeDAO employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDAO employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Override
	public List<Employee> findAll() {
		List<Employee> emp;
		emp = employeeDao.findAll();
		return emp;
	}

	@Override
	public Employee findById(Integer id) {
		Employee theEmployee = employeeDao.findById(id).get();
		if(theEmployee == null)
		{
			throw new RuntimeException("Employee id is not found : " + theEmployee.getId());
		}
		return theEmployee;
	}
	
	@Override
	@Transactional
	public Employee addEmployee(Employee employee) {
		employee.setId(0);
		employeeDao.save(employee);
		return employee;
	}

	@Override
	@Transactional
	public String deleteById(Integer id) {
		Employee theEmployee = employeeDao.findById(id).get();
		employeeDao.delete(theEmployee);
		return "Employee deleted : "+ theEmployee.getId();
	}

	@Override
	@Transactional
	public Employee updateEmployee(Employee employee) {
		employeeDao.save(employee);
		return employee;
	}




}
