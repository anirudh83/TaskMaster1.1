package com.example.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.common.CommonUtils;
import com.example.model.Task;
import com.example.model.User;
import com.example.persistence.TaskPersistence;
import com.example.service.TaskService;

@Service
@Transactional
public class TaskServiceImpl implements TaskService{
	
	//this is autowiring by Type, it just checks the implemented class of type
	@Autowired
	private TaskPersistence taskPersistence;
	
	public void saveTask(String name,String description,String date,String personName,User user) throws ParseException{
		Task task = new Task();
		task.setName(name);
		task.setDescription(description);
		task.setDate(CommonUtils.getFormattedDate(date));
		task.setCreatedBy(user);
		
		taskPersistence.saveTask(task);
	}
	
	public List<Task> getTasksOfTheDay(String date) {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Task> getAllTasks() {
		return taskPersistence.getAllTasks();
	}
	@Override
	public List<Task> getAllTasks(String userName) {
		return taskPersistence.getAllTasks(userName);
	}
	@Override
	public void deleteTask(int id) {
		taskPersistence.deleteTask(id);
	}
	@Override
	public void saveTask(Task task) {
		taskPersistence.saveTask(task);
	}
	@Override
	public Task getTask(int id) {
		return taskPersistence.getTask(id);
	}

	@Override
	public void updateTask(Task task) {
		taskPersistence.updateTask(task);
	}

	@Override
	public void closeSession() {
		taskPersistence.closeSession();
		
	}

	@Override
	public Task merge(Task task) {
		return taskPersistence.merge(task);
		
	}

	
}
