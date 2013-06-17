package com.example.service;

import java.util.Set;

import com.example.model.User;

public interface UserService {
	
	Set<User> getUsers();
	User getUserById(int id);
	User getUserByEmail(String emailAddress);
	User createUser(User newUser);

}
