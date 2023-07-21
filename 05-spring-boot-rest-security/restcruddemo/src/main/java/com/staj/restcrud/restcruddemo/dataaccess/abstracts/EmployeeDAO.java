package com.staj.restcrud.restcruddemo.dataaccess.abstracts;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.staj.restcrud.restcruddemo.entity.Employee;

@Service
public interface EmployeeDAO extends JpaRepository<Employee, Integer>{
	
}
