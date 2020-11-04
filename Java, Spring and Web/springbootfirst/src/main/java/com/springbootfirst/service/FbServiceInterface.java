package com.springbootfirst.service;

import java.util.ArrayList;

import com.springbootfirst.entity.FbProfile;

public interface FbServiceInterface {

	public int createProfile(FbProfile fp);

	public ArrayList<FbProfile> viewAllProfile();

	public int deleteProfile(FbProfile fp);

	public int editProfile(FbProfile fp);

}
