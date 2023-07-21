package com.staj.restcrud.restcruddemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="stundets")
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="a")
	private String a;
	
	@Column(name="b")
	private String b;
	
	@Column(name="c")
	private String c;

	public Student() {}
	
	public Student(String a, String b, String c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	





}

