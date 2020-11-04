package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookProfile;
import com.facebookweb.service.Service;

public class ViewAllServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Profiles<br>");
		ArrayList<FacebookProfile> profileList = Service.createObject().viewAllProfile();
		StringBuilder html = new StringBuilder();
		html.append("<html><body>");
		
		for(FacebookProfile profile: profileList) {
			html.append("<br>");
			html.append("<br>Name = " + profile.getName());
			html.append("<br>Email = " + profile.getEmail());
			html.append("<br>Password = " + profile.getPassword());
			html.append("<br>");
		}
		out.println(html.toString());
		
	}

}
