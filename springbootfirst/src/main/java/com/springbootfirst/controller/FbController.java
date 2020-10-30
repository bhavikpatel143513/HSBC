package com.springbootfirst.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootfirst.entity.FbProfile;
import com.springbootfirst.service.FbServiceInterface;

@RestController
public class FbController {
	
	@Autowired
	private FbServiceInterface fbService;
	
	@PostMapping("createProfile")
	public String createProfile(@RequestBody FbProfile fp) {
		int status = fbService.createProfile(fp);
		if(status > 0) return "Successfully created profile!!";
		else return "Unsuccessful!! Please try again!!";
	}
	
	@PostMapping("deleteProfile")
	public String deleteProfile(@RequestBody FbProfile fp) {
		int status = fbService.deleteProfile(fp);
		if(status > 0) return "Successfully deleted profile!!";
		else return "Unsuccessful!! Please try again!!";
	}
	
	@PostMapping("editProfile")
	public String editProfile(@RequestBody FbProfile fp) {
		int status = fbService.editProfile(fp);
		if(status > 0) return "Successfully edited profile!!";
		else return "Unsuccessful, Invalid Email and password!! Please try again!!";
	}
	
	@PostMapping("viewAllProfile")
	public ArrayList<FbProfile> viewAllProfile() {
		ArrayList<FbProfile> list = fbService.viewAllProfile();
		if(list == null) {
			list = new ArrayList<FbProfile>();
			list.add(new FbProfile("NULL profile", null, null));
			return list;
		}
		else return list;
	}
	
	
	
	
	
	
	
	
	
	
	

}
