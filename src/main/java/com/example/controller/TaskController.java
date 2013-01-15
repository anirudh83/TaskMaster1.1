package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.form.TaskForm;
import com.example.model.Task;
import com.example.model.User;
import com.example.service.TaskService;
import com.example.service.UserService;

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
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	public String viewTasks(HttpSession session,
			Model model) {
		User user = (User)session.getAttribute("user");
		List<Task> tasks = taskService.getAllTasks(user.getEmail());
		List<TaskForm> taskFormList = new ArrayList<TaskForm>();

		for (Task task : tasks) {
			taskFormList.add(populateTaskForm(task));
		}
		model.addAttribute("tasks", taskFormList);
		return "viewTasks";

	}

	@RequestMapping(value = "/showCreate", method = RequestMethod.GET)
	public String showCreateTask(Model model) {
		TaskForm taskForm = new TaskForm();
		model.addAttribute("task", taskForm);
		return "createTask";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createTask(@ModelAttribute("task") TaskForm task, Model model,HttpSession session) {

		User user = (User)session.getAttribute("user");
		Task newTask = populateTaskFromTaskForm(task,user);

		taskService.saveTask(newTask);
		model.addAttribute("sucessmsg", "Task was created Successfully");

		return "home";

	}

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	   @RequestMapping(value="/delete/{taskId}",method=RequestMethod.GET)
	   public String deleteTask(@PathVariable String taskId,
			   HttpSession session,Model model)  {
		   taskService.deleteTask(Integer.parseInt(taskId));
		   return viewTasks(session,model);
	  }
	
	
	/**
	 * Takes argument of type TaskForm and gives a new Object of Task
	 * 
	 * @param task
	 * @return
	 */
	private Task populateTaskFromTaskForm(TaskForm task,User user) {

		Task newTask = new Task();
		newTask.setName(task.getName());
		newTask.setDescription(task.getDescription());
		newTask.setCreatedBy(user);
		newTask.setEndDate(task.getEndDate());
		newTask.setCreatedDate(task.getCreatedDate());
		return newTask;
	}

	private TaskForm populateTaskForm(Task task) {

		TaskForm newTask = new TaskForm();
		newTask.setId(task.getId());
		newTask.setName(task.getName());
		newTask.setDescription(task.getDescription());
		newTask.setCreatedBy(task.getCreatedBy().getFirstName());
		newTask.setEndDate(task.getEndDate());
		newTask.setCreatedDate(task.getCreatedDate());

		return newTask;
	}

}
