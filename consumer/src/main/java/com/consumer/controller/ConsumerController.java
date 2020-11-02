package com.consumer.controller;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.consumer.entity.FbProfile;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ConsumerController {
	
	@RequestMapping("hello")
	public void hello() {
		System.out.println("hello");
	}
	
	@RequestMapping("consumeViewAllProfile")
	public void consumeViewAllProfile() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response=null;
		try{
		response=restTemplate.exchange("http://localhost:8080/viewAllProfile",HttpMethod.GET, getHttpEntity(),String.class);
		}catch (Exception ex)
		{
			System.out.println(ex);
		}
		System.out.println(response.getBody());
	}
	
	@PostMapping("consumeCreateProfile")
	public void consumeCreateProfile(@RequestBody FbProfile profile) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = null;
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    HttpEntity<FbProfile> entity = new HttpEntity<FbProfile>(profile,headers);
	    
		try {
			responseEntity = restTemplate.exchange("http://localhost:8080/createProfile", HttpMethod.POST , entity, String.class);
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(responseEntity.getBody());
		
	}
	
	@RequestMapping("consumeEditProfile")
	public void consumeEditProfile() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = null;
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    String name = "ccc";
	    String email = "cc@gmail.com";
	    String password = "pass@cc";
		HttpEntity<String> request = new HttpEntity<String>("{\"name\":\""+name+"\",\"email\":\""+email+"\",\"password\":\""+password+"\"}", headers);
		
		try {
			responseEntity = restTemplate.exchange("http://localhost:8080/editProfile", HttpMethod.PUT , request, String.class);
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(responseEntity.getBody());
	}
	
	@RequestMapping("consumeDeleteProfile")
	public void consumeDeleteProfile() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> responseEntity = null;
		
		HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    String name = "cc";
	    String email = "cc@gmail.com";
	    String password = "pass@cc";
		HttpEntity<String> request = new HttpEntity<String>("{\"name\":\""+name+"\",\"email\":\""+email+"\",\"password\":\""+password+"\"}", headers);
		
		try {
			responseEntity = restTemplate.exchange("http://localhost:8080/deleteProfile", HttpMethod.DELETE , request, String.class);
		}catch(Exception e) {
			System.out.println(e);
		}
		System.out.println(responseEntity.getBody());
	}
	private HttpEntity getHttpEntity() throws IOException {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		return new HttpEntity(headers);
	}

}
