package com.example.service;

import java.text.ParseException;
import java.util.List;

import com.example.model.Task;

public interface TaskService {
	
	void saveTask(String name,String description,String date,String personName)throws ParseException;
	List<Task> getTasksOfTheDay(String date);
	List<Task> getAllTasks();
}
