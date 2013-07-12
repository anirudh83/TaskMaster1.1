package com.example.service;

import java.util.List;

import com.example.model.User;

public interface UserService {
	
	List<User> getUsers();
	User getUserById(int id);
	User getUserByEmail(String emailAddress);
	User createUser(User newUser);

}
