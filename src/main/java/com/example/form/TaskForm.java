package com.example.form;

import java.util.List;


public class TaskForm {
	
	private Long id;
	private String name;
	private String date;
	private String description;
	private String createdBy;
	private List<String> dropDown;
	private boolean done;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public List<String> getDropDown() {
		return dropDown;
	}
	public void setDropDown(List<String> dropDown) {
		this.dropDown = dropDown;
	}
	public boolean isDone() {
		return done;
	}
	public void setDone(boolean done) {
		this.done = done;
	}
	
}
