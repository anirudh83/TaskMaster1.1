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

public class UserServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
		UserService userService = getUserServiceFromSpringContext();
		RequestDispatcher view =null;
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String mobileNumber = request.getParameter("mobileNumber");
		
		User user = populateUser(firstName, lastName,password,
				email, mobileNumber);
		
		userService.createUser(user);
		request.getSession().setAttribute("user", user); 
		view = request.getRequestDispatcher("/home.jsp");
		try {
			view.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private User populateUser(String firstName, String lastName,
			String password, String email, String mobileNumber) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setMobileNum(mobileNumber);
		return user;
	}

	private UserService getUserServiceFromSpringContext() {
		WebApplicationContext context =
				WebApplicationContextUtils.getRequiredWebApplicationContext(
				getServletContext());
				UserService userService = (UserService) context.getBean("userServiceByName");
		return userService;
	}
}
