package com.example.web;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.Task;
import com.example.model.User;
import com.example.service.TaskService;

public class TaskServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			
			TaskService taskService = getTaskServiceFromSpringContext();
			User user = (User) request.getSession().getAttribute("user");
			String name = request.getParameter("name");
			String date = request.getParameter("date");
			String description = request.getParameter("description");
			String personName = request.getParameter("personName");
			taskService.saveTask(name, description, date, personName,user);
			
			RequestDispatcher view = request.getRequestDispatcher("success.jsp");
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
//TODO : Change this
	private TaskService getTaskServiceFromSpringContext() {
		WebApplicationContext context =
				WebApplicationContextUtils.getRequiredWebApplicationContext(
				getServletContext());
				TaskService taskService = (TaskService) context.getBean("taskServicebyName");
		return taskService;
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
		try {
			String email = ((User)request.getSession().getAttribute("user")).getEmail();
			List<Task> tasks = 	getTaskServiceFromSpringContext().getAllTasks(email);
			request.setAttribute("tasks", tasks);
			RequestDispatcher view = request.getRequestDispatcher("viewTasks.jsp");
			view.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	

}
