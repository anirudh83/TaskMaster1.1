package com.example.service;

import java.text.ParseException;
import java.util.List;

import com.example.model.Task;
import com.example.model.User;

public interface TaskService {
	
	void saveTask(String name,String description,String date,String personName,User user)throws ParseException;
	List<Task> getTasksOfTheDay(String date);
	List<Task> getAllTasks();
	List<Task> getAllTasks(String email);
	void deleteTask(int id);
	void saveTask(Task task);
}
