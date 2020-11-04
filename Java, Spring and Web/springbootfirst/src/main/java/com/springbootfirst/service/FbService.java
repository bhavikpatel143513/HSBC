package com.springbootfirst.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootfirst.dao.FbDAOInterface;
import com.springbootfirst.entity.FbProfile;

@Service
public class FbService implements FbServiceInterface{
	
	@Autowired
	private FbDAOInterface fbDAO;

	@Override
	public int createProfile(FbProfile fp) {
		return fbDAO.createProfile(fp);
	}
	
	@Override
	public int deleteProfile(FbProfile fp) {
		return fbDAO.deleteProfile(fp);
	}

	@Override
	public ArrayList<FbProfile> viewAllProfile() {
		return fbDAO.viewAllProfile();
	}

	@Override
	public int editProfile(FbProfile fp) {
		return fbDAO.editProfile(fp);
	}

	


}
