package com.facebookweb.service;

import java.util.ArrayList;

import com.facebookweb.entity.FacebookProfile;

public interface ServiceInterface {
	
	public int createProfile(FacebookProfile fp);
	public FacebookProfile viewProfile(FacebookProfile fp);
	public ArrayList<FacebookProfile> searchProfile(FacebookProfile fp);
	public ArrayList<FacebookProfile> viewAllProfile();
	public int deleteProfile(FacebookProfile fp);
	public int editProfile(FacebookProfile fp);
	public FacebookProfile loginProfile(FacebookProfile newProfile);

}
