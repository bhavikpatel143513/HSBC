package com.facebook.dao;

import java.util.ArrayList;

import com.facebook.entity.FacebookProfile;

public interface FacebookDAOInterface {
	
	public int createProfile(FacebookProfile fp);

	public FacebookProfile viewProfile(FacebookProfile fp);
	
	public ArrayList<FacebookProfile> viewAllProfile();

	public ArrayList<FacebookProfile> searchProfile(FacebookProfile fp);

	public int deleteProfile(FacebookProfile fp);

	public int editProfile(FacebookProfile fp);
	

}
