package com.springbootfirst.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.springbootfirst.entity.FbProfile;

@Repository
public class FbDAO implements FbDAOInterface{

	@Override
	public int createProfile(FbProfile fp) {
		int status = 0;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			PreparedStatement ps = con.prepareStatement("INSERT INTO facebookuser VALUES(?,?,?)");
			ps.setString(1, fp.getName());
			ps.setString(2, fp.getPassword());
			ps.setString(3, fp.getEmail());
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	

	@Override
	public int deleteProfile(FbProfile fp) {
		int status = 0;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			PreparedStatement ps = con.prepareStatement("DELETE FROM facebookuser WHERE email=? and password=?");
			ps.setString(1, fp.getEmail());
			ps.setString(2, fp.getPassword());
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	@Override
	public int editProfile(FbProfile fp) {
		int status = 0;
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			PreparedStatement ps = con.prepareStatement("UPDATE facebookuser SET name=? WHERE email=? and password=?");
			ps.setString(1, fp.getName());
			ps.setString(3, fp.getPassword());
			ps.setString(2, fp.getEmail());
			
			status = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public ArrayList<FbProfile> viewAllProfile() {
		ArrayList<FbProfile> fbProfileList = new ArrayList<FbProfile>();
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			Connection con = DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM facebookuser");
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				fbProfileList.add(new FbProfile(result.getString("NAME"), result.getString("EMAIL"), result.getString("PASSWORD")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fbProfileList;
	}


	


	
	
	

}
