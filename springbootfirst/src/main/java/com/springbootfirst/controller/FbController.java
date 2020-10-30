package com.springbootfirst.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootfirst.entity.Employee;

@RestController
public class FbController {
	
	@RequestMapping("hello")
	public String hello() {
		return "Hello there! Welcome to Spring Boot";
	}
	
	@RequestMapping("empList")
	public ArrayList<Employee> empList(){
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Bhavik", "bhavik@gmail.com", "pass@bhavik"));
		empList.add(new Employee("Naman", "naman@gmail.com", "pass@naman"));
		return empList;
	}
	

}
