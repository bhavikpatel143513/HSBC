package com.facebook.service;

import java.util.ArrayList;

import com.facebook.dao.FacebookDAO;
import com.facebook.dao.FacebookDAOInterface;
import com.facebook.entity.FacebookProfile;

public class FacebookService implements FacebookServiceInterface {
	
	private FacebookDAOInterface fd = FacebookDAO.createObject();
	
	private FacebookService(){}
	
	public static FacebookServiceInterface createObject() {
		return new FacebookService();
	}

	public int createProfile(FacebookProfile fp)  {
		int response = fd.createProfile(fp);
		return response;		
	}

	public FacebookProfile viewProfile(FacebookProfile fp) {
		fp = fd.viewProfile(fp);
		return fp;
	}

	public ArrayList<FacebookProfile> viewAllProfile() {
		ArrayList<FacebookProfile> fpList = fd.viewAllProfile();
		return fpList;
	}

	public int deleteProfile(FacebookProfile fp)  {
		int response = fd.deleteProfile(fp);
		return response;	
	}

	public int editProfile(FacebookProfile fp){
		int response = fd.editProfile(fp);
		return response;
	}

	public ArrayList<FacebookProfile> searchProfile(FacebookProfile fp) {
		ArrayList<FacebookProfile> fpList = fd.searchProfile(fp);
		return fpList;
	}

	

}
