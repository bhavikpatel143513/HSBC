package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookProfile;
import com.facebookweb.service.Service;

public class DeleteServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		FacebookProfile fp = new FacebookProfile(null, email, password);
		
		int status = Service.createObject().deleteProfile(fp);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(status > 0) {
			//OK
			out.println("<html><body>");
			out.println("Your profile has been deleted successfully! Go to <a href=registration.html>Register</a> page.");
			out.println("</body></html>");
		}else {
			//Error
			out.println("<html><body>");
			out.println("Delete unsuccessful! Please try again...<a href=LoginServlet?email="+email+"&password="+password+">Home</a>");
			out.println("</body></html>");
		}
	}

}
