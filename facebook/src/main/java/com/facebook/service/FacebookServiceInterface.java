package com.facebook.service;

import java.util.ArrayList;

import com.facebook.entity.FacebookProfile;

public interface FacebookServiceInterface {
	
	public int createProfile(FacebookProfile fp);

	public FacebookProfile viewProfile(FacebookProfile fp);

	public ArrayList<FacebookProfile> searchProfile(FacebookProfile fp);
	
	public ArrayList<FacebookProfile> viewAllProfile();

	public int deleteProfile(FacebookProfile fp);
	
	public int editProfile(FacebookProfile fp);

}
