package com.example.service;

import java.util.Set;

import com.example.model.User;

public interface UserService {
	
	Set<User> getUsers();
	User getUserById(long id);
	User getUserByName(String userName);

}
