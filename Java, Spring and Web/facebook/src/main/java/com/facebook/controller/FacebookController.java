package com.facebook.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import com.facebook.entity.FacebookProfile;
import com.facebook.service.FacebookService;
import com.facebook.service.FacebookServiceInterface;

public class FacebookController implements FacebookControllerInterface {
	
	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private FacebookServiceInterface fs = FacebookService.createObject();
	
	private FacebookController(){}
	
	public static FacebookControllerInterface createObject() {
		return new FacebookController();
	}
	
	public void createProfile() {
		
		try {
			System.out.println("Enter Name:");
			String name = br.readLine();
			System.out.println("Enter Email");
			String email = br.readLine();
			System.out.println("Enter Password");
			String password = br.readLine();
			
			FacebookProfile fp = new FacebookProfile();
			fp.setName(name);
			fp.setEmail(email);
			fp.setPassword(password);
			
			
			int response = fs.createProfile(fp);
			if(response>0) System.out.println("Profile is created");
			else System.out.println("Profile could not be created");
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void viewProfile() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			System.out.println("Enter Email");
			String email = br.readLine();
			
			FacebookProfile fp = new FacebookProfile();
			fp.setEmail(email);
			
			fp = fs.viewProfile(fp);
			if(fp != null) {
				System.out.println("Name: " + fp.getName());
				System.out.println("Email: " + fp.getEmail());
				System.out.println("Password: " + fp.getPassword());
			}else {
				System.out.println("No Profile found!!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void deleteProfile() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			System.out.println("Enter Email");
			String email = br.readLine();
			
			FacebookProfile fp = new FacebookProfile();
			fp.setEmail(email);
			
			int response = fs.deleteProfile(fp);
			if(response>0) System.out.println("Profile is deleted");
			else {
				System.out.println("No Profile found to delete!!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void searchProfile(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			System.out.println("Enter Name");
			String name = br.readLine();
			
			FacebookProfile fp = new FacebookProfile();
			fp.setName(name);
			
			ArrayList<FacebookProfile> fpList = fs.searchProfile(fp);
			if(fpList.size()>0) {
				for(FacebookProfile profile: fpList) {
					System.out.println();
					System.out.println("Name: " + profile.getName());
					System.out.println("Email: " + profile.getEmail());
					System.out.println();
				}
			}else {
				System.out.println("No Profile Found!!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void viewAllProfile() {
		try {
			
			ArrayList<FacebookProfile> fpList = fs.viewAllProfile();
			if(fpList.size()>0) {
				for(FacebookProfile profile: fpList) {
					System.out.println();
					System.out.println("Name: " + profile.getName());
					System.out.println("Email: " + profile.getEmail());
					System.out.println("Password: " + profile.getPassword());
					System.out.println();
				}
			}else {
				System.out.println("Profile List is empty!!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	public void editProfile() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			
			System.out.println("Enter Email");
			String email = br.readLine();
			
			System.out.println("Enter new Name:");
			String name = br.readLine();
			
			System.out.println("Enter new Password");
			String password = br.readLine();
			
			FacebookProfile fp = new FacebookProfile();
			fp.setName(name);
			fp.setEmail(email);
			fp.setPassword(password);
			
			int response = fs.editProfile(fp);
			if(response>0) System.out.println("Profile is edited");
			else {
				System.out.println("No Profile found to edit!!");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

}
