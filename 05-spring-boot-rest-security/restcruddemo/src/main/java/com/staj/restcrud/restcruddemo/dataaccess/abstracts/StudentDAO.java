package com.staj.restcrud.restcruddemo.dataaccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.staj.restcrud.restcruddemo.entity.Student;

@RepositoryRestResource(path="students")
public interface StudentDAO extends JpaRepository<Student, Integer>{

}
