package com.facebook.dao;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.facebook.entity.FacebookProfile;

public class FacebookDAO implements FacebookDAOInterface {
	
	private FacebookDAO(){}
	
	public static FacebookDAOInterface createObject() {
		return new FacebookDAO();
	}

	public int createProfile(FacebookProfile fp) {
		int i = 0;
		Connection con = null;
		
		try {
			//step 1: load driver
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			//step 2: connection with database
			//Connection con=DriverManager.getConnection("jdbc:derby:C:\\firstdb1;create=true;user=bhavik;password=bhavik");
			con=DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			
			//step 3: create query
			PreparedStatement ps = con.prepareStatement("insert into facebookuser values(?,?,?)");
			ps.setString(1, fp.getName());
			ps.setString(2, fp.getPassword());
			ps.setString(3, fp.getEmail());

			//step 4: execute query
			i = ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return i;

	}

	public FacebookProfile viewProfile(FacebookProfile fp){
		boolean hasRows = false;
		Connection con = null;
		
		try {
			//step 1: load driver
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			//step 2: connection with database
			//Connection con=DriverManager.getConnection("jdbc:derby:C:\\firstdb1;create=true;user=bhavik;password=bhavik");
			con=DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			
			//step 3: create query
			PreparedStatement ps = con.prepareStatement("select * from facebookuser where email=?");
			ps.setString(1, fp.getEmail());

			//step 4: execute query
			ResultSet resultSet = ps.executeQuery();
			
			while (resultSet.next()) {
				hasRows = true;
				String name = resultSet.getString("NAME");
	            String email = resultSet.getString("EMAIL");
	            String password = resultSet.getString("PASSWORD");

	            fp.setName(name);
	            fp.setEmail(email);
	            fp.setPassword(password);
	        }
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(hasRows)return fp;
		return null;
		
	}

	public ArrayList<FacebookProfile> viewAllProfile(){
		
		ArrayList<FacebookProfile> fpList = new ArrayList<FacebookProfile>();
		Connection con = null;
		
		try {
			
			//step 1: load driver
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			//step 2: connection with database
			//Connection con=DriverManager.getConnection("jdbc:derby:C:\\firstdb1;create=true;user=bhavik;password=bhavik");
			con=DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			
			//step 3: create query
			PreparedStatement ps = con.prepareStatement("select * from facebookuser");
		
			//step 4: execute query
			ResultSet resultSet = ps.executeQuery();
			
			
			while (resultSet.next()) {

				FacebookProfile fp = new FacebookProfile();
				String name = resultSet.getString("NAME");
	            String email = resultSet.getString("EMAIL");
	            String password = resultSet.getString("PASSWORD");

	            fp.setName(name);
	            fp.setEmail(email);
	            fp.setPassword(password);
	            
	            fpList.add(fp);
	        }
			
		}catch(Exception e) {
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

	public int deleteProfile(FacebookProfile fp) {
		int i = 0;
		Connection con = null;
		
		try {
			
			//step 1: load driver
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			//step 2: connection with database
			//Connection con=DriverManager.getConnection("jdbc:derby:C:\\firstdb1;create=true;user=bhavik;password=bhavik");
			con=DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			
			//step 3: create query
			PreparedStatement ps = con.prepareStatement("delete from facebookuser where email=?");
			ps.setString(1, fp.getEmail());

			//step 4: execute query
			i = ps.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		
		return i;
	}

	public int editProfile(FacebookProfile fp) {
		int i = 0;
		Connection con = null;
		
		try {
			//step 1: load driver
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			//step 2: connection with database
			//Connection con=DriverManager.getConnection("jdbc:derby:C:\\firstdb1;create=true;user=bhavik;password=bhavik");
			con=DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			
			//step 3: create query
			PreparedStatement ps = con.prepareStatement("update facebookuser set name=?, password=? where email=?");
			ps.setString(1, fp.getName());
			ps.setString(2, fp.getPassword());
			ps.setString(3, fp.getEmail());

			//step 4: execute query
			i = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return i;
	}

	public ArrayList<FacebookProfile> searchProfile(FacebookProfile fp){
		ArrayList<FacebookProfile> fpList = new ArrayList<FacebookProfile>();
		Connection con = null;
		
		try {
			//step 1: load driver
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			//step 2: connection with database
			//Connection con=DriverManager.getConnection("jdbc:derby:C:\\firstdb1;create=true;user=bhavik;password=bhavik");
			con=DriverManager.getConnection("jdbc:derby:C:\\Users\\bhavi\\Downloads\\Root\\Coding\\Derby\\first\\firstdb1;create=true;user=bhavik;password=bhavik");
			
			//step 3: create query
			PreparedStatement ps = con.prepareStatement("select * from facebookuser where name=?");
			ps.setString(1, fp.getName());
		
			//step 4: execute query
			ResultSet resultSet = ps.executeQuery();
			
			
			while (resultSet.next()) {

				fp = new FacebookProfile();
				String name = resultSet.getString("NAME");
	            String email = resultSet.getString("EMAIL");

	            fp.setName(name);
	            fp.setEmail(email);
	            
	            fpList.add(fp);
	        }
		}catch(Exception e) {
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

}
