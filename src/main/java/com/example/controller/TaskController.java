package com.example.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.common.CommonUtils;
import com.example.form.TaskForm;
import com.example.model.Task;
import com.example.model.User;
import com.example.service.TaskService;
import com.example.service.UserService;
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
	
	@RequestMapping(value ="/view/todaystasks", method = RequestMethod.GET)
	public String viewTodaysTasks(HttpSession session,
			Model model) throws ParseException{
		Date today = new Date();
	
		User user = (User)session.getAttribute("user");
		List<Task> tasks = taskService.getAllTasks(user.getEmail());
		List<TaskForm> taskFormList = new ArrayList<TaskForm>();
		
		for (Task task : tasks) {
			if(CommonUtils.isDateSame(today, task.getDate())==0){
				taskFormList.add(populateTaskForm(task));
			}
		}
		model.addAttribute("tasks", taskFormList);
		return "viewTasks";
		
	}
	
	
	@RequestMapping(value="/view/exeriseschedule", method =RequestMethod.GET)
	public String viewExercieSchedule(){
		return "exerciseSchedule";
		
	}

	@RequestMapping(value = "/showCreate", method = RequestMethod.GET)
	public String showCreateTask(Model model,
			@RequestParam(value="from", required=false) String fromPage){
		TaskForm taskForm = new TaskForm();
		model.addAttribute("task", taskForm);
		model.addAttribute("fromPage", fromPage);
		return "createTask";
	}

	/**
	 * method to update/create Task
	 * TODO :Find out why ? * Model has to be preceding Binding Result **
	 * @param task
	 * @param bindingResult
	 * @param model
	 * @param session
	 * @return
	 * @throws ParseException
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String updateTask(@ModelAttribute("task") TaskForm task,BindingResult bindingResult,
			Model model,HttpSession session,
			@RequestParam(value="fromPage",required=false)String fromPage,
			@RequestParam(value="userId",required=false)String userId) throws ParseException {
		Long userIdInt = Long.valueOf(userId);
			User user = (User)session.getAttribute("user");
		    User assignedUser = userService.getUserById(userIdInt);
		    if(userIdInt==0){
		    	assignedUser=user;
		    }
		    
		taskValidator.validate(task, bindingResult);
		if(!bindingResult.hasErrors()){
			Task newTask = populateTaskFromTaskForm(task,user);
			newTask.setAssignedTo(assignedUser);
			newTask.setDone(false);
			taskService.saveTask(newTask);
			model.addAttribute("sucessmsg", "Task was created Successfully");
		}else{
			model.addAttribute("sucessmsg", "Task was Not updated!");
			return "createTask";
		}
		if(("view").equalsIgnoreCase(fromPage.toString())){
			return viewTasks(session,model);
		}
		return "home";

	}

	@RequestMapping(value="/home",method=RequestMethod.GET)
	public String goHome(){
		return "home";
	}
	
	   @RequestMapping(value="/{taskId}",method=RequestMethod.DELETE)
	   @ResponseBody
	   public String deleteTask(@PathVariable String taskId,
			   HttpSession session,Model model)  {
		   taskService.deleteTask(Long.valueOf(taskId));
		   return "successfully completed";
	  }
	   
	   //Making it transactional is solving the problem of closing the session which 
	   //gets closed with transaction.
	   //@Transactional
	   @RequestMapping(value="/showEdit/{taskId}",method=RequestMethod.GET)
	   public String editTask(@PathVariable String taskId,
			   HttpSession session,Model model)  {
		   
		   Task task = taskService.getTask(Long.valueOf(taskId));
		   TaskForm taskForm = populateTaskForm(task);
		   model.addAttribute("task", taskForm);
		   return "createTask";
	  }

	   @RequestMapping(value="/{taskId}", method=RequestMethod.PUT)
	   @ResponseBody
	   public String toggleDone(@PathVariable String taskId,
			   HttpSession session, Model model) {
		   Task task = taskService.getTask(Long.valueOf(taskId));
		   String state = "true";
		   if(task.isDone()){
			   task.setDone(false);
			   state="false";
		   }else{
			   task.setDone(true);
		   }
		   taskService.saveTask(task);
		   return state;
	   }
	   
	   @ModelAttribute
	   public void populateUsers(Model model){
		   List<User> users = userService.getUsers();
		   model.addAttribute("users", users);
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
		persistedTask.setDate(CommonUtils.getFormattedDateWithoutTime(task.getDate()));
		persistedTask.setDone(task.isDone());
		return persistedTask;
	}

	private TaskForm populateTaskForm(Task task) {

		TaskForm newTask = new TaskForm();
		newTask.setId(task.getId());
		newTask.setName(task.getName());
		newTask.setDescription(task.getDescription());
		//here task.getUSer.gertfirstname will not work as our transaction boundries 
		//are within services, and in hibernate Lazy-Loading fetch is not supported outside
		//transanction.
		newTask.setCreatedBy(taskService.getFirstNameOfTaskCreator(task.getId()));
		newTask.setDate(CommonUtils.getFormattedStringFromDate(task.getDate()));
		newTask.setDone(task.isDone());

		return newTask;
	}

}
