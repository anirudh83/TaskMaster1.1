package com.example.service;

import java.text.ParseException;
import java.util.List;

public interface TaskService {
	
	public void saveTask(String name,String description,String date,String personName)throws ParseException;
	public List getTasksOfTheDay(String date);
	public List getAllTasks();
}
