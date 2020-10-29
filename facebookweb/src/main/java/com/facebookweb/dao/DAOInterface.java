package com.facebookweb.dao;

import java.util.ArrayList;

import com.facebookweb.entity.FacebookProfile;

public interface DAOInterface {
	
	public int createProfile(FacebookProfile fp);
	public FacebookProfile viewProfile(FacebookProfile fp);
	public ArrayList<FacebookProfile> viewAllProfile();
	public ArrayList<FacebookProfile> searchProfile(FacebookProfile fp);
	public int deleteProfile(FacebookProfile fp);
	public int editProfile(FacebookProfile fp);
	public FacebookProfile loginProfile(FacebookProfile fp);

}
