package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.form.TaskForm;
import com.example.model.Task;
import com.example.service.TaskService;

/**
 * 
 * @author anirudh
 *
 */

@Controller
@RequestMapping("/task")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String viewTasks(@RequestParam("emailAddress") String email,
			Model model){
		//TODO: Change it to TaskForm
		List<Task> tasks = taskService.getAllTasks(email);
		model.addAttribute("tasks",tasks);
		return "viewTasks";
	
	}
	
	@RequestMapping(value="/showCreate",method=RequestMethod.GET)
	public String showCreateTask(Model model){
		TaskForm taskForm = new TaskForm();
		model.addAttribute("task",taskForm);
		return "createTask";
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String createTask(@ModelAttribute("task") TaskForm task,Model model){
		
		Task newTask = new Task();
		
		newTask.setName(task.getName());
		newTask.setDescription(task.getDescription());
		newTask.setCreatedBy(task.getCreatedBy());
		newTask.setEndDate(task.getEndDate());
		newTask.setCreatedDate(task.getCreatedDate());
		
		taskService.saveTask(newTask);
		model.addAttribute("sucessmsg","Task was created Successfully");
		
		return "home";
		
		
	}
	
}
