package com.staj.restcrud.restcruddemo.dataaccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;

import com.staj.restcrud.restcruddemo.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	
}
