package com.example.service;

import java.text.ParseException;

import com.example.model.Task;

public interface TaskService {
	
	public void saveTask(String name,String description,String date,String personName)throws ParseException;
	public Task getTasksOfTheDay(String date);
}
