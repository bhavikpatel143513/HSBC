package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookProfile;
import com.facebookweb.service.Service;
import com.facebookweb.service.ServiceInterface;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		FacebookProfile newProfile = new FacebookProfile(name, email, password);
		
		int status = Service.createObject().createProfile(newProfile);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(status>0) {
			//OK
			out.println("<html><body>");
			out.println("Hello " + name + ", you have successfully registered! <a href=login.html>Login</a>");
			out.println("</body></html>");
		}else {
			//Error
			out.println("<html><body>");
			out.println("Registration unsuccessful! Please try again...<a href=registration.html>Register</a>");
			out.println("</body></html>");
		}
	}

	

}
