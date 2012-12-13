package com.example.persistence;

import java.util.List;

import com.example.model.Task;

public interface TaskPersistence {

	void saveTask(Task task);
	List<Task> getAllTasks();
}