package com.facebookweb.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.facebookweb.entity.FacebookProfile;
import com.facebookweb.service.Service;


public class ViewServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		FacebookProfile fp = new FacebookProfile(null, email, password);
		
		fp = Service.createObject().viewProfile(fp);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		if(fp != null) {
			//OK
			out.println("<html><body>");
			out.println("Your profile data is here:");
			out.println("<br>");
			out.println("<br>Name = " + fp.getName());
			out.println("<br>Email = " + fp.getEmail());
			out.println("<br>Password = " + fp.getPassword());
			out.println("<br>");
			out.println("Go to <a href=LoginServlet?email="+email+"&password="+password+">Home</a>");
			out.println("</body></html>");
		}else {
			//Error
			out.println("<html><body>");
			out.println("View unsuccessful! Please try again...<a href=LoginServlet?email="+email+"&password="+password+">Home</a>");
			out.println("</body></html>");
		}
	}
	
    

}
