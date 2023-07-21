package com.staj.restdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/test")
public class DemoRestController {

	@GetMapping("/sayHello")
	String Hello() {
		return "Hello World!";
	}
}
