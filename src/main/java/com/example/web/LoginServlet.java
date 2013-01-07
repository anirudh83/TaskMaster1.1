package com.example.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.User;
import com.example.service.UserService;

public class LoginServlet extends HttpServlet {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			
			UserService userService = getUserServiceFromSpringContext();
			RequestDispatcher view =null;
			String name = request.getParameter("username");
			String password = request.getParameter("password");
			
			User persistedUser = userService.getUserByName(name);
			if(persistedUser.getPassword().equals(password)){
				view = request.getRequestDispatcher("home.jsp");
			}else{
				view = request.getRequestDispatcher("index.jsp");
			}
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//TODO : Change this
	private UserService getUserServiceFromSpringContext() {
		WebApplicationContext context =
				WebApplicationContextUtils.getRequiredWebApplicationContext(
				getServletContext());
				UserService userService = (UserService) context.getBean("userServiceByName");
		return userService;
	}
	

}
