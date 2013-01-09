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
			String emailAddress = request.getParameter("emailAddress");
			String password = request.getParameter("password");
			
			User persistedUser = userService.getUserByEmail(emailAddress);
			if(persistedUser!=null && persistedUser.getPassword().equals(password)){
				request.getSession().setAttribute("user", persistedUser); 
				view = request.getRequestDispatcher("task/home.jsp");
			}else{
				request.setAttribute("error", "Incorrect username or password, Please try again!");
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
				UserService userService = (UserService) context.getBean("userService");
		return userService;
	}
	
/**
 * Used for log out
 */

	
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		
			if(request.getSession().getAttribute("user")!=null){
				request.getSession().invalidate();
			}
		RequestDispatcher view = request.getRequestDispatcher("index.jsp");
		request.setAttribute("error", "Logged out successfully!");
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
}
