package com.example.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.example.model.Task;
import com.example.persistence.TaskPersistence;

public class TaskServiceImpl implements TaskService{
	
	//TODO : Change with Spring DI
	private TaskPersistence  taskPersistence = new TaskPersistence();
	
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
	public List getTasksOfTheDay(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	public List getAllTasks() {
		return taskPersistence.getAllTasks();
	}

}
