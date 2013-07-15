package com.example.persistence;

import java.util.List;

import com.example.model.Task;

public interface TaskPersistence extends GenericDAO<Task, Long>{

	List<Task> getAllTasks();
	List<Task> getAllTasks(String userName);
}