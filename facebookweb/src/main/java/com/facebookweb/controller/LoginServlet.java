package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookProfile;
import com.facebookweb.service.Service;

public class LoginServlet extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		FacebookProfile newProfile = new FacebookProfile(null, email, password);
		
		FacebookProfile loggedProfile = Service.createObject().loginProfile(newProfile);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(loggedProfile != null) {
			//OK
			out.println("<html><body>");
			out.println("Welcome " + loggedProfile.getName() + ", you have successfully logged in...");
			out.println("</body></html>");
		}else {
			//Error
			out.println("<html><body>");
			out.println("Login unsuccessful! Please try again...<a href=login.html>Login</a>");
			out.println("</body></html>");
		}
	}

}
