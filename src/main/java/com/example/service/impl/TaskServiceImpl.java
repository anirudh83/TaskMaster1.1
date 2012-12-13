package com.example.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Task;
import com.example.persistence.TaskPersistence;
import com.example.service.TaskService;

@Service("taskServicebyName")
public class TaskServiceImpl implements TaskService{
	
	//this is autowiring by Type, it just checks the implemented class of type
	@Autowired
	private TaskPersistence taskPersistence;
	
	public void saveTask(String name,String description,String date,String personName) throws ParseException{
		Task task = new Task();
		task.setName(name);
		task.setDescription(description);
		task.setDate(getFormattedDate(date));
		task.setPersonName(personName);
		
		taskPersistence.saveTask(task);
	}
	private Date getFormattedDate(String date) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Date formattedDate = sdf.parse(date);
		return formattedDate;
	}
	public List<Task> getTasksOfTheDay(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Task> getAllTasks() {
		return taskPersistence.getAllTasks();
	}

}
