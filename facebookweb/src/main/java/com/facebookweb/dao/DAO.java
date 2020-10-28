package com.facebookweb.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.facebookweb.entity.FacebookProfile;

public class DAO implements DAOInterface{
	
	private DAO() {}
	
	public static DAOInterface createObject() {
		return new DAO();
	}

	public int createProfile(FacebookProfile fp) {
		Connection con = null;
		int status = 0;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			PreparedStatement ps = con.prepareStatement("INSERT INTO facebookuser values(?,?,?)");
			ps.setString(1, fp.getName());
			ps.setString(2, fp.getPassword());
			ps.setString(3, fp.getEmail());			
			status = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}

	public FacebookProfile viewProfile(FacebookProfile fp) {
		return null;
	}
	
	public static void main(String[] args) {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			System.out.println("FOUND!!!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<FacebookProfile> viewAllProfile() {
		ArrayList<FacebookProfile> fpList = new ArrayList<FacebookProfile>();
		Connection con = null;
		
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			con = DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM facebookuser");
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {

				String name = resultSet.getString("NAME");
			    String email = resultSet.getString("EMAIL");
			    String password = resultSet.getString("PASSWORD");       
			    fpList.add(new FacebookProfile(name,email,password));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return fpList;
	}

	public ArrayList<FacebookProfile> searchProfile(FacebookProfile fp) {
		return null;
	}

	public int deleteProfile(FacebookProfile fp) {
		return 0;
	}

	public int editProfile(FacebookProfile fp) {
		return 0;
	}

}
