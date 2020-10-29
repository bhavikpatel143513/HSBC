package com.facebookweb.service;

import java.util.ArrayList;
import com.facebookweb.dao.DAO;
import com.facebookweb.dao.DAOInterface;
import com.facebookweb.entity.FacebookProfile;

public class Service implements ServiceInterface {
	
	private DAOInterface dao = DAO.createObject();
	
	private Service() {}
	
	public static ServiceInterface createObject() {
		return new Service();
	}

	public int createProfile(FacebookProfile fp) {
		return dao.createProfile(fp);
	}

	public FacebookProfile viewProfile(FacebookProfile fp) {
		return null;
	}

	public ArrayList<FacebookProfile> searchProfile(FacebookProfile fp) {
		return null;
	}

	public ArrayList<FacebookProfile> viewAllProfile() {
		return dao.viewAllProfile();
	}

	public int deleteProfile(FacebookProfile fp) {
		return 0;
	}

	public int editProfile(FacebookProfile fp) {
		return 0;
	}

	public FacebookProfile loginProfile(FacebookProfile newProfile) {
		return dao.loginProfile(newProfile);
	}

}
