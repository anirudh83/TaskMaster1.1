package com.example.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.common.CommonUtils;
import com.example.form.TaskForm;
import com.example.model.Task;
import com.example.model.User;
import com.example.service.TaskService;
import com.example.validator.TaskValidator;

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
	private TaskValidator taskValidator;

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
	public String updateTask(@ModelAttribute("task") TaskForm task,BindingResult bindingResult,Model model,HttpSession session) throws ParseException {
		User user = (User)session.getAttribute("user");
		taskValidator.validate(model, bindingResult);
		if(!bindingResult.hasErrors()){
			Task newTask = populateTaskFromTaskForm(task,user);
			taskService.updateTask(newTask);
			model.addAttribute("sucessmsg", "Task was created Successfully");
		}else{
			model.addAttribute("sucessmsg", "Task was Not updated!");
		}
		return "createTask";

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
	   
	   @RequestMapping(value="/showEdit/{taskId}",method=RequestMethod.GET)
	   public String editTask(@PathVariable String taskId,
			   HttpSession session,Model model)  {
		   Task task = taskService.getTask(Integer.parseInt(taskId));
		   TaskForm taskForm = populateTaskForm(task);
		   model.addAttribute("task", taskForm);
		   return "createTask";
	  }
	
	
	/**
	 * Takes argument of type TaskForm and gives a new Object of Task
	 * 
	 * @param task
	 * @return
	 * @throws ParseException 
	 */
	private Task populateTaskFromTaskForm(TaskForm task,User user) throws ParseException {
		Task persistedTask = new Task();
		persistedTask.setId(task.getId());
		persistedTask.setName(task.getName());
		persistedTask.setDescription(task.getDescription());
		persistedTask.setCreatedBy(user);
		persistedTask.setDate(CommonUtils.getFormattedDate(task.getDate()));
		return persistedTask;
	}

	private TaskForm populateTaskForm(Task task) {

		TaskForm newTask = new TaskForm();
		newTask.setId(task.getId());
		newTask.setName(task.getName());
		newTask.setDescription(task.getDescription());
		newTask.setCreatedBy(task.getCreatedBy().getFirstName());
		newTask.setDate(CommonUtils.getFormattedStringFromDate(task.getDate()));

		return newTask;
	}

}
