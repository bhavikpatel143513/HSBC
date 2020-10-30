package com.springbootfirst.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootfirst.entity.Employee;

@RestController
public class FbController {
	
	@GetMapping("hello")
	public String hello() {
		return "Hello there! Welcome to Spring Boot";
	}
	
	@GetMapping("empList")
	public ArrayList<Employee> empList(){
		ArrayList<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee("Bhavik", "bhavik@gmail.com", "pass@bhavik"));
		empList.add(new Employee("Naman", "naman@gmail.com", "pass@naman"));
		System.out.println(empList);
		return empList;
	}
	
	@PostMapping("hello")
	public String post() {
		return "@PostMapping there! Welcome to Spring Boot";
	}
	
	@PutMapping("hello")
	public String put() {
		return "@PutMapping there! Welcome to Spring Boot";
	}
	
	@DeleteMapping("hello")
	public String delete() {
		return "@DeleteMapping there! Welcome to Spring Boot";
	}
	
	
	

}
